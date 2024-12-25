package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
