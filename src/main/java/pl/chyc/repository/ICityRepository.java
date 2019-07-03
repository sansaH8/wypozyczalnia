package pl.chyc.repository;

import pl.chyc.model.City;

import java.util.List;

public interface ICityRepository {

    List<City> findCities();

    List<City> findMediumCities();

    void cleanUp();
}
