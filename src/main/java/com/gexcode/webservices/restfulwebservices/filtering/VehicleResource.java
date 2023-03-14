package com.gexcode.webservices.restfulwebservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleResource {

    @GetMapping("/vehicles")
    public MappingJacksonValue getVehicles() {
        Vehicle vehicle = new Vehicle("Red", "Ferrari", 2022);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(vehicle);

        return  mappingJacksonValue;
    }
}
