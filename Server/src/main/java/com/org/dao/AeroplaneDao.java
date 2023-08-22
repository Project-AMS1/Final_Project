package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.Aeroplane;

public interface AeroplaneDao extends JpaRepository<Aeroplane, Long> {

}
