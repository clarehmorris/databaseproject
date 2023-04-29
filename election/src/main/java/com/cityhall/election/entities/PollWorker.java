package com.cityhall.election.entities;

import com.cityhall.election.entities.idClasses.PollWorkerId;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
@Entity
@IdClass(PollWorkerId.class)
@Table(name = "POLL_WORKERS")
public class PollWorker {
    
    @Id
    private String ssn;

    @Id
    private Integer election_id;

    private Integer poll_id;

    public PollWorker() {}

    public PollWorker(String ssn, Integer election_id, Integer poll_id) {
        this.ssn = ssn;
        this.election_id = election_id;
        this.poll_id = poll_id;
    }
}
