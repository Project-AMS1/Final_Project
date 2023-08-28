package com.org.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowFlighDto {

	
	private String source;
	private String destination;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
}
