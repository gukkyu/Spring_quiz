package com.quiz.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.quiz.store.bo.StoreBO;
import com.quiz.store.domain.Review;
import com.quiz.store.domain.Store;

@Controller
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreBO storeBO;
	
	@GetMapping("/store-list-view")
	public String storeListView(Model model) {
		List<Store> store = storeBO.getStore();
		model.addAttribute("store", store);
		return "store/store-list-view";
	}
	
	@GetMapping("/review-list")
	public String getReviewById(
			RedirectAttributes redirect,
			@RequestParam("id") String id,
			@RequestParam("storename") String storename){
		
		redirect.addAttribute("id", id);
		redirect.addAttribute("storename", storename);
		
		return "redirect:review-list-view";
	}
	
	@GetMapping("/review-list-view")
	public String reviewListView(@RequestParam("id") int id, @RequestParam("storename") String storename, Model model) {
		List<Review> review = storeBO.getReviewById(id);
		model.addAttribute("review", review);
		model.addAttribute("storename", storename);
		return "store/review-list-view";
	}
}
