package com.cityhall.election.entities;

import com.cityhall.election.entities.idClasses.PreviouslyElectedId;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@IdClass(PreviouslyElectedId.class)
@Table(name = "PREVIOUSLY_ELECTED")
public class PreviouslyElected {

    @Id
    private Integer election_id;

    private Integer term_num;

    @Id
    private String ssn;

    @Id
    private Integer office_id;

    private Boolean currently_in_office;

    public PreviouslyElected() {}

    public PreviouslyElected(Integer election_id, Integer term_num, String ssn, Integer office_id, Boolean currently_in_office) {
        this.election_id = election_id;
        this.term_num = term_num;
        this.ssn = ssn;
        this.office_id = office_id;
        this.currently_in_office = currently_in_office;
    }
    
}
