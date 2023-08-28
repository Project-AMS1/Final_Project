package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.dao.FeedbackDao;
import com.org.model.Feedback;

@Transactional
@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackDao feedbackDao;

	@Override
	public String giveFeedback(Feedback feedback) {
		
		feedbackDao.save(feedback);
		return "feedback has been given";
	}

	@Override
	public String editFeedback(Feedback feedback) {
		feedbackDao.save(feedback);
		return "feedback has been updated";
	}

	@Override
	public String deleteFeedback(Long id) {
		
		Feedback feedback=feedbackDao.findById(id).orElseThrow();
		feedbackDao.delete(feedback);
		return "feedback has been deleted";
	}

	@Override
	public Feedback getFeedbackOfUser(Long id) {
		return feedbackDao.findByUserId(id);
		
	}
	
	
}
