package com.incture.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incture.model.Passenger;
import com.incture.service.PassengerService;

@RestController
@RequestMapping("passenger")
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;
	
	@RequestMapping("/hello")
	public String hello()
	{
		return "Hello Durgesh";
	}
	@PostMapping(value="/add", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> add(@RequestBody Passenger passenger)
	{
		passenger.toString();
		passengerService.add(passenger);
		return new ResponseEntity<String>(passenger.toString()+" added ",HttpStatus.OK);
	}
	
	@PostMapping(value="/delete")
	public ResponseEntity<String> delete(@RequestBody Passenger passenger)
	{
		passengerService.delete(passenger.getId());
		return new ResponseEntity<String>(" deleted ",HttpStatus.OK);
	}
	
	@GetMapping("/showAll")
	public ArrayList<Passenger> showAll()
	{
		return passengerService.showAll();
	}
}
