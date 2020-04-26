package nl.inholland.BeerApi.dao;

import nl.inholland.BeerApi.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, Integer> {

    public Iterable<Stock> getAllByQuantityGreaterThanEqualOrderByQuantity(int minimum);

   /* @Query("Select s.quantity * b.price from Stock s, Beer b where s.Beer.id = b.id and s.Beer.id=?1")
    int getQuantityByBeer(int id);*/
}
