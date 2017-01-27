package com.example.batchcsvpostgresql.dao;

import com.example.batchcsvpostgresql.model.TeamMember;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by admin on 1/26/17.
 */
public interface TeamMemberDao extends CrudRepository<TeamMember, Long> {
    TeamMember findByUsername(String username);

}
