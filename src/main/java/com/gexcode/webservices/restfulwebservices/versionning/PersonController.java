package com.gexcode.webservices.restfulwebservices.versionning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstPersonVersion() {
        return new PersonV1("Jack Lee");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondPersonVersion() {
        return new PersonV2(new Name("Bob", "Chris"));
    }
}
