package com.cityhall.election.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.PollWorker;

public interface PollWorkerRepository extends JpaRepository<PollWorker, String> {
    
}
