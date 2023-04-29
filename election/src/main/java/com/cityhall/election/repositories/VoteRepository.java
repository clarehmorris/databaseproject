package com.cityhall.election.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.Votes;

public interface VoteRepository extends JpaRepository<Votes, Integer> {
    
}
