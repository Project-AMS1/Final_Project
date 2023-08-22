package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.Meal;

public interface MealDao extends JpaRepository<Meal, Long> {

}
