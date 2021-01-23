package in.security.oauth2_9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	@GetMapping
	public String test() {
		return "main.html";
	}

	@PostMapping("/change")
	public String csrfChanges() {
		System.out.println(":::::::::Csrf Method");
		return "main.html";
	}
}
