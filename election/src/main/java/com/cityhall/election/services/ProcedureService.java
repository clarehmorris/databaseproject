package com.cityhall.election.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProcedureService {

    private final JdbcTemplate jdbcTemplate;

    public ProcedureService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateCurrentlyInOffice(int electionId) {
        String sql = "begin update_currently_in_office(?); end;";
        jdbcTemplate.update(sql, electionId);
    }

}
