package security.oauth2_27.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@PreAuthorize("hasAuthority('write')")
	public List<String> findProductsForUser(String username) {
		return List.of("beer", "alcohol");
	}
}
