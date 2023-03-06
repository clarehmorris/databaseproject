package com.cityhall.election.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "ELECTION")
public class Election {
    
    @Id
    private Integer election_id;

    private String date;

    public Election() {}

    public Election(Integer election_id, String date) {
        this.election_id = election_id;
        this.date = date;
    }
}
