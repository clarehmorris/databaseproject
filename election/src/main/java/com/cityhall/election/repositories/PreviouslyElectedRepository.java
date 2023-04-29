package com.cityhall.election.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.PreviouslyElected;
import com.cityhall.election.entities.idClasses.PreviouslyElectedId;

public interface PreviouslyElectedRepository extends JpaRepository<PreviouslyElected, PreviouslyElectedId> {
    
}
