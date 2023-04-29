package com.cityhall.election.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "OFFICE")
public class Office {
    
    @Id
    private Integer office_id;

    private String office_name;

}
