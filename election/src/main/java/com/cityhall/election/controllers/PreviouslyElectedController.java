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

import com.cityhall.election.entities.PreviouslyElected;
import com.cityhall.election.entities.idClasses.PreviouslyElectedId;
import com.cityhall.election.repositories.PreviouslyElectedRepository;

@RestController
@RequestMapping("previously-elected")
public class PreviouslyElectedController {
    
    @Autowired
    private PreviouslyElectedRepository repo;
    
    @GetMapping("/")
    //Returns all entities in the previously_elected Table
    public ResponseEntity<List<PreviouslyElected>> getAllCandidates() {

    return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    
    }   

    @GetMapping("/election/{election_id}/ssn/{ssn}/office_id/{office_id}")
    //Returns spcecific entity in the previously_elected Table based on election_id, ssn, & office_id
    public ResponseEntity<PreviouslyElected> getPreviouslyElectedBasedOnId(
                                        @PathVariable(value = "election_id") Integer election_id,
                                        @PathVariable(value = "ssn") String ssn,
                                        @PathVariable(value = "office_id") Integer office_id
                                    ) {
      
        PreviouslyElectedId previouslyElectedId = PreviouslyElectedId.builder()
            .election_id(election_id)
            .ssn(ssn)
            .office_id(office_id)
            .build();

        if (repo.findById(previouslyElectedId).orElse(null) == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(repo.findById(previouslyElectedId).orElse(null), HttpStatus.OK);

    }

    @PutMapping("/election/{election_id}/ssn/{ssn}/office_id/{office_id}")
    //Updates a PreviouslyElected entity
    public ResponseEntity<PreviouslyElected> updatePreviouslyElectedBasedOnId(
                                        @PathVariable(value = "election_id")  Integer election_id,
                                        @PathVariable(value = "ssn") String ssn,
                                        @PathVariable(value = "office_id") Integer office_id,
                                        @RequestParam(required = false) Integer term_num,
                                        @RequestParam(required = false) Boolean currently_in_office
                                    ) {
        PreviouslyElectedId previouslyElectedId = PreviouslyElectedId.builder()
            .election_id(election_id)
            .ssn(ssn)
            .office_id(office_id)
            .build();

        PreviouslyElected previouslyElected = repo.findById(previouslyElectedId).orElse(null);

        if (previouslyElected == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (term_num != null) {
            previouslyElected.setTerm_num(term_num);
        }
        if (currently_in_office != null) {
            previouslyElected.setCurrently_in_office(currently_in_office);
        }

        repo.save(previouslyElected);
        
        return new ResponseEntity<>(previouslyElected, HttpStatus.OK);

    }

    @PostMapping("/election/{election_id}/ssn/{ssn}/office_id/{office_id}")
    //creates a PreviouslyElected entity
    public ResponseEntity<PreviouslyElected> createPreviouslyElected(
                                        @PathVariable(value = "election_id")  Integer election_id,
                                        @PathVariable(value = "ssn") String ssn,
                                        @PathVariable(value = "office_id") Integer office_id,
                                        @RequestParam(required = true) Integer term_num,
                                        @RequestParam(required = true) Boolean currently_in_office
                                      ) {

        PreviouslyElectedId previouslyElectedId = PreviouslyElectedId.builder()
            .election_id(election_id)
            .ssn(ssn)
            .office_id(office_id)
            .build();
                                                          
        if (repo.findById(previouslyElectedId).orElse(null) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PreviouslyElected newPreviouslyElected = PreviouslyElected.builder()
            .election_id(election_id)
            .term_num(term_num)
            .ssn(ssn)
            .office_id(office_id)
            .currently_in_office(currently_in_office)
            .build();

        repo.save(newPreviouslyElected);

        return new ResponseEntity<>(newPreviouslyElected, HttpStatus.OK);
    }

    @DeleteMapping("/election/{election_id}/ssn/{ssn}/office_id/{office_id}")
    //deletes a PreviouslyElected entity
    public ResponseEntity<String> deleteCandidate(
                                            @PathVariable(value = "election_id")  Integer election_id,
                                            @PathVariable(value = "ssn") String ssn,
                                            @PathVariable(value = "office_id") Integer office_id
                                        ) {

        PreviouslyElectedId previouslyElectedId = PreviouslyElectedId.builder()
            .election_id(election_id)
            .ssn(ssn)
            .office_id(office_id)
            .build();
        
        if (repo.findById(previouslyElectedId).orElse(null) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        repo.deleteById(previouslyElectedId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
