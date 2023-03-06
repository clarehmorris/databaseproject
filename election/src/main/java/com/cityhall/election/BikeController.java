package com.cityhall.election;

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

import com.cityhall.election.entities.Bikes;
import com.cityhall.election.repositories.BikesRepository;

@RestController
public class BikeController {

  @Autowired
  private BikesRepository bikesRepo;
    
  @GetMapping("/bikes/")
  public ResponseEntity<List<Bikes>> getAllBikes() {

    return new ResponseEntity<>(bikesRepo.findAll(), HttpStatus.OK);

  }

  @GetMapping("/bikes/{bikeid}")
  public ResponseEntity<Bikes> getBikeBasedOnId(
                                        @PathVariable(value = "bikeid") String bikeid
                                      ) {
    if (bikesRepo.findById(bikeid).orElse(null) == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    return new ResponseEntity<>(bikesRepo.findById(bikeid).orElse(null), HttpStatus.OK);

  }

  @PutMapping("/bikes/{bikeid}")
  public ResponseEntity<Bikes> updateBikeBasedOnId(
                                        @PathVariable(value = "bikeid") String bikeid,
                                        @RequestParam(required = false) Integer yearpurchased,
                                        @RequestParam(required = false) String color,
                                        @RequestParam(required = false) String bsize,
                                        @RequestParam(required = false) String bstyle,
                                        @RequestParam(required = false) String bavailable
                                      ) {
    
    Bikes bike = bikesRepo.findById(bikeid).orElse(null);
    if (bike == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    if (yearpurchased != null) {
      bike.setYearpurchased(yearpurchased);
    }
    if (color != null) {
      bike.setColor(color);
    }
    if (bsize != null) {
      bike.setBsize(bsize);
    }
    if (bstyle != null) {
      bike.setBsize(bsize);
    }
    if (bavailable != null) {
      bike.setBavailable(bavailable);
    }

    bikesRepo.save(bike);
    
    return new ResponseEntity<>(bike, HttpStatus.OK);

  }

  @PostMapping("/bikes/")
  public ResponseEntity<Bikes> createBike(
                            @RequestParam String bikeid,
                            @RequestParam(required = false) Integer yearpurchased,
                            @RequestParam(required = false) String color,
                            @RequestParam(required = false) String bsize,
                            @RequestParam String bstyle,
                            @RequestParam(required = false) String bavailable
                          ) {
                            
    if (bikesRepo.findById(bikeid).orElse(null) != null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Bikes newBike = Bikes.builder()
                        .bikeid(bikeid)
                        .yearpurchased(yearpurchased)
                        .color(color)
                        .bsize(bsize)
                        .bstyle(bstyle)
                        .bavailable(bavailable)
                        .build();

    bikesRepo.save(newBike);

    return new ResponseEntity<>(newBike, HttpStatus.OK);
  }

  @DeleteMapping("/bikes/{bikeid}")
  public ResponseEntity<String> deleteBike(@PathVariable(value = "bikeid") String bikeid) {
    Bikes bike = bikesRepo.findById(bikeid).orElse(null);
    bikesRepo.delete(bike);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
