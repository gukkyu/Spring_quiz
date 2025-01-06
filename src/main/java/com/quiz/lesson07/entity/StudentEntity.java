package com.quiz.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 이 객체는 엔티티다.
@Table(name = "new_score")
@Getter
@Builder(toBuilder = true) // Setter 대용
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 파라미터가 있는 생성자
@ToString // 객체 출력시 필드 값들이 보인다.
public class StudentEntity {
	@Id // pk 식별자
	@GeneratedValue(strategy = GenerationType.IDENTITY) // insert시 방금 들어간 id값 가져온다.
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@CreationTimestamp
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
}
