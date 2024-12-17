package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Sellor;
import com.quiz.lesson04.mapper.SellorMapper;

@Service
public class SellorBO {

	@Autowired
	private SellorMapper sellorMapper;
	public void addSellor(String nickname, String url, double temperature) {
		sellorMapper.insertSellor(nickname, url, temperature);
	}
	
	public Sellor getSellor() {
		return sellorMapper.selectSellor();
	}
}
