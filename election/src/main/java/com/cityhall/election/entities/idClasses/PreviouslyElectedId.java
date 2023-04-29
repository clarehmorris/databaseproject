package com.cityhall.election.entities.idClasses;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PreviouslyElectedId implements Serializable {
    
    private Integer election_id;

    private String ssn;

    private Integer office_id;

    public PreviouslyElectedId() {}

    public PreviouslyElectedId(Integer election_id, String ssn, Integer office_id) {
        this.election_id = election_id;
        this.ssn = ssn;
        this.office_id = office_id;
    }

}
