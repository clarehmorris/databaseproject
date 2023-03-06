package com.cityhall.election.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.PollingLocation;

public interface PollingLocationRepository extends JpaRepository<PollingLocation, String> {
    
}
