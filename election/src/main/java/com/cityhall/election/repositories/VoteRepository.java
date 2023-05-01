package com.cityhall.election.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.Votes;

public interface VoteRepository extends JpaRepository<Votes, Integer> {
    List<Votes> findByCandidate_id(Integer candidate_id);
    
}
