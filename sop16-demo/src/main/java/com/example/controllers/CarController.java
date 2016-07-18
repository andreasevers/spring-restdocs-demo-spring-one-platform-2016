package com.example.controllers;

import com.example.model.Car;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Arrays.asList;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/cars", produces = "application/json")
public class CarController {

	@RequestMapping("/{id}")
	public ResponseEntity<Car> getCar(@PathVariable("id") long id) {
		Car car = retrieveCar(id);
		return new ResponseEntity<>(car, OK);
	}
	
	@RequestMapping
	public ResponseEntity<Resources<Car>> getCars() {
		Car car = retrieveCar(1);
		Resources<Car> carsResource = new Resources<>(asList(car));
		carsResource.add(linkTo(CarController.class).withSelfRel());
		return new ResponseEntity<>(carsResource, OK);
	}

	private Car retrieveCar(long id) {
		Car car = new Car(id, "BMW");
		car.add(linkTo(CarController.class).slash(id).withSelfRel());
		return car;
	}
}
