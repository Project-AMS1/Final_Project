package com.org.service;

import com.org.model.Feedback;

public interface FeedbackService {

	public String giveFeedback(Feedback feedback);
	public String editFeedback(Feedback feedback);
	public String deleteFeedback(Long id);
	public Feedback getFeedbackOfUser(Long id);
}
