package com.cityhall.election.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import com.cityhall.election.entities.Votes;
import com.cityhall.election.repositories.VoteRepository;


@RestController
@RequestMapping("votes")
public class VotesController {

  @Autowired
  private VoteRepository repo;

  @GetMapping("/")
  //Returns all entities in the Votes Table
  public ResponseEntity<List<Votes>> getAllVotes() {

    return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);

  }

  @PostMapping("/{vote_id}")
  //creates a Votes entity
  public ResponseEntity<Votes> createVote(
                                        @PathVariable(value = "vote_id") Integer vote_id,
                                        @RequestParam(required = true) Integer candidate_id,
                                        @RequestParam(required = true) Integer poll_id,
                                        @RequestParam(required = true) Integer election_id
                                    ) {
                            
    if (repo.findById(vote_id).orElse(null) != null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Votes newVote = Votes.builder()
      .candidate_id(candidate_id)
      .poll_id(poll_id)
      .election_id(election_id)
      .vote_id(vote_id)
      .build();

    repo.save(newVote);

    return new ResponseEntity<>(newVote, HttpStatus.OK);
  }

}
