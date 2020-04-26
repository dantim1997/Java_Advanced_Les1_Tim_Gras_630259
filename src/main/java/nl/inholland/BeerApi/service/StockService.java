package nl.inholland.BeerApi.service;

import nl.inholland.BeerApi.dao.StockRepository;
import nl.inholland.BeerApi.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    StockRepository stockRepository;

  /*  public List<Stock> getStockMinimum(int min){
        //return (List<Stock>) stockRepository.getAllByQuantityGreaterThenEqualOrderByQuantity(min);
    }*/
}
