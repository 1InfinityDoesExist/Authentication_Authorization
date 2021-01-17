package in.security.oauth2_4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectContrller {

	@GetMapping("/test")
	public String test() {
		return "Test";
	}
}
