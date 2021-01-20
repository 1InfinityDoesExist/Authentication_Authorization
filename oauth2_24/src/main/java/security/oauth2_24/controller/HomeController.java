package security.oauth2_24.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	// Endpoint = Path + http method
	@GetMapping("/hello")
	public String home() {
		return "Hello World!!!!";
	}

	@GetMapping("/ciao")
	public String ciao() {
		return "ciao!!!!";
	}

	@PostMapping("/hola")
	public String hola() {
		return "hola!!!!";
	}
}
