package nl.inholland.BeerApi.controller;

import nl.inholland.BeerApi.model.Beer;
import nl.inholland.BeerApi.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

  @RequestMapping(value = "id/{id}")
  public ResponseEntity GetBeerByID(@PathVariable String id) {

    List<Beer> beers = service.getAllBeers();
    for(Beer beer : beers){
      if(beer.getId() == Long.parseLong(id)){
        return  ResponseEntity.status(200).body(beer);
      }
    }
    return ResponseEntity.status(400).body("ne beers found");
  }

  @RequestMapping(value = "brand/{name}")
  public ResponseEntity GetBeersByBrand(@PathVariable String name) {
    List<Beer> beers = service.getAllBeers();

    List<Beer> brandBeers = new ArrayList<Beer>();
    for(Beer beer : beers){
      if(beer.getBrand().toLowerCase().equals(name.toLowerCase())){
        brandBeers.add(beer);
      }
    }
    if(brandBeers.size() > 0){
      return  ResponseEntity.status(200).body(brandBeers);
    }
    return ResponseEntity.status(400).body("ne beers found");
  }

  @RequestMapping(value = "type/{name}")
  public ResponseEntity GetBeersByName(@PathVariable String name) {
    List<Beer> beers = service.getAllBeers();
    Predicate<String> p = s -> s.startsWith(name.toLowerCase());

    List<Beer> brandBeers = new ArrayList<Beer>();
    for(Beer beer : beers){
      if(p.test(beer.getType().toLowerCase())){
        brandBeers.add(beer);
      }
    }
    if(brandBeers.size() > 0){
      return  ResponseEntity.status(200).body(brandBeers);
    }
    return ResponseEntity.status(400).body("ne beers found");
  }
}