package com.example.countrycity.service;

import com.example.countrycity.dto.CityResponse;
import com.example.countrycity.dto.PageResponse;
import com.example.countrycity.exception.ResourceNotFoundException;
import com.example.countrycity.model.City;
import com.example.countrycity.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CountryService countryService;

    public CityService(CityRepository cityRepository, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
    }

    public PageResponse<CityResponse> getCitiesByCountry(
            Long countryId,
            int page,
            int size) {

        validatePagination(page, size);
        countryService.validateCountryExists(countryId);

        List<City> cities = cityRepository.findByCountryId(countryId);

        long totalElements = cities.size();
        int totalPages = (int) Math.ceil((double) totalElements / size);
        int fromIndex = Math.min(page * size, cities.size());
        int toIndex = Math.min(fromIndex + size, cities.size());

        List<CityResponse> content = cities.subList(fromIndex, toIndex)
                .stream()
                .map(this::toResponse)
                .toList();

        return new PageResponse<>(
                content,
                page,
                size,
                totalElements,
                totalPages);
    }

    public CityResponse getCityById(Long cityId) {
        return cityRepository.findById(cityId)
                .map(this::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "City not found: " + cityId));
    }

    private void validatePagination(int page, int size) {
        if (page < 0) {
            throw new IllegalArgumentException("Page must be greater than or equal to 0");
        }
        if (size < 1 || size > 100) {
            throw new IllegalArgumentException("Size must be between 1 and 100");
        }
    }

    private CityResponse toResponse(City city) {
        return new CityResponse(
                city.id(),
                city.name(),
                city.countryId(),
                city.population(),
                city.postalCode(),
                city.description());
    }
}
