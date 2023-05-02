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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("previously-elected")
public class PreviouslyElectedController {
    
    @Autowired
    private PreviouslyElectedRepository repo;
    
    @GetMapping("/")
    @Operation(description = "Returns all entities in the previously_elected Table")
    public ResponseEntity<List<PreviouslyElected>> getAllCandidates() {

        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    
    }   

    @GetMapping("/election/{electionId}/ssn/{ssn}/office_id/{office_id}")
    @Operation(description = "Returns spcecific entity in the previously_elected Table based on election_id, ssn, & office_id")
    public ResponseEntity<PreviouslyElected> getPreviouslyElectedBasedOnId(
                                        @PathVariable(value = "electionId") Integer electionId,
                                        @PathVariable(value = "ssn") String ssn,
                                        @PathVariable(value = "office_id") Integer office_id
                                    ) {
      
        PreviouslyElectedId previouslyElectedId = PreviouslyElectedId.builder()
            .electionId(electionId)
            .ssn(ssn)
            .office_id(office_id)
            .build();

        if (repo.findById(previouslyElectedId).orElse(null) == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(repo.findById(previouslyElectedId).orElse(null), HttpStatus.OK);

    }

    @PutMapping("/election/{electionId}/ssn/{ssn}/office_id/{office_id}")
    @Operation(description = "Updates a PreviouslyElected entity")
    public ResponseEntity<PreviouslyElected> updatePreviouslyElectedBasedOnId(
                                        @PathVariable(value = "electionId")  Integer electionId,
                                        @PathVariable(value = "ssn") String ssn,
                                        @PathVariable(value = "office_id") Integer office_id,
                                        @RequestParam(required = false) Integer term_num,
                                        @RequestParam(required = false) Character currently_in_office
                                    ) {
        PreviouslyElectedId previouslyElectedId = PreviouslyElectedId.builder()
            .electionId(electionId)
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

    @PostMapping("/election/{electionId}/ssn/{ssn}/office_id/{office_id}")
    @Operation(description = "creates a PreviouslyElected entity")
    public ResponseEntity<PreviouslyElected> createPreviouslyElected(
                                        @PathVariable(value = "electionId")  Integer electionId,
                                        @PathVariable(value = "ssn") String ssn,
                                        @PathVariable(value = "office_id") Integer office_id,
                                        @RequestParam(required = true) Integer term_num,
                                        @RequestParam(required = true) Character currently_in_office
                                      ) {

        PreviouslyElectedId previouslyElectedId = PreviouslyElectedId.builder()
            .electionId(electionId)
            .ssn(ssn)
            .office_id(office_id)
            .build();
                                                          
        if (repo.findById(previouslyElectedId).orElse(null) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PreviouslyElected newPreviouslyElected = PreviouslyElected.builder()
            .electionId(electionId)
            .term_num(term_num)
            .ssn(ssn)
            .office_id(office_id)
            .currently_in_office(currently_in_office)
            .build();

        repo.save(newPreviouslyElected);

        return new ResponseEntity<>(newPreviouslyElected, HttpStatus.OK);
    }

    @DeleteMapping("/election/{electionId}/ssn/{ssn}/office_id/{office_id}")
    @Operation(description = "deletes a PreviouslyElected entity")
    public ResponseEntity<String> deleteCandidate(
                                            @PathVariable(value = "electionId")  Integer electionId,
                                            @PathVariable(value = "ssn") String ssn,
                                            @PathVariable(value = "office_id") Integer office_id
                                        ) {

        PreviouslyElectedId previouslyElectedId = PreviouslyElectedId.builder()
            .electionId(electionId)
            .ssn(ssn)
            .office_id(office_id)
            .build();
        
        if (repo.findById(previouslyElectedId).orElse(null) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        repo.deleteById(previouslyElectedId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/election/{electionId}/")
    @Operation(description = "Updates currently_in_office elected to N. Procedure 2")
    public ResponseEntity<PreviouslyElected> updatePreviouslyElectedBasedOnId(
                                        @RequestParam(required = false) Integer electionId
                                    ) {

        List<PreviouslyElected> formerlyElected = repo.findByElectionId(electionId);

        formerlyElected.forEach(official -> {
            official.setCurrently_in_office('N');
            repo.save(official);
        });

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
