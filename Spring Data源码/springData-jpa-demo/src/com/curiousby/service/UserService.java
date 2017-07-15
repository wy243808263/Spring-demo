package com.curiousby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curiousby.entity.User;
import com.curiousby.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public List<User> allUser() {
		return userRepository.getAll();
	}

	@Transactional(readOnly = true)
	public void delUser(int userId) {
		userRepository.delete(userId);
	}

	@Transactional(readOnly = true)
	public User user(int userId) {
		return userRepository.findOne(userId);
	}

	@Transactional(readOnly = true)
	public void updateUser(User user) {
		userRepository.saveAndFlush(user);
	}

	@Transactional
	public void addUser(User user) {
		userRepository.save(user);
	}

}
