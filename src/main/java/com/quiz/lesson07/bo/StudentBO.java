package com.quiz.lesson07.bo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.StudentEntity;
import com.quiz.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public StudentEntity addStuent(String name, String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(LocalDateTime.now())
				.build();
		
		return studentRepository.save(student);
	}
	
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		StudentEntity student = studentRepository.findById(id).orElse(null);
		if(student != null) {
			student = student.toBuilder().dreamJob(dreamJob).build();
			
			student = studentRepository.save(student);
		}
		
		return student;
	}
	public void deleteStudentById(int id) {
		
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
}
