package security.oauth2_28.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import security.oauth2_28.service.HomeService;

@RestController
public class HomeController {

	private final HomeService homeService;

	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	@GetMapping("/test1")
	public String testing() {
		return homeService.test1();
	}

	@GetMapping("/test2")
	public String testing1() {
		return homeService.test2();
	}
}
