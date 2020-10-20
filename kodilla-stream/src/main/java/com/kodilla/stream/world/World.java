package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    List<Continent> continents = new ArrayList<>();

    public World() {
        Country poland = new Country("Poland", new BigDecimal(38_420_687));
        Country russia = new Country("Russia", new BigDecimal(142_122_776));
        Country portugal = new Country("Portugal", new BigDecimal(10_355_493));
        Country samoa = new Country("Samoa", new BigDecimal(201_316));
        Country slovakia = new Country("Slovakia", new BigDecimal(5_445_040));
        Country usa = new Country("USA", new BigDecimal(329_256_465));
        Country turkey = new Country("Turkey", new BigDecimal(81_257_239));
        Country japan = new Country("Japan", new BigDecimal(126_168_156));
        Country egypt = new Country("Egypt", new BigDecimal(99_413_317));

        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(slovakia);
        europe.addCountry(portugal);

        Continent asia = new Continent("Asia");
        asia.addCountry(russia);
        asia.addCountry(turkey);
        asia.addCountry(japan);

        Continent americas = new Continent("Both Americas");
        americas.addCountry(usa);

        Continent africa = new Continent("Africa");
        africa.addCountry(samoa);
        africa.addCountry(egypt);

        continents.add(europe);
        continents.add(asia);
        continents.add(americas);
        continents.add(africa);

        System.out.println("Countries in our world:");
        continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(country -> country.getCountryName() + ", ")
                .forEach(System.out::print);
    }

    public BigDecimal getPeopleQuantity() {
        final BigDecimal reduce = continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return reduce;
    }
}
