package mx.com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.user.entity.UserInRol;
import mx.com.user.service.UserInRolService;

@RestController
@RequestMapping("/usersinrols/roles/{roleId}")
public class UserInRolController {

	@Autowired
	private UserInRolService userInrolService;
	
	@PostMapping("/users/{userId}")
	public ResponseEntity<UserInRol> createUserInRol(@PathVariable Integer userId, @PathVariable Integer roleId) {
	
		return new ResponseEntity<UserInRol> (userInrolService.createUserInRol(userId, roleId),HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<UserInRol>> getUserInRol(@PathVariable Integer roleId) {
		
		return new ResponseEntity<List<UserInRol>> (userInrolService.getUserInRol(roleId),HttpStatus.OK);
	}
}
