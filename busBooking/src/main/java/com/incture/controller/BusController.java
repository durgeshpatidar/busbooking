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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incture.model.Bus;
import com.incture.service.BusService;

@RestController
@RequestMapping("bus")
public class BusController {

	@Autowired
	private BusService busService;
	
	@RequestMapping("/hello")
	public String hello()
	{
		return "Hello Durgesh";
	}
	
	@PostMapping(value="/add", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> add(@RequestBody Bus bus)
	{
		bus.toString();
		busService.add(bus);
		return new ResponseEntity<>(bus.toString()+" added ",HttpStatus.OK);
	}
	
	@PostMapping(value="/delete")
	public ResponseEntity<String> delete(@RequestBody Bus bus)
	{
		busService.delete(bus.getId());
		return new ResponseEntity<>(" deleted ",HttpStatus.OK);
	}
	
	@GetMapping("/showAll")
	public ArrayList<Bus> showAll()
	{
		ArrayList<Bus>b=busService.showAll();
		if(b.isEmpty())
			System.out.println("no data found");
		return b;
	}
	
	
	@PostMapping("/searchbyid")
	public ArrayList<Bus> searchById(@RequestParam int id)
	{
		ArrayList<Bus>b=busService.searchById(id);
		return b;
	}
	
	@PostMapping("/priceislessthan")
	public ArrayList<Bus> searchByPrice(@RequestParam int price)
	{
		ArrayList<Bus>b=busService.searchByPrice(price);
		return b;
	}
	
	@PostMapping("/searchsourcedestination")
	public ArrayList<Bus> searchBySD(@RequestParam String s,String d)
	{
		ArrayList<Bus>b=busService.searchBySD(s,d);
		return b;
	}
	
	@PostMapping("/searchusingdestination")
	public ArrayList<Bus> searchByD(@RequestParam String destination)
	{
		ArrayList<Bus>b=busService.searchByD(destination);
		return b;
	}
}
