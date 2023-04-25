package com.cityhall.election.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import com.cityhall.election.entities.Candidate;
import com.cityhall.election.repositories.CandidateRepository;

@RestController
public class CandidateController {

  @Autowired
  private CandidateRepository repo;

  @GetMapping("/candidate/")
  //Returns all entities in the Candidate Table
  public ResponseEntity<List<Candidate>> getAllCandidates() {

    return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);

  }

  @GetMapping("/candidate/{candidate_id}")
  //Returns spcecific entity in the Candidate Table based on candidate_id
  public ResponseEntity<Candidate> getCandidateBasedOnId(
                                        @PathVariable(value = "candidate_id") Integer candidate_id
                                      ) {
    if (repo.findById(candidate_id).orElse(null) == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    return new ResponseEntity<>(repo.findById(candidate_id).orElse(null), HttpStatus.OK);

  }

  @PutMapping("/candidate/{candidate_id}")
  //Updates a Candidate entity
  public ResponseEntity<Candidate> updateCandidateBasedOnId(
                                        @PathVariable(value = "candidate_id") Integer candidate_id,
                                        @RequestParam(required = false) Integer election_id,
                                        @RequestParam(required = false) String ssn,
                                        @RequestParam(required = false) Integer office_id
                                      ) {
    
    Candidate candidate = repo.findById(candidate_id).orElse(null);
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

  @PostMapping("/candidate/")
  //creates a candidate entity
  public ResponseEntity<Candidate> createCandidate(
                                        @PathVariable(value = "candidate_id") Integer candidate_id,
                                        @RequestParam(required = true) Integer election_id,
                                        @RequestParam(required = true) String ssn,
                                        @RequestParam(required = true) Integer office_id
                                    ) {
                            
    if (repo.findById(candidate_id).orElse(null) != null) {
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

  @DeleteMapping("/candidate/{candidate_id}")
  //deletes a candidate entity
  public ResponseEntity<String> deleteCandidate(@PathVariable(value = "candidate_id") Integer candidate_id) {
    Candidate candidate = repo.findById(candidate_id).orElse(null);
    repo.delete(candidate);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
