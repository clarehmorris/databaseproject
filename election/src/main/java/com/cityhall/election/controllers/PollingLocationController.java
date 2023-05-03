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

import com.cityhall.election.entities.PollingLocation;
import com.cityhall.election.repositories.PollingLocationRepository;

@RestController
@RequestMapping("pollinglocation")
public class PollingLocationController {

  @Autowired
  private PollingLocationRepository repo;

  @GetMapping("/")
  //Returns all entities in the PollingLocation Table
  public ResponseEntity<List<PollingLocation>> getAllPollingLocations() {

    return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);

  }

  @GetMapping("/{poll_id}")
  //Returns spcecific entity in the PollingLocation Table based on poll_id
  public ResponseEntity<PollingLocation> getPollingLocationBasedOnId(
                                        @PathVariable(value = "poll_id") Integer poll_id
                                      ) {

    if (repo.findById(poll_id).orElse(null) == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    return new ResponseEntity<>(repo.findById(poll_id).orElse(null), HttpStatus.OK);

  }

  @PutMapping("/{poll_id}")
  //Updates a PollingLocation entity
  public ResponseEntity<PollingLocation> updatePollingLocationBasedOnId(
                                        @PathVariable(value = "poll_id") Integer poll_id,
                                        @RequestParam(required = false) String poll_name,
                                        @RequestParam(required = false) String street,
                                        @RequestParam(required = false) String city,
                                        @RequestParam(required = false) String state,
                                        @RequestParam(required = false) String zip,
                                        @RequestParam(required = false) Integer num_booths
                                      ) {
    
    PollingLocation pollingLocation = repo.findById(poll_id).orElse(null);
    
    if (pollingLocation == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    if (poll_name != null) {
        pollingLocation.setPoll_name(poll_name);
    }

    if (street != null) {
        pollingLocation.setStreet(street);
    }

    if (city != null) {
        pollingLocation.setCity(city);
    }

    if (state != null) {
        pollingLocation.setState(state);
    }

    if (zip != null) {
        pollingLocation.setZip(zip);
    }

    if (num_booths != null) {
        pollingLocation.setNum_booths(num_booths);
    }

    repo.save(pollingLocation);
    
    return new ResponseEntity<>(pollingLocation, HttpStatus.OK);

  }

  @PostMapping("/{poll_id}")
  //creates a PollingLocation entity
  public ResponseEntity<PollingLocation> createPollingLocation(
                                        @PathVariable(value = "poll_id") Integer poll_id,
                                        @RequestParam(required = true) String poll_name,
                                        @RequestParam(required = true) String street,
                                        @RequestParam(required = true) String city,
                                        @RequestParam(required = true) String state,
                                        @RequestParam(required = true) String zip,
                                        @RequestParam(required = true) Integer num_booths
                                    ) {
                            
    if (repo.findById(poll_id).orElse(null) != null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    PollingLocation newPollingLocation = PollingLocation.builder()
      .poll_id(poll_id)
      .poll_name(poll_name)
      .street(street)
      .city(city)
      .state(state)
      .zip(zip)
      .num_booths(num_booths)
      .build();

    repo.save(newPollingLocation);

    return new ResponseEntity<>(newPollingLocation, HttpStatus.OK);
  }

  @DeleteMapping("/{poll_id}")
  //deletes a PollingLocation entity
  public ResponseEntity<String> deletePollingLocation(@PathVariable(value = "poll_id") Integer poll_id) {
    try {
      repo.deleteById(poll_id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch(Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
