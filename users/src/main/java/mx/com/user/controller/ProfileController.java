package mx.com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.user.entity.Profile;
import mx.com.user.service.ProfileService;

@RequestMapping("/users/{userId}/profiles")
@RestController
public class ProfileController {

	@Autowired 
	private ProfileService profileService;
	
	@PostMapping
	public ResponseEntity<Profile> createProfile(@PathVariable(name = "userId") Integer userId,
			@RequestBody Profile profile){
		return new ResponseEntity<Profile> (profileService.createProfile(userId, profile),HttpStatus.CREATED);
	}
	
	@GetMapping("/{profileId}")
	public ResponseEntity<Profile> createProfile(@PathVariable(name = "userId") Integer userId, 
			@PathVariable(name = "profileId") Integer profileId){
		return new ResponseEntity<Profile> (profileService.getProfile(userId, profileId),HttpStatus.CREATED);
	}
}
