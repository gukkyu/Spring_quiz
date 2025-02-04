package com.quiz.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.store.domain.Review;
import com.quiz.store.domain.Store;

@Mapper
public interface StoreMapper {
	public List<Store> selectStore();
	
	public List<Review> selectReviewById(int id);
}
