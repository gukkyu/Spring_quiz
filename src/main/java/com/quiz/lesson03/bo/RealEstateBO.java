package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

public class RealEstateBO {

	@Autowired
	private RealEstateMapper realEstateMapper;
	
	public List<RealEstate> getRealEstateByAreaPrice(int area, int price){
		return realEstateMapper.selectRealEstateByAreaPrice(area, price);
	}
}
