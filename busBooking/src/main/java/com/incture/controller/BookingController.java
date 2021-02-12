package com.incture.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incture.service.BookingService;


@RestController
@RequestMapping("booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/book")
	public ResponseEntity<String> booking(@RequestParam int passengerid,int busid)
	{
		try
		{
		bookingService.booking(passengerid,busid);
		return new ResponseEntity<>("booking successful for passenger id: "+passengerid+" and busid: "+busid,HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>("Error :"+e.toString(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/showBooking")
	public ArrayList showAll(@RequestParam int userid)
	{
		ArrayList b=bookingService.showAll(userid);
		return b;
	}
	
}

