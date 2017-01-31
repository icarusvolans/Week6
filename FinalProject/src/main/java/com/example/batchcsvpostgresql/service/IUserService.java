package com.example.batchcsvpostgresql.service;

import com.example.batchcsvpostgresql.model.PasswordResetToken;
import com.example.batchcsvpostgresql.model.*;
import com.example.batchcsvpostgresql.model.VerificationToken;
import com.example.batchcsvpostgresql.web.dto.TeamMemberDto;
import com.example.batchcsvpostgresql.web.error.UserAlreadyExistException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IUserService {

    TeamMember registerNewUserAccount(TeamMemberDto accountDto) throws UserAlreadyExistException;

    TeamMember getUser(String verificationToken);

    void saveRegisteredUser(TeamMember teamMember);

    void deleteUser(TeamMember teamMember);

    void createVerificationTokenForUser(TeamMember teamMember, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(TeamMember teamMember, String token);

    TeamMember findUserByEmail(String email);

    PasswordResetToken getPasswordResetToken(String token);

    TeamMember getUserByPasswordResetToken(String token);

    TeamMember getUserByID(long id);

    void changeUserPassword(TeamMember teamMember, String password);

    boolean checkIfValidOldPassword(TeamMember teamMember, String password);

    String validateVerificationToken(String token);

    String generateQRUrl(TeamMember teamMember) throws UnsupportedEncodingException;

    TeamMember updateUser2FA(boolean use2FA);

    List<String> getUsersFromSessionRegistry();

}
