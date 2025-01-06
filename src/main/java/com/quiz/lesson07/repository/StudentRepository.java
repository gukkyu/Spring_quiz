package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.StudentEntity;

// 제네릭 : <엔티티, pk의 타입>
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	// 순수한 JPA vs Spring Data JPA
	
	// save() // insert - id = 0, update - id > 0
	// public StudentEntity findById(int id);
	
}
