package com.example.countrycity.repository;

import com.example.countrycity.model.City;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CityRepository {

    private final List<City> cities = List.of(
            new City(1L, "Mumbai", 1L, 20600000L, "400001", "Major financial city on India's west coast."),
            new City(2L, "Pune", 1L, 7000000L, "411001", "Major educational and technology hub."),
            new City(3L, "Delhi", 1L, 32900000L, "110001", "Capital territory of India."),
            new City(4L, "Bengaluru", 1L, 14000000L, "560001", "Major technology and startup hub."),
            new City(5L, "New York", 2L, 8400000L, "10001", "Major city in the United States."),
            new City(6L, "Los Angeles", 2L, 3800000L, "90001", "Major city in Southern California."),
            new City(7L, "Chicago", 2L, 2700000L, "60601", "Major city on Lake Michigan."),
            new City(8L, "London", 3L, 8900000L, "SW1A", "Capital city of the United Kingdom."),
            new City(9L, "Manchester", 3L, 570000L, "M1", "Major city in northwest England.")
    );

    public List<City> findAll() {
        return cities;
    }

    public Optional<City> findById(Long id) {
        return cities.stream()
                .filter(city -> city.id().equals(id))
                .findFirst();
    }

    public List<City> findByCountryId(Long countryId) {
        return cities.stream()
                .filter(city -> city.countryId().equals(countryId))
                .toList();
    }
}
