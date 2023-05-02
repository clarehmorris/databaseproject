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

import com.cityhall.election.entities.Voter;
import com.cityhall.election.repositories.VoterRepository;

@RestController
@RequestMapping("voter")
public class VoterController {

  @Autowired
  private VoterRepository repo;

  @GetMapping("/")
  //Returns all entities in the Voter Table
  public ResponseEntity<List<Voter>> getAllVoter() {

    return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);

  }

  @GetMapping("/{ssn}")
  //Returns spcecific entity in the Voter Table based on poll_id
  public ResponseEntity<Voter> getVoterBasedOnId(
                                        @PathVariable(value = "ssn") String ssn
                                      ) {

    if (repo.findById(ssn).orElse(null) == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    return new ResponseEntity<>(repo.findById(ssn).orElse(null), HttpStatus.OK);

  }

  @PutMapping("/{ssn}")
  //Updates a Voter entity
  public ResponseEntity<Voter> updateVoterBasedOnId(
                                        @PathVariable(value = "ssn") String ssn,
                                        @RequestParam(required = false) String fname,
                                        @RequestParam(required = false) String minit,
                                        @RequestParam(required = false) String lname,
                                        @RequestParam(required = false) Date dob,
                                        @RequestParam(required = false) String street,
                                        @RequestParam(required = false) String city,
                                        @RequestParam(required = false) String state,
                                        @RequestParam(required = false) String zip,
                                        @RequestParam(required = false) Integer poll_id
                                      ) {
    
    Voter voter = repo.findById(ssn).orElse(null);
    
    if (voter == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    if (fname != null) {
        voter.setFname(fname);
    }

    if (minit != null) {
        voter.setMinit(minit);
    }

    if (lname != null) {
        voter.setLname(lname);
    }

    if (dob != null) {
        voter.setDob(dob);
    }

    if (street != null) {
        voter.setStreet(street);
    }

    if (city != null) {
        voter.setCity(city);
    }

    if (state != null) {
        voter.setState(state);
    }

    if (zip != null) {
        voter.setZip(zip);
    }

    if (poll_id != null) {
        voter.setPoll_id(poll_id);
    }

    repo.save(voter);
    
    return new ResponseEntity<>(voter, HttpStatus.OK);

  }

  @PostMapping("/{ssn}")
  //creates a Voter entity
  public ResponseEntity<Voter> createPollingLocation(
                                        @PathVariable(value = "ssn") String ssn,
                                        @RequestParam(required = true) String fname,
                                        @RequestParam(required = false) String minit,
                                        @RequestParam(required = true) String lname,
                                        @RequestParam(required = true) Date dob,
                                        @RequestParam(required = true) String street,
                                        @RequestParam(required = true) String city,
                                        @RequestParam(required = true) String state,
                                        @RequestParam(required = true) String zip,
                                        @RequestParam(required = true) Integer poll_id
                                    ) {
                            
    if (repo.findById(ssn).orElse(null) != null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Voter newPollingLocation = Voter.builder()
        .ssn(ssn)
        .fname(fname)
        .minit(minit)
        .lname(lname)
        .dob(dob)
        .street(street)
        .city(city)
        .state(state)
        .zip(zip)
        .poll_id(poll_id)
        .build();

    repo.save(newPollingLocation);

    return new ResponseEntity<>(newPollingLocation, HttpStatus.OK);
  }

  @DeleteMapping("/{ssn}")
  //deletes a Voter entity
  public ResponseEntity<String> deletePollingLocation(@PathVariable(value = "ssn") String ssn) {
    try {
      repo.deleteById(ssn);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch(Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
