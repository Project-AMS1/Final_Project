package com.org.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.dao.UserDao;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Users;
@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public Users createUser(Users newUser) {
		// TODO Auto-generated method stub
		
			return userDao.save(newUser);
			
		}
	

	@Override
	public Users updateUser(Users updateUser) {
		// TODO Auto-generated method stub
		Optional<Users> findUserById = userDao.findById(updateUser.getId());
		if (findUserById.isPresent()) {
			userDao.save(updateUser);
		} else
			throw new RecordNotFoundException(
					"User with Id: " + updateUser.getId() + " not exists!!");
		return updateUser;
	}


	@Override
	public List<Users> displayAllUser() {
		// TODO Auto-generated method stub
		return (List<Users>) userDao.findAll();
	}

	@Override
	public ResponseEntity<?> findUserById(Long userId) {
		// TODO Auto-generated method stub
		Optional<Users> findById = userDao.findById(userId);
		try {
			if (findById.isPresent()) {
				Users findUser = findById.get();
				return new ResponseEntity<Users>(findUser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + userId);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}