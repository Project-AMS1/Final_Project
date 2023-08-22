package com.org.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="airport")
@NoArgsConstructor
public class Airport
/**
 * Class Airport
 */
{
	@Id
	private String id;
	@Column(length=20)
	private String airport_name;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	
	@JoinColumn(name="city_pincode")
	private City city;

	
}
