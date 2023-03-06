package com.cityhall.election.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.PreviouslyElected;

public interface PreviouslyElectedRepository extends JpaRepository<PreviouslyElected, String> {
    
}
