package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	public RealEstate selectRealEstateById(int id);
	public List<RealEstate> selectRealEstateByRentPrice(Integer rentPrice);
	public List<RealEstate> selectRealEstateByAreaPrice(@Param("area") int area, @Param("price") int price);
	public List<RealEstate> selectRealEstate(@Param("area") int area, @Param("price") int price);
}
