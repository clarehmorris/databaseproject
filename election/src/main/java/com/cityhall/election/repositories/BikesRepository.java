package com.cityhall.election.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cityhall.election.entities.Bikes;

public interface BikesRepository extends JpaRepository<Bikes, String> {
    
}
