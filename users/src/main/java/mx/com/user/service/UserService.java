package mx.com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.user.entity.User;
import mx.com.user.repositories.UserReposotory;

@Service
public class UserService {

	@Autowired
	private UserReposotory userReposotory;
	
	public List<User> getUsers(){
		return userReposotory.findAll();
	}
}
