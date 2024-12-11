package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson01/quiz03")
public class Quiz03 {

	@RequestMapping("/1")
	public String quiz03_1() {
		return "lesson01/quiz03";
		}
}
