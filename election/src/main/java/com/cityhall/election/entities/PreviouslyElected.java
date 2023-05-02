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
    @Column(name="election_id")
    private Integer electionId;

    private Integer term_num;

    @Id
    private String ssn;

    @Id
    private Integer office_id;

    private Character currently_in_office;

    public PreviouslyElected() {}

    public PreviouslyElected(Integer electionId, Integer term_num, String ssn, Integer office_id, Character currently_in_office) {
        this.electionId = electionId;
        this.term_num = term_num;
        this.ssn = ssn;
        this.office_id = office_id;
        this.currently_in_office = currently_in_office;
    }
    
}
