package com.cityhall.election.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
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

}
