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

}
