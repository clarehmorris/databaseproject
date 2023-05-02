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

import java.sql.Date;
import java.util.List;

import com.cityhall.election.entities.Election;
import com.cityhall.election.repositories.ElectionRepository;

@RestController
@RequestMapping("election")
public class ElectionController {

  @Autowired
  private ElectionRepository repo;

  @GetMapping("/")
  //Returns all entities in the Election Table
  public ResponseEntity<List<Election>> getAllElections() {

    return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);

  }

  @GetMapping("/{election_id}")
  //Returns spcecific entity in the Election Table based on election_id
  public ResponseEntity<Election> getElectionBasedOnId(
                                        @PathVariable(value = "election_id") Integer election_id
                                      ) {

    if (repo.findById(election_id).orElse(null) == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    return new ResponseEntity<>(repo.findById(election_id).orElse(null), HttpStatus.OK);

  }

  @PutMapping("/{election_id}")
  //Updates a Election entity
  public ResponseEntity<Election> updateElectionBasedOnId(
                                        @PathVariable(value = "election_id") Integer election_id,
                                        @RequestParam(required = false) Date election_date
                                      ) {
    
    Election election = repo.findById(election_id).orElse(null);
    if (election == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    if (election_date != null) {
      election.setElection_date(election_date);
    }

    repo.save(election);
    
    return new ResponseEntity<>(election, HttpStatus.OK);

  }

  @PostMapping("/{election_id}")
  //creates a Election entity
  public ResponseEntity<Election> createElection(
                                        @PathVariable(value = "election_id") Integer election_id,
                                        @RequestParam(required = true) Date election_date
                                    ) {
                            
    if (repo.findById(election_id).orElse(null) != null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Election newElection = Election.builder()
                        .election_id(election_id)
                        .election_date(election_date)
                        .build();

    repo.save(newElection);

    return new ResponseEntity<>(newElection, HttpStatus.OK);
  }

  @DeleteMapping("/{election_id}")
  //deletes a Election entity
  public ResponseEntity<String> deleteElection(@PathVariable(value = "election_id") Integer election_id) {
    try {
      repo.deleteById(election_id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch(Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
