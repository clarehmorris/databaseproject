package com.cityhall.election.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "VOTERS")
public class Voter {
    
    @Id
    String ssn;

    String name;

    String dob;

    String address;

    Integer poll_id;

    public Voter(){}

    public Voter(String ssn, String name, String dob, String address, Integer poll_id) {
        
        this.ssn = ssn;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.poll_id = poll_id;
    }

}
