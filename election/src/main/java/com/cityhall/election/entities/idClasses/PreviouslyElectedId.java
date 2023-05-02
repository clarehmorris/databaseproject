package com.cityhall.election.entities.idClasses;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PreviouslyElectedId implements Serializable {
    
    private Integer electionId;

    private String ssn;

    private Integer office_id;

    public PreviouslyElectedId() {}

    public PreviouslyElectedId(Integer electionId, String ssn, Integer office_id) {
        this.electionId = electionId;
        this.ssn = ssn;
        this.office_id = office_id;
    }

}
