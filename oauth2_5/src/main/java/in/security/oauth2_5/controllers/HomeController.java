package in.security.oauth2_5.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/test")
	public String test() {
		return "Test";
	}
}
