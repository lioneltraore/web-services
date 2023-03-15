package com.gexcode.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class VehicleResource {

    @GetMapping("/vehicles/one")
    public MappingJacksonValue getVehicle() {
        Vehicle vehicle = new Vehicle("Red", "Ferrari", 2022);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("color");
        FilterProvider filters = new SimpleFilterProvider().addFilter("excludeColor", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(vehicle);
        mappingJacksonValue.setFilters(filters);

        return  mappingJacksonValue;
    }

    @GetMapping("/vehicles")
    public MappingJacksonValue getVehicles() {
        List<Vehicle> vehicles = Arrays.asList(
                new Vehicle("Black", "Toyota", 2016),
                new Vehicle("Green", "Porsch", 2018),
                new Vehicle("White", "Ford", 2020)
        );

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("yearOfRelease", "brand");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("excludeColor", filter);

        MappingJacksonValue result = new MappingJacksonValue(vehicles);

        result.setFilters(filterProvider);
        return result;
    }
}
