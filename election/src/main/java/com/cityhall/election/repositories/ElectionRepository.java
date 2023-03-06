package com.cityhall.election.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.Election;

public interface ElectionRepository extends JpaRepository<Election, String> {
    
}
