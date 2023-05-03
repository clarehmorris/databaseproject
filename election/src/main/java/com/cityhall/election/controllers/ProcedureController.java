package com.cityhall.election.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cityhall.election.services.ProcedureService;

@RestController
@RequestMapping("/procedure")
public class ProcedureController {

    private final ProcedureService procedureService;

    public ProcedureController(ProcedureService updateService) {
        this.procedureService = updateService;
    }

    @PostMapping("/updateCurrentInOffice")
    public ResponseEntity<String> updateCurrentlyInOffice(@RequestParam("electionId") int electionId) {

        procedureService.updateCurrentlyInOffice(electionId);
        return ResponseEntity.ok("Updated currently_in_office for electionId " + electionId);

    }
}

