package com.org.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="users")
@NoArgsConstructor
public class Users {


	@Id
	@Column(length=30)
	private String email;
	@Column(length=20)
	private String first_name;
	@Column(length=20)
	private String last_name;
	@Column(length=20)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Role role;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@Column(length=20)
	private String mobile_no;
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Gender gender;
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="feedback")
	private Feedback feedback;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, 
			orphanRemoval = true)
	@JsonIgnore
	private List<TicketDetails> ticketDetails =new ArrayList<>();
	public void addTicketDetail(TicketDetails t) {
		ticketDetails.add(t);// dept --> emp
		t.setUser(this);// emp --> dept
	}
	public void removeTicketDetail(TicketDetails t) {
		ticketDetails.remove(t);
		t.setUser(null);
	}
	
	

}