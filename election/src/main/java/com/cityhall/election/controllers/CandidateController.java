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

import com.cityhall.election.entities.Candidate;
import com.cityhall.election.entities.idClasses.CandidateId;
import com.cityhall.election.repositories.CandidateRepository;

@RestController
@RequestMapping("candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository repo;

    @GetMapping("/")
    //Returns all entities in the Candidate Table
    public ResponseEntity<List<Candidate>> getAllCandidates() {

      return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{candidate_id}/election/{election_id}")
    //Returns spcecific entity in the Candidate Table based on candidate_id & election_id
    public ResponseEntity<Candidate> getCandidateBasedOnId(
                                          @PathVariable(value = "candidate_id") Integer candidate_id,
                                          @PathVariable(value = "election_id") Integer election_id
                                        ) {
      
      CandidateId candidateId = CandidateId.builder()
        .election_id(election_id)
        .candidate_id(candidate_id)
        .build();

      if (repo.findById(candidateId).orElse(null) == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

      return new ResponseEntity<>(repo.findById(candidateId).orElse(null), HttpStatus.OK);

    }

    @PutMapping("/{candidate_id}/election/{election_id}")
    //Updates a Candidate entity
    public ResponseEntity<Candidate> updateCandidateBasedOnCandidateIdAndElectionId(
                                          @PathVariable(value = "candidate_id") Integer candidate_id,
                                          @PathVariable(value = "election_id")  Integer election_id,
                                          @RequestParam(required = false) String ssn,
                                          @RequestParam(required = false) Integer office_id
                                        ) {
      CandidateId candidateId = CandidateId.builder()
        .election_id(election_id)
        .candidate_id(candidate_id)
        .build();

      Candidate candidate = repo.findById(candidateId).orElse(null);

      if (candidate == null) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }

      if (election_id != null) {
        candidate.setElection_id(election_id);
      }
      if (ssn != null) {
        candidate.setSsn(ssn);
      }
      if (office_id != null) {
        candidate.setOffice_id(office_id);
      }

      repo.save(candidate);
      
      return new ResponseEntity<>(candidate, HttpStatus.OK);

    }

    @PostMapping("/{candidate_id}/election/{election_id}")
    //creates a candidate entity
    public ResponseEntity<Candidate> createCandidate(
                                          @PathVariable(value = "candidate_id") Integer candidate_id,
                                          @PathVariable(value = "election_id") Integer election_id,
                                          @RequestParam(required = true) String ssn,
                                          @RequestParam(required = true) Integer office_id
                                      ) {

      CandidateId candidateId = CandidateId.builder()
        .election_id(election_id)
        .candidate_id(candidate_id)
        .build();
                                                          
      if (repo.findById(candidateId).orElse(null) != null) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }

      Candidate newCandidate = Candidate.builder()
        .candidate_id(candidate_id)
        .election_id(election_id)
        .ssn(ssn)
        .office_id(office_id)
        .build();

      repo.save(newCandidate);

      return new ResponseEntity<>(newCandidate, HttpStatus.OK);
    }

    @DeleteMapping("/{candidate_id}/election/{election_id}")
    //deletes a candidate entity
    public ResponseEntity<String> deleteCandidate(
                                          @PathVariable(value = "candidate_id") Integer candidate_id,
                                          @PathVariable(value = "election_id")  Integer election_id
                                        ) {
      CandidateId candidateId = CandidateId.builder()
        .election_id(election_id)
        .candidate_id(candidate_id)
        .build();
        
      if (repo.findById(candidateId).orElse(null) == null) {
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }

      repo.deleteById(candidateId);

      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
