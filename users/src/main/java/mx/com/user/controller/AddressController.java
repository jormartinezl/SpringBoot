package mx.com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.user.entity.Address;
import mx.com.user.service.AddressService;

@RestController
@RequestMapping("/users/{userId}/profiles/{profileId}/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping
	public ResponseEntity<List<Address>> findAddesses(@PathVariable Integer userId,
			@PathVariable Integer profileId){
		return new ResponseEntity<List<Address>> (addressService.findAddress(userId,profileId),HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Address> findAddesses(@PathVariable Integer userId,
			@PathVariable Integer profileId, @RequestBody Address address){
		return new ResponseEntity<Address> (addressService.createAddress(userId,profileId,address),HttpStatus.OK);
		
	}
}
