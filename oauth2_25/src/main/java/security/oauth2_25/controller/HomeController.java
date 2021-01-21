package security.oauth2_25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/a")
	public String a() {
		return "a";
	}

	@GetMapping("/a/b")
	public String ab() {
		return "abc";
	}

	@GetMapping("/a/b/c")
	public String abc() {
		return "abc";
	}

	@GetMapping("/b")
	public String b() {
		return "b";
	}

	@GetMapping("/b/c")
	public String bc() {
		return "bc";
	}

	@GetMapping("/c/{name}")
	public String c(@PathVariable(value = "name") String name) {
		return name;
	}
}
