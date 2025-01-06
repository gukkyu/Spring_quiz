package com.quiz.booking.bo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	@Autowired
	private BookingMapper bookingMapper;
	
	public List<Booking> getBookingList(){
		return bookingMapper.selectBookingList();
	}
	
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	public int addBooking(String name, LocalDate checkIn, LocalDate checkOut, int headcount, String phoneNumber) {
		int day = (int) ChronoUnit.DAYS.between(checkIn, checkOut);
		return bookingMapper.insertBooking(name, checkIn, day, headcount, phoneNumber);
	}
	
	public Booking getBooking(String name, String phoneNumber){
		return bookingMapper.selectBookingById(name, phoneNumber);
	}
}
