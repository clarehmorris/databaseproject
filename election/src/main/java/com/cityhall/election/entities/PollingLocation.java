package com.cityhall.election.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "POLLING_LOCATION")
public class PollingLocation {
    
    @Id
    private Integer poll_id;

    private String poll_name;

    private String street;

    private String city;

    private String state;

    private String zip;

    private Integer num_booths;

    public PollingLocation() {}

    public PollingLocation(Integer poll_id, String poll_name, String street, String city, String state, String zip, Integer num_booths) {
        this.poll_id = poll_id;
        this.poll_name = poll_name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.num_booths = num_booths;
    }
    
}
