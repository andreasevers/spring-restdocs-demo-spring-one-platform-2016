package com.example.controllers;

import com.example.model.Driver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/drivers", produces = "application/json")
public class DriverController {

    public static final String REL = "driver";

    @RequestMapping("/{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable("id") long id) {
        Driver driver = retrieveDriver(id);
        return new ResponseEntity<>(driver, OK);
    }

    private Driver retrieveDriver(long id) {
        Driver driver = new Driver(id, "Andreas");
        driver.add(linkTo(DriverController.class).slash(id).withSelfRel());
        return driver;
    }
}
