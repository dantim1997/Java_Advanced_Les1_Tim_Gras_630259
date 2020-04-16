package nl.inholland.BeerApi.service;

import nl.inholland.BeerApi.model.Beer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BeerService {
    List<Beer> beers;

    public BeerService() {

        this.beers =  Arrays.asList(
                new Beer(1L,"Hoop" , "ANKER", 14.00, "Zaandijk"),
                new Beer(2l, "Texel", "Skuumkoppe", 1.80, "Texel"),
                new Beer(3L, "Hoop", "Kaper",14.50, "Zaandijk"),
                new Beer(3L, "Hoop", "Anders",14.50, "Zaandijk")
        );
    }

    public List<Beer> getAllBeers() {
        return beers;
    }


}
