package com.org.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.org.model.Users;

public interface UserService {

	public ResponseEntity<?> createUser(Users newUser);

	public Users updateUser(Users newUser);


	public List<Users> displayAllUser();

	public ResponseEntity<?> findUserById(Long userId);
}