package mx.com.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.com.user.entity.Profile;
import mx.com.user.entity.User;
import mx.com.user.repositories.ProfileRepository;
import mx.com.user.repositories.UserReposotory;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private UserReposotory userReposotory;
	
	public Profile createProfile(Integer id, Profile profile) {
		Optional<User> result = userReposotory.findById(id);
		if(result.isPresent()) {
			profile.setUser(result.get());
			return profileRepository.save(profile);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found", id));
		}
		
	}

	public Profile getProfile(Integer userId, Integer profileId) {
		return profileRepository.getProfile( userId,  profileId)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Profile not fount for user %d and profile %d", userId, profileId)));

	}
}
