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

    public Office() {}

    public Office(Integer office_id, String office_name) {
        this.office_id = office_id;
        this.office_name = office_name;
    }

}
