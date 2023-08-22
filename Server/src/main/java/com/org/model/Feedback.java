package com.org.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="feedback")
@Getter
@Setter
@NoArgsConstructor
public class Feedback {

	@javax.persistence.Id
	@Column(name="id")
	private int Id;
	@Column(length=20)
	private String title;
	@Column(length=100)
	private String description;
	
}
