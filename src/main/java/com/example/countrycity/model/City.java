package com.example.countrycity.model;

public record City(
        Long id,
        String name,
        Long countryId,
        Long population,
        String postalCode,
        String description
) {
}
