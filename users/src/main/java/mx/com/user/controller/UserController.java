package mx.com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.user.entity.User;
import mx.com.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired 
	private UserService userService;
	
	@GetMapping()
	public ResponseEntity<Page<User>> getUsers(
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "50") int size){
		return new ResponseEntity<Page<User>> (userService.getUsers(page, size),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id){
		return new ResponseEntity<User> (userService.getUser(id),HttpStatus.OK);
	}
	@GetMapping("/username/{username}")
	public ResponseEntity<User> getUser(@PathVariable String username){
		return new ResponseEntity<User> (userService.getUserByUsername(username),HttpStatus.OK);
	}
}
