package com.example.countrycity.dto;

public record CityResponse(
        Long id,
        String name,
        Long countryId,
        Long population,
        String postalCode,
        String description
) {
}
