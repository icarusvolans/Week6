package com.example.batchcsvpostgresql.web.dto;
//
//import com.example.batchcsvpostgresql.validation.PasswordMatches;
//import com.example.batchcsvpostgresql.validation.ValidEmail;
//import com.example.batchcsvpostgresql.validation.ValidPassword;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

//@PasswordMatches
public class TeamMemberDto {
    @NotNull
    @Size(min = 1)
    private String firstName;

    @NotNull
    @Size(min = 1)
    private String lastName;

//    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

//    @ValidEmail
    @NotNull
    @Size(min = 1)
    private String email;

    private boolean isUsing2FA;

    private Integer role;


    public static enum StoreName {ACD, BDN, BLT, BMR, BOI, BSL, CCK, CER, CFX, COL, CPH, DPR, FCO, FTC, HDR, HLR, IDL, ISP, LTT, MET, NCP, OLA, OPK, PKC, PPK, PRL, SGN, STF, SUH, SUP, TMC, TSQ, WIC, WSP}

    ;

    @NotNull
    @NotEmpty
    private StoreName storeName;

    private List<String> departments;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public StoreName getStoreName() {
        return storeName;
    }

    public void setStoreName(StoreName storeName) {
        this.storeName = storeName;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }


    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("TeamMemberDto [firstName=").append(firstName).append(", lastName=").append(lastName).append(", password=").append(password).append(", matchingPassword=").append(matchingPassword).append(", email=").append(email).append(", isUsing2FA=")
                .append(isUsing2FA).append(", role=").append(role).append(", storeName=").append(storeName).append(", departments=").append(departments).append("]");
        return builder.toString();
    }
}