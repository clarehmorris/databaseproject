package com.cityhall.election.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "VOTES")
public class Votes {

    private Integer candidate_id;

    private Integer poll_id;

    private Integer election_id;

    @Id
    private Integer vote_id;

    public Votes() {}

    public Votes(Integer candidate_id, Integer poll_id, Integer election_id, Integer vote_id) {
        this.candidate_id = candidate_id;
        this.poll_id = poll_id;
        this.election_id = election_id;
        this.vote_id = vote_id;
    }

}
