package com.quiz.booking.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

@Mapper
public interface BookingMapper {
	
	public List<Booking> selectBookingList();
	
	public int deleteBookingById(int id);
	
	public int insertBooking(
			@Param("name") String name,
			@Param("checkIn") LocalDate checkIn,
			@Param("day") int day,
			@Param("headcount") int headcount,
			@Param("phoneNumber") String phoneNumber);
	
	public Booking selectBookingById(
			@Param("name") String name,
			@Param("phoneNumber") String phoneNumber);
}
