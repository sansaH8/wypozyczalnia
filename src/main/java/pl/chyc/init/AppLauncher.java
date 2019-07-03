package pl.chyc.init;


import pl.chyc.repository.CityRepository;


public class AppLauncher {

    public static void main(String[] args) {
        System.out.println("asd");
        CityRepository repository = new CityRepository();

        repository.findCities().forEach(x -> System.out.println(x.getName() + " - " + x.getPopulation()));

        System.out.println("------- MEDIUM CITIES -------");

        repository.findMediumCities().forEach(x -> System.out.println(x.getName() + " - " + x.getPopulation()));

        repository.cleanUp();
    }
}
