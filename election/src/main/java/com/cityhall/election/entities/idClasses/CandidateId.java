package com.cityhall.election.entities.idClasses;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateId implements Serializable {

    private Integer candidate_id;

    private Integer election_id;

    public CandidateId() {}

    public CandidateId(Integer candidate_id, Integer election_id) {
        this.candidate_id = candidate_id;
        this.election_id = election_id;
    }
}
