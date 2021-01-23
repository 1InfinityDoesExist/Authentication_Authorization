package in.security.oauth2_10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping("/")
	public String mainPage() {
		return "main.html";
	}

	@PostMapping("/test")
	@ResponseBody
	// @CrossOrigin("*") // all origins http://example.com
	public String test() {
		System.out.println(":::::::::::::::::::::::::");
		return "Test!!!!!!";
	}
}
