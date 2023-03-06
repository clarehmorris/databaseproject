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

    private String name;

    private String address;

    private Integer num_booths;

    public PollingLocation() {}

    public PollingLocation(Integer poll_id, String name, String address, Integer num_booths) {
        this.poll_id = poll_id;
        this.name = name;
        this.address = address;
        this.num_booths = num_booths;
    }
    
}
