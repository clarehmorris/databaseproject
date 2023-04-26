package com.cityhall.election.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.Voter;

public interface VoterRepository extends JpaRepository<Voter, String> {

}
