package com.n01617765.activity_6.Service;

import com.n01617765.activity_6.Model.User;
import com.n01617765.activity_6.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class userService {

	private static final Logger logger = Logger.getLogger(userService.class.getName());
	@Autowired
	userRepository userRepository;
	
	//Adduser
	public void addUser(User user) {
		logger.info("Adding new user: " + user.getUserName());
		userRepository.save(user);
	}




	//userLogin
	public User userLogin(String userName,String password) {
		logger.info("Attempting login for username: " + userName);
		List<User> userList = userRepository.findByUserName(userName);
	
		return userList.stream().filter(user -> user.getPassword().equals(password)).findFirst().orElse(null);
		
	}
	public User userName(String userName) {
		logger.info("Fetching user details for: " + userName);
		List<User> userList = userRepository.findByUserName(userName);
		return userList.stream().findFirst().orElse(null); // Return the first matching user
	}

//	public User findUserByUserName(String userName) {
//
//	}

//	public User findByUserName(String userName) {
//		userRepository.findByUserName(userName);
//
//	}
	

	
}
