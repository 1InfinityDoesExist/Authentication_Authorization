package in.security.csrf1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String getHome() {
		return "home.html";
	}

	@PostMapping("/saveData")
	public String Home(String uname) {
		System.out.println(uname);
		return "home.html";
	}
}
