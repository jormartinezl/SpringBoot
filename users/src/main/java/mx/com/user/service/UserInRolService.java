package mx.com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.com.user.entity.Role;
import mx.com.user.entity.User;
import mx.com.user.entity.UserInRol;
import mx.com.user.repositories.RoleRepository;
import mx.com.user.repositories.UserInRolRepository;
import mx.com.user.repositories.UserReposotory;

@Service
public class UserInRolService {
	
	@Autowired
	private UserReposotory userReposotory;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserInRolRepository userInRolRepository;

	public UserInRol createUserInRol(Integer userId,Integer roleId) {
		UserInRol userInRol = new UserInRol(); 
		Optional<User> user = userReposotory.findById(userId);
		if(user.isPresent()) {
			userInRol.setUser(user.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found", userId));
		}
		 Optional<Role> role = roleRepository.findById(roleId);
		if(role.isPresent()) {
			userInRol.setRole(role.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role %d not found", roleId));
		}
		
		return userInRolRepository.save(userInRol);
		
		
	}

	public List<UserInRol> getUserInRol(Integer roleId) {
		return userInRolRepository.getUserInRol(roleId);
	}
}
