package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellorBO;
import com.quiz.lesson04.domain.Sellor;

@Controller
@RequestMapping("/lesson04/quiz01")
public class Lesson04Quiz01Controller {

	@GetMapping("/add-sellor-view")
	public String quiz01_1() {
		return "lesson04/add-sellor-view";
	}
	
	@Autowired
	private SellorBO sellorBO;
	
	@PostMapping("/add-sellor")
	public String quiz01_2(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "imageUrl", required = false) String url,
			@RequestParam(value = "temperature", required = false) Double temperature) {
		
		sellorBO.addSellor(nickname, url, temperature);
		
		return "lesson04/afterAddSellor";
	}
	
	@GetMapping("/sellor-info-view")
	public String quiz01_3(Model model, @RequestParam(value = "id", required = false) Integer id) {
		Sellor sellor = sellorBO.getSellor(id);
		model.addAttribute("result", sellor);

		return "lesson04/sellorInfoView";
	}
}
