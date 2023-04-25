package com.cityhall.election.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    
}
