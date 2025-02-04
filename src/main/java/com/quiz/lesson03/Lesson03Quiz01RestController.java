package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RestController
public class Lesson03Quiz01RestController {
	
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/lesson03/quiz01")
	public List<RealEstate> quiz01(
			@RequestParam("area") int area,
			@RequestParam("price") int price){
		return realEstateBO.getRealEstateByAreaPrice(area, price);
	}
}
