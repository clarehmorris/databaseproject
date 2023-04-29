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

import com.cityhall.election.entities.Office;
import com.cityhall.election.repositories.OfficeRepository;

@RestController
@RequestMapping("office")
public class OfficeController {

  @Autowired
  private OfficeRepository repo;

  @GetMapping("/")
  //Returns all entities in the Office Table
  public ResponseEntity<List<Office>> getAllElections() {

    return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);

  }

  @GetMapping("/{office_id}")
  //Returns spcecific entity in the Office Table based on office_id
  public ResponseEntity<Office> getOfficeBasedOnId(
                                        @PathVariable(value = "office_id") Integer office_id
                                      ) {

    if (repo.findById(office_id).orElse(null) == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    return new ResponseEntity<>(repo.findById(office_id).orElse(null), HttpStatus.OK);

  }

  @PutMapping("/{office_id}")
  //Updates a Office entity
  public ResponseEntity<Office> updateOfficeBasedOnId(
                                        @PathVariable(value = "office_id") Integer office_id,
                                        @RequestParam(required = false) String office_name
                                      ) {
    
    Office office = repo.findById(office_id).orElse(null);
    if (office == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    if (office_name != null) {
        office.setOffice_name(office_name);
    }

    repo.save(office);
    
    return new ResponseEntity<>(office, HttpStatus.OK);

  }

  @PostMapping("/{office_id}")
  //creates a Office entity
  public ResponseEntity<Office> createOffice(
                                        @PathVariable(value = "office_id") Integer office_id,
                                        @RequestParam(required = true) String office_name
                                    ) {
                            
    if (repo.findById(office_id).orElse(null) != null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Office newOffice = Office.builder()
                        .office_id(office_id)
                        .office_name(office_name)
                        .build();

    repo.save(newOffice);

    return new ResponseEntity<>(newOffice, HttpStatus.OK);
  }

  @DeleteMapping("/{office_id}")
  //deletes a Office entity
  public ResponseEntity<String> deleteOffice(@PathVariable(value = "office_id") Integer office_id) {
    try {
      repo.deleteById(office_id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch(Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
