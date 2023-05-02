package com.cityhall.election.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.PreviouslyElected;
import com.cityhall.election.entities.idClasses.PreviouslyElectedId;

public interface PreviouslyElectedRepository extends JpaRepository<PreviouslyElected, PreviouslyElectedId> {
    List<PreviouslyElected> findByElectionId(Integer electionId);
}
