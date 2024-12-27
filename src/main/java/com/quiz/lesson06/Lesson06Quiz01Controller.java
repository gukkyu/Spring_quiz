package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@Controller
@RequestMapping("/lesson06/quiz01")
public class Lesson06Quiz01Controller {

	@Autowired
	private BookmarkBO bookmarkBO;
	
	@RequestMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/add-bookmark-view";
	}
	
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("title") String title,
			@RequestParam("url") String url) {
		bookmarkBO.addBookmark(title, url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");

		return result;
	}
	
	@GetMapping("/after-add-bookmark")
	public String afterAddBookmark(Model model) {
		List<Bookmark> bookmark = bookmarkBO.getBookmark();
		model.addAttribute("bookmark", bookmark);
		return "lesson06/after-add-bookmark";
	}
	
	@ResponseBody
	@GetMapping("/isDuplicateUrl")
	public Map<String, Object> isDuplicateUrl(
			@RequestParam("url") String url) {
		boolean isDuplicate = bookmarkBO.isDuplicateUrl(url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplicate", isDuplicate);

		return result;
	}
	
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	public Map<String, Object> deleteBookmark(
			@RequestParam("id") int id){
		// db delete
		int rowCount = bookmarkBO.deleteBookmarkById(id);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		if (rowCount == 1) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 300);
			result.put("error_message", "삭제할 데이터가 없습니다.");
		}
		
		return result;
	}
}
