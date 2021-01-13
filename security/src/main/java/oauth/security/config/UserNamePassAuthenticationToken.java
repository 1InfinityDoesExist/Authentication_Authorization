package oauth.security.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserNamePassAuthenticationToken extends UsernamePasswordAuthenticationToken {

	public UserNamePassAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
	}
	
	

}
