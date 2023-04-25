package com.cityhall.election.entities;

import com.cityhall.election.entities.idClasses.CandidateId;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@IdClass(CandidateId.class)
@Table(name = "CANDIDATES")
public class Candidate {
    
    @Id
    private Integer candidate_id;

    @Id
    private Integer election_id;

    private String ssn;

    private Integer office_id;

    public Candidate() {}

    public Candidate(Integer candidate_id, Integer election_id, String ssn, Integer office_id) {
        this.candidate_id = candidate_id;
        this.election_id = election_id;
        this.ssn = ssn;
        this.office_id = office_id;
    }

}
