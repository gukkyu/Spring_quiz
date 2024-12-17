package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson04.domain.Sellor;

@Mapper
public interface SellorMapper {

	public void insertSellor(
			@Param("nickname") String nickname,
			@Param("url") String url, 
			@Param("temperature") double temperature);
	
	public Sellor selectSellor();
}
