package security.oauth2_28.service;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

	@PreAuthorize("hasAuthority('read')")
	public String test1() {
		System.out.println("::::::::::Test1 method");
		return "TEST1";
	}

	@PostAuthorize("returnObject != authentication.name")
	public String test2() {
		System.out.println("::::::::::Test2 method");
		return "patel1";
	}
}
