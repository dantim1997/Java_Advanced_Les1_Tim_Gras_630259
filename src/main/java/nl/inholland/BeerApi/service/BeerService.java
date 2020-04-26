package nl.inholland.BeerApi.service;

import nl.inholland.BeerApi.dao.BeerRepository;
import nl.inholland.BeerApi.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BeerService {
    @Autowired
    private BeerRepository beerRepository;

    public List<Beer> getAllBeers() {
        return (List<Beer>) beerRepository.findAll();
    }

    public void addBeer(Beer beer){beerRepository.save(beer);}
}
