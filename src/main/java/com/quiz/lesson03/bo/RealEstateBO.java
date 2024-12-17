package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper realEstateMapper;
	
	public List<RealEstate> getRealEstateByAreaPrice(int area, int price){
		return realEstateMapper.selectRealEstateByAreaPrice(area, price);
	}
	
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	public int addRealEstateByField(int realtorId, String address, int area, String type, int price, int rentPrice) {
		return realEstateMapper.insertRealEstateByField(realtorId, address, area, type, price, rentPrice);
	}
	
	public int updateRealEstate(int id, int price) {
		return realEstateMapper.updateRealEstate(id, price);
	}
	
	public int deleteRealEstate(int id) {
		return realEstateMapper.deleteRealEstate(id);
	}
}
