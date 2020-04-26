package nl.inholland.BeerApi.controller;

import nl.inholland.BeerApi.model.Beer;
import nl.inholland.BeerApi.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Controller
@RequestMapping("Beer")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost"} )
public class BeerController {

  @Autowired private BeerService service;

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getAllBeers() { return ResponseEntity.status(200).body(service.getAllBeers());}

  @RequestMapping(value = "id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity GetBeerByID(@PathVariable("id") Integer id) {
    for(Beer beer : service.getAllBeers()){
      if(beer.getId() == id){
        return  ResponseEntity.status(200).body(beer);
      }
    }
    return ResponseEntity.status(400).body("ne beers found");
  }

  @RequestMapping(value = "brand/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity GetBeersByBrand(@PathVariable("name") String name) {
    List<Beer> brandBeers = new ArrayList<Beer>();
    for(Beer beer : service.getAllBeers()){
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

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity createBeer(@RequestBody Beer beer){
    service.addBeer(beer);
    return ResponseEntity.status(HttpStatus.CREATED).body(beer.getId());
  }
}