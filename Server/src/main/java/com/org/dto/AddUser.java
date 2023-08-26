package com.org.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.org.model.Gender;
import com.org.model.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class AddUser {

	@Getter
	@Setter
	@ToString
	public class AddEmployeeDTO {
		@JsonProperty(access = Access.READ_ONLY) // used during serialization
		private Long id;
		
		private String email;
		
		
		private String first_name;
		
	
		private String last_name;
		
	
		private String password;
		
		private Role role=Role.CUSTOMER;
		
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate dob;
		
		
		private String mobile_no;
		
		
		private Gender gender;
	}

}
