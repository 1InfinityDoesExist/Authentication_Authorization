package oauth.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	/*
	 *
	 * 
	 * Redirect to login page --- Uses BasicAuthenticationFilter by default
	 */
	@GetMapping("/hello")
	public String sayHi() {
		return "Hi patel !!!!";
	}
}
