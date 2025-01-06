package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.StudentBO;
import com.quiz.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	@GetMapping("/create")
	public StudentEntity create() {
		String name = "김루이";
		String phoneNumber = "01033332222";
		String email = "louis@gmail.com";
		String dreamJob = "고양이";
		
		return studentBO.addStuent(name, phoneNumber, email, dreamJob);
		
	}
	
	@GetMapping("/update")
	public StudentEntity update(
			@RequestParam("id") int id) {
		return studentBO.updateStudentDreamJobById(id, "황태자");
	}
	
	@GetMapping("/delete")
	public String delete() {
		studentBO.deleteStudentById(2);
		return "삭제 완료";
	}
	
}
