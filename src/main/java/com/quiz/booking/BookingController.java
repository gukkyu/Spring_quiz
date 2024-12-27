package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/booking-list")
	public String getBookingList(Model model) {
		
		List<Booking> Booking = bookingBO.getBookingList();
		
		model.addAttribute("booking", Booking);
		
		return "booking/booking-list";
	}
	
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBookingById(
			@RequestParam("id") int id){
		
		int rowCount = bookingBO.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		if(rowCount == 1) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 404);
			result.put("result", "실패");
		}
		return result;
	}
	
	@GetMapping("/add-booking")
	public String addBooking() {
		return "booking/add-booking";
	}
	
	@ResponseBody
	@PostMapping("/add-booking-post")
	public Map<String, Object> addBookingPost(
			@RequestParam("name") String name,
			@RequestParam("checkIn") @DateTimeFormat(pattern = "yyyy년 MM월 dd일") LocalDate CheckIn,
			@RequestParam("checkOut") @DateTimeFormat(pattern = "yyyy년 MM월 dd일") LocalDate CheckOut,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		int rowCount = bookingBO.addBooking(name, CheckIn, CheckOut, headcount, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		if(rowCount == 1) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 404);
			result.put("result", "실패");
		}
		return result;
	}
	
}
