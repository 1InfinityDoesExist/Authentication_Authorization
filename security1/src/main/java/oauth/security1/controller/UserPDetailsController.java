package oauth.security1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import oauth.security1.entity.UserPDetails;
import oauth.security1.repository.UserPDetailsRepository;

@RestController
public class UserPDetailsController {

	@Autowired
	private UserPDetailsRepository repo;

	@PostMapping(value = "/addUser")
	public ResponseEntity<?> addUser(@RequestBody UserPDetails userPDetails) {
		repo.save(userPDetails);
		return null;
	}

	@GetMapping(value = "/hi")
	public String sayHello() {
		return "hello";
	}
}
