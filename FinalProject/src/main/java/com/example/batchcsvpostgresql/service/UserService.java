package com.example.batchcsvpostgresql.service;

import com.example.batchcsvpostgresql.model.TeamMember;
import com.example.batchcsvpostgresql.dao.PasswordResetTokenRepository;
import com.example.batchcsvpostgresql.dao.RoleRepository;
import com.example.batchcsvpostgresql.dao.TeamMemberRepository;
import com.example.batchcsvpostgresql.dao.VerificationTokenRepository;
import com.example.batchcsvpostgresql.model.PasswordResetToken;
import com.example.batchcsvpostgresql.model.TeamMember;
import com.example.batchcsvpostgresql.model.VerificationToken;
import com.example.batchcsvpostgresql.web.dto.TeamMemberDto;
import com.example.batchcsvpostgresql.web.error.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private TeamMemberRepository repository;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    private PasswordResetTokenRepository passwordTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private SessionRegistry sessionRegistry;

    public static final String TOKEN_INVALID = "invalidToken";
    public static final String TOKEN_EXPIRED = "expired";
    public static final String TOKEN_VALID = "valid";

    public static String QR_PREFIX = "https://chart.googleapis.com/chart?chs=200x200&chld=M%%7C0&cht=qr&chl=";
    public static String APP_NAME = "SpringRegistration";

    // API

    @Override
    public TeamMember registerNewUserAccount(final TeamMemberDto accountDto) {
        if (emailExist(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
        }
        final TeamMember teamMember = new TeamMember();

        teamMember.setFirstName(accountDto.getFirstName());
        teamMember.setLastName(accountDto.getLastName());
        teamMember.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        teamMember.setEmail(accountDto.getEmail());

        return repository.save(teamMember);
    }

    @Override
    public TeamMember getTeamMember(final String verificationToken) {
        final VerificationToken token = tokenRepository.findByToken(verificationToken);
        if (token != null) {
            return token.getTeamMember();
        }
        return null;
    }

    @Override
    public VerificationToken getVerificationToken(final String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

    @Override
    public void saveRegisteredUser(final TeamMember teamMember) {
        repository.save(teamMember);
    }

    @Override
    public void deleteUser(final TeamMember teamMember) {
        final VerificationToken verificationToken = tokenRepository.findByUser(teamMember);

        if (verificationToken != null) {
            tokenRepository.delete(verificationToken);
        }

        final PasswordResetToken passwordToken = passwordTokenRepository.findByUser(teamMember);

        if (passwordToken != null) {
            passwordTokenRepository.delete(passwordToken);
        }

        repository.delete(teamMember);
    }

    @Override
    public void createVerificationTokenForUser(final TeamMember teamMember, final String token) {
        final VerificationToken myToken = new VerificationToken(token, teamMember);
        tokenRepository.save(myToken);
    }

    @Override
    public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
        VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken);
        vToken.updateToken(UUID.randomUUID().toString());
        vToken = tokenRepository.save(vToken);
        return vToken;
    }

    @Override
    public void createPasswordResetTokenForUser(final TeamMember teamMember, final String token) {
        final PasswordResetToken myToken = new PasswordResetToken(token, teamMember);
        passwordTokenRepository.save(myToken);
    }

    @Override
    public TeamMember findUserByEmail(final String email) {
        return repository.findByEmail(email);
    }

    @Override
    public PasswordResetToken getPasswordResetToken(final String token) {
        return passwordTokenRepository.findByToken(token);
    }

    @Override
    public TeamMember getUserByPasswordResetToken(final String token) {
        return passwordTokenRepository.findByToken(token).getTeamMember();
    }

    @Override
    public TeamMember getUserByID(final long id) {
        return repository.findOne(id);
    }

    @Override
    public void changeUserPassword(final TeamMember teamMember, final String password) {
        teamMember.setPassword(passwordEncoder.encode(password));
        repository.save(teamMember);
    }

    @Override
    public boolean checkIfValidOldPassword(final TeamMember teamMember, final String oldPassword) {
        return passwordEncoder.matches(oldPassword, teamMember.getPassword());
    }

    @Override
    public String validateVerificationToken(String token) {
        final VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (verificationToken == null) {
            return TOKEN_INVALID;
        }

        final TeamMember teamMember = verificationToken.getTeamMember();
        final Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            tokenRepository.delete(verificationToken);
            return TOKEN_EXPIRED;
        }

        teamMember.setEnabled(true);
        // tokenRepository.delete(verificationToken);
        repository.save(teamMember);
        return TOKEN_VALID;
    }

    @Override
    public String generateQRUrl(TeamMember teamMember) throws UnsupportedEncodingException {
        return QR_PREFIX + URLEncoder.encode(String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s", APP_NAME, teamMember.getEmail(),  APP_NAME), "UTF-8");
    }


    private boolean emailExist(final String email) {
        return repository.findByEmail(email) != null;
    }

    @Override
    public List<String> getUsersFromSessionRegistry() {
        return sessionRegistry.getAllPrincipals().stream().filter((u) -> !sessionRegistry.getAllSessions(u, false).isEmpty()).map(Object::toString).collect(Collectors.toList());
    }

}




