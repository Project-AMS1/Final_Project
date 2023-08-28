package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.Feedback;
import java.lang.Long;
import java.util.List;

public interface FeedbackDao extends JpaRepository<Feedback, Long> {

			public Feedback findByUserId(Long userid);
};