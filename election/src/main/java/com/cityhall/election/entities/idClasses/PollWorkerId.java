package com.cityhall.election.entities.idClasses;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollWorkerId implements Serializable {

    private String ssn;

    private Integer election_id;


    public PollWorkerId() {}

    public PollWorkerId(String ssn, Integer election_id) {
        this.ssn = ssn;
        this.election_id = election_id;
    }
}
