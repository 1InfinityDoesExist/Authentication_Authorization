package security.oauth2_27.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	/*
	 * 
	 * @PreAuthorize -- the authorization rules are validated before calling the
	 * protected method
	 * 
	 * @PostAuthorize -- the method is called always only then the aspects validates
	 * the the authorization rule
	 * 
	 * @PreFilter -- the method needs to have the parameter of type Collection or
	 * Array --the aspects intercepts the method call and validates the values in
	 * side the collection or array.
	 * 
	 * @PostFilter -- returned value needs to be a collection or array the aspects
	 * applies the authorization rules and returns only the values that complies
	 * with t the authorization rule
	 * 
	 */
//	@PreAuthorize("hasAuthority('write')")
	@PreAuthorize("#username == authentication.name")
	public List<String> findProductsForUser(String username) {
		return List.of("beer", "alcohol");
	}
}
