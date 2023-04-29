package com.cityhall.election.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cityhall.election.entities.PollWorker;
import com.cityhall.election.entities.idClasses.PollWorkerId;

public interface PollWorkerRepository extends JpaRepository<PollWorker, PollWorkerId> {
    
}
