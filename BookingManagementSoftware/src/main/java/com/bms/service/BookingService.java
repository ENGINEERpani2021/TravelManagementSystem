package com.bms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bms.entity.Booking;
import com.bms.repository.BookingRepository;

@Service
public class BookingService {
@Autowired BookingRepository bookingRepository;
@Autowired RestTemplate restTemplate;

public String createBooking(Booking book) {
	Map<String, Object> response = restTemplate.getForObject("http://localhost:8181/cab/search/type/"+book.getType(),Map.class);
	if (response!=null) {
		int Totalamount = book.getDistance()*(Integer)(response.get("baseFare"));
		book.setAmount(Totalamount);
		book.setCid((Integer)(response.get("cid")));
		bookingRepository.save(book);
		return "Booking successfull!";
	} else {
		return "Please try again!!!. Check with different type";
	}
}
public String cancelBooking(int bid) {
	if (bookingRepository.existsById(bid)) {
		bookingRepository.deleteById(bid);
		return "Booking cancelled";
	} else {
		return "Can't find the booking. Check the booking id!!!";
	}
}
public String findBooking(int bid) {
	if (bookingRepository.existsById(bid)) {
		return bookingRepository.findById(bid).get().toString();
	} else {
		return "Can't find the booking. Check the booking id!!!";
	}
}
}
