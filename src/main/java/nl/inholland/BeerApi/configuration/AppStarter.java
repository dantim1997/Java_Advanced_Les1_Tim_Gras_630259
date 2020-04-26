package nl.inholland.BeerApi.configuration;

import nl.inholland.BeerApi.dao.BeerRepository;
import nl.inholland.BeerApi.dao.StockRepository;
import nl.inholland.BeerApi.model.Beer;
import nl.inholland.BeerApi.model.Stock;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class AppStarter implements ApplicationRunner {
    BeerRepository beerRepository;
    StockRepository stockRepository;

    AppStarter(BeerRepository beerRepository, StockRepository stockRepository){
        this.beerRepository = beerRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Beer> beers = Arrays.asList(
                new Beer("Hoop" , "ANKER", 14.00, "Zaandijk"),
                new Beer("Texel", "Skuumkoppe", 1.80, "Texel"),
                new Beer("Hoop", "Kaper",14.50, "Zaandijk"),
                new Beer( "Hoop", "Anders",14.50, "Zaandijk")
        );

        beers.forEach(
                beerRepository::save
        );

        beerRepository.findAll()
                .forEach(
                    beer -> stockRepository.save(new Stock(beer, new Random().nextInt(100)))
                );

       // Iterable<Stock> stocks = stockRepository.getAllByQuantityGreaterThenEqualOrderByQuantity(1);

        stockRepository.findAll().forEach(System.out::println);
        beerRepository.findAll().forEach(System.out::println);
    }
}
