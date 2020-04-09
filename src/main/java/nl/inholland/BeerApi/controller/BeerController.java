package nl.inholland.BeerApi.controller;

import nl.inholland.BeerApi.model.Beer;
import nl.inholland.BeerApi.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("Beer")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost"} )
public class BeerController {

  @Autowired private BeerService service;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity getAllBeers() {

    List<Beer> beers = service.getAllBeers();
    return ResponseEntity.status(200).body(beers);
  }
}