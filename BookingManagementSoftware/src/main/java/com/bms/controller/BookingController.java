package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.entity.Booking;
import com.bms.service.BookingService;

@RestController
@RequestMapping(value="/booking")
public class BookingController {
	@Autowired BookingService bookingService;
	
	@PostMapping(value="bookCab",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String bookCab(@RequestBody Booking book) {
		return bookingService.createBooking(book);
	}
	
	@DeleteMapping(value="deleteCab/{bid}")
	public String deleteCab(@PathVariable("bid") int bid) {
		return bookingService.cancelBooking(bid);
	}
	
	@GetMapping(value="findCab/{bid}")
	public String findBooking(@PathVariable("bid") int bid) {
		return bookingService.findBooking(bid);
	}
}
