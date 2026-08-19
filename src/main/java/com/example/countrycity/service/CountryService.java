package com.example.countrycity.service;

import com.example.countrycity.dto.CountryResponse;
import com.example.countrycity.exception.ResourceNotFoundException;
import com.example.countrycity.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryResponse> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(country -> new CountryResponse(country.id(), country.name()))
                .toList();
    }

    public void validateCountryExists(Long countryId) {
        countryRepository.findById(countryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Country not found: " + countryId));
    }
}
