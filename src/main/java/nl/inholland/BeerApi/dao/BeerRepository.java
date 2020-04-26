package nl.inholland.BeerApi.dao;

import nl.inholland.BeerApi.model.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends CrudRepository<Beer, Integer> {
}
