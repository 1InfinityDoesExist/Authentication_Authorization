package security.oauth2_27.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import security.oauth2_27.service.ProductService;

@RestController
public class HomeController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<String> findProductForUserName(Authentication a) {
		return productService.findProductsForUser(a.getName());
	}
}
