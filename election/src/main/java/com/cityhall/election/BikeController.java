package com.cityhall.election;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.cityhall.election.entities.Bikes;
import com.cityhall.election.repositories.BikesRepository;

@RestController
public class BikeController {

    @Autowired
	private BikesRepository bikesRepo;
    
	@GetMapping("/bikes/")
    public List<Bikes> getAllBikes() {

		return bikesRepo.findAll();
    
    }
}
