package com.cityhall.election.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.Candidate;
import com.cityhall.election.entities.idClasses.CandidateId;

public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {

}
