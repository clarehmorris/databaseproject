package com.cityhall.election.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "BIKES")
public class Bikes {

    @Id
    private String bikeid;

    private Integer yearpurchased;

    private String color;

    private String bsize;

    private String bstyle;

    private String bavailable;

    public Bikes() {}

    public Bikes(String bikeid, Integer yearpurchased, String color, String bsize, String bstyle, String bavailable) {
        this.bikeid = bikeid;
        this.yearpurchased = yearpurchased;
        this.color = color;
        this.bsize = bsize;
        this.bstyle = bstyle;
        this.bavailable = bavailable;
    }

}
