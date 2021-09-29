package mx.com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.com.user.entity.Address;
import mx.com.user.entity.Profile;
import mx.com.user.repositories.AddressRepository;
import mx.com.user.repositories.ProfileRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ProfileRepository profileRepository;

	public List<Address> findAddress(Integer userId, Integer profileId) {
		return addressRepository.findAddress(userId, profileId);

	}

	public Address createAddress(Integer userId, Integer profileId, Address address) {
		Optional<Profile> profile = profileRepository.getProfile(userId, profileId);
		if(profile.isPresent()) {
			address.setProfile(profile.get());
			return addressRepository.save(address);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Profile %d and User %d not found", profileId,userId));
		}
	}
	
	
}
