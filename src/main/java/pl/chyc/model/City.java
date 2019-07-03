package pl.chyc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "city")
@NamedQueries({
        @NamedQuery(name = "City.findMediumCities",
                query = "select c from City c where c.population between :min and :max"),
        @NamedQuery(name = "City.findBigCities",
                query = "select c from City c where c.population > 300000")
})
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String countryCode;
    private String district;
    private String name;
    @Column(nullable = false)
    private int population;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}