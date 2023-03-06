package com.cityhall.election.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.Vote;

public interface VoteRepository extends JpaRepository<Vote, String> {
    
}
