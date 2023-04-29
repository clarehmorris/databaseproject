package com.cityhall.election.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.Office;

public interface OfficeRepository extends JpaRepository<Office, Integer> {

}