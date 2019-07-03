package pl.chyc.repository;

import pl.chyc.model.City;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CityRepository implements ICityRepository {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public CityRepository() {
        managerFactory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
        entityManager = managerFactory.createEntityManager();
    }

    @Override
    public List<City> findCities() {
        List<City> cities = new ArrayList<>();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createQuery("select c from City c");
            cities = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return cities;
    }

    @Override
    public List<City> findMediumCities() {
        List<City> cities = new ArrayList<>();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("City.findMediumCities");
            query.setParameter("min", 100000);
            query.setParameter("max", 300000);
            cities = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return cities;
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        managerFactory.close();
    }
}
