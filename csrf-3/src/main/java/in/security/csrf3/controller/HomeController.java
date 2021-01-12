package in.security.csrf3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping("/myapp")
	public String getHome() {
		return "home.html";
	}

	@PostMapping("/accessData")
	@ResponseBody
	public String resource() {
		return "Hello Resources";
	}
}
