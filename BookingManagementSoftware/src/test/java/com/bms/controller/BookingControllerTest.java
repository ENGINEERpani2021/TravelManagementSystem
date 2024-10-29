package com.bms.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bms.entity.Booking;

@SpringBootTest
class BookingControllerTest {
	@Autowired BookingController bookingController;
	
	@Test
	void testBookCab1() {
		Booking booking = new Booking();
		booking.setDestination("Home");
		booking.setDistance(5);
		booking.setSource("Work");
		booking.setType("Auto");
		String result = bookingController.bookCab(booking);
		assertEquals("Booking successfull!", result);
	}
	
	@Test
	void testBookCab2() {
		Booking booking = new Booking();
		booking.setDestination("Home");
		booking.setDistance(5);
		booking.setSource("Work");
		booking.setType("Micro");
		String result = bookingController.bookCab(booking);
		assertEquals("Please try again!!!. Check with different type", result);
	}
	
	@Disabled
	@Test
	void testDeleteCab1() {
		String result = bookingController.deleteCab(3);
		assertEquals("Booking cancelled", result);
	}
	
	@Disabled
	@Test
	void testDeleteCab2() {
		String result = bookingController.deleteCab(3);
		assertEquals("Can't find the booking. Check the booking id!!!", result);
	}

	@Test
	void testFindBooking1() {
		String result = bookingController.findBooking(18);
		assertEquals("Can't find the booking. Check the booking id!!!", result);
	}
	
	@Test
	void testFindBooking2() {
		String result = bookingController.findBooking(5);
		assertEquals("Booking: \n" + " bid=5,\n"+ " type=Auto,\n"+ " source=Work,\n"+ 
		" destination=Home,\n"+ " distance=5,\n"+ " amount=135,\n" + " cid=4\n", result);
	}
}
