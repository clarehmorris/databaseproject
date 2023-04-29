package com.cityhall.election.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import com.cityhall.election.entities.PollWorker;
import com.cityhall.election.entities.idClasses.PollWorkerId;
import com.cityhall.election.repositories.PollWorkerRepository;

@RestController
@RequestMapping("pollworker")
public class PollWorkerController {
        
    @Autowired
    private PollWorkerRepository repo;
    
    @GetMapping("/")
    //Returns all entities in the pollworker Table
    public ResponseEntity<List<PollWorker>> getAllPollWorkers() {

    return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    
    }   

    @GetMapping("/election/{election_id}/ssn/{ssn}")
    //Returns spcecific entity in the pollworker Table based on election_id, ssn, & office_id
    public ResponseEntity<PollWorker> getPollWorkerBasedOnId(
                                        @PathVariable(value = "election_id") Integer election_id,
                                        @PathVariable(value = "ssn") String ssn
                                    ) {
      
        PollWorkerId pollWorkerId = PollWorkerId.builder()
            .election_id(election_id)
            .ssn(ssn)
            .build();

        if (repo.findById(pollWorkerId).orElse(null) == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(repo.findById(pollWorkerId).orElse(null), HttpStatus.OK);

    }


    @PutMapping("/election/{election_id}/ssn/{ssn}/office_id/{office_id}")
    //Updates a PollWorker entity
    public ResponseEntity<PollWorker> updatePreviouslyElectedBasedOnId(
                                        @PathVariable(value = "election_id")  Integer election_id,
                                        @PathVariable(value = "ssn") String ssn,
                                        @RequestParam(required = false) Integer poll_id
                                    ) {
        PollWorkerId pollWorkerId = PollWorkerId.builder()
            .election_id(election_id)
            .ssn(ssn)
            .build();

        PollWorker pollWorker = repo.findById(pollWorkerId).orElse(null);

        if (pollWorker == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (poll_id != null) {
            pollWorker.setPoll_id(poll_id);
        }

        repo.save(pollWorker);
        
        return new ResponseEntity<>(pollWorker, HttpStatus.OK);

    }

    @PostMapping("/election/{election_id}/ssn/{ssn}")
    //creates a PollWorker entity
    public ResponseEntity<PollWorker> createPreviouslyElected(
                                        @PathVariable(value = "election_id")  Integer election_id,
                                        @PathVariable(value = "ssn") String ssn,
                                        @RequestParam(required = true) Integer poll_id
                                      ) {

        PollWorkerId pollWorkerId = PollWorkerId.builder()
            .election_id(election_id)
            .ssn(ssn)
            .build();
                                                          
        if (repo.findById(pollWorkerId).orElse(null) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PollWorker newPollWorker = PollWorker.builder()
            .election_id(election_id)
            .ssn(ssn)
            .poll_id(poll_id)
            .build();

        repo.save(newPollWorker);

        return new ResponseEntity<>(newPollWorker, HttpStatus.OK);
    }

    @DeleteMapping("/election/{election_id}/ssn/{ssn}")
    //deletes a PreviouslyElected entity
    public ResponseEntity<String> deleteCandidate(
                                            @PathVariable(value = "election_id")  Integer election_id,
                                            @PathVariable(value = "ssn") String ssn
                                        ) {

        PollWorkerId pollWorkerId = PollWorkerId.builder()
            .election_id(election_id)
            .ssn(ssn)
            .build();
        
        if (repo.findById(pollWorkerId).orElse(null) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        repo.deleteById(pollWorkerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
