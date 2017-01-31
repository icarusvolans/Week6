package com.example.batchcsvpostgresql.dao;

import com.example.batchcsvpostgresql.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    TeamMember findByEmail(String email);

    @Override
    void delete(TeamMember teamMember);

}
