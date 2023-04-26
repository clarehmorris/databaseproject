package com.cityhall.election.entities;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "VOTER")
public class Voter {
    
    @Id
    String ssn;

    String fname;

    String minit;

    String lname;

    Date dob;

    String street;

    String city;

    String state;

    String zip;

    Integer poll_id;

    public Voter(){}

    public Voter(String ssn, String fname, String minit, String lname, Date dob, String street, String city, String state, String zip, Integer poll_id) {
        
        this.ssn = ssn;
        this.fname = fname;
        this.minit = minit;
        this.lname = lname;
        this.dob = dob;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.poll_id = poll_id;
        
    }

}
