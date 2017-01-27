package com.example.batchcsvpostgresql.model;

import org.springframework.context.annotation.Role;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

//@Entity
//@Table(name = "user")
public class TeamMember {
    public static enum StoreName {ACD, BDN, BLT, BMR, BOI, BSL, CCK, CER, CFX, COL, CPH, DPR, FCO, FTC, HDR, HLR, IDL, ISP, LTT, MET, NCP, OLA, OPK, PKC, PPK, PRL, SGN, STF, SUH, SUP, TMC, TSQ, WIC, WSP};
    private long teamMemberId;
    private String username;
    private String password;
    private StoreName storeName;
    private List<String> departments;

    public long getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(long teamMemberId) {
        this.teamMemberId = teamMemberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}