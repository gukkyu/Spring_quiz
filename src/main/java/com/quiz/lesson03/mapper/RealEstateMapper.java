package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

public interface RealEstateMapper {
	public List<RealEstate> selectRealEstateByAreaPrice(@Param("area") int area, @Param("price") int price);
}
