package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.dao.MealDao;
import com.org.model.Meal;

@Transactional
@Service
public class MealServiceImpl implements MealService{

	@Autowired
	MealDao mealDao;

	@Override
	public String addMeal(Meal meal) {
		mealDao.save(meal);
		return "Meal has been added";
	}

	@Override
	public String removeMeal(Meal meal) {
		// TODO Auto-generated method stub
		mealDao.delete(meal);
		return "Meal has been removed";
	}

	@Override
	public String editMeal(Meal meal) {
		mealDao.save(meal);
		return "meal has been updated";
	}
}
