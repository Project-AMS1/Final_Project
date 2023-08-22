package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.Feedback;

public interface FeedbackDao extends JpaRepository<Feedback, Long> {

}
