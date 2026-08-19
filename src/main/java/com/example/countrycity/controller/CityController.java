package com.example.countrycity.controller;

import com.example.countrycity.dto.CityResponse;
import com.example.countrycity.dto.PageResponse;
import com.example.countrycity.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Cities", description = "City APIs")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/countries/{countryId}/cities")
    public PageResponse<CityResponse> getCitiesByCountry(
            @PathVariable Long countryId,
            @Parameter(description = "Zero-based page number")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Number of records per page")
            @RequestParam(defaultValue = "10") int size) {

        return cityService.getCitiesByCountry(countryId, page, size);
    }

    @GetMapping("/cities/{cityId}")
    public CityResponse getCityById(@PathVariable Long cityId) {
        return cityService.getCityById(cityId);
    }
}
