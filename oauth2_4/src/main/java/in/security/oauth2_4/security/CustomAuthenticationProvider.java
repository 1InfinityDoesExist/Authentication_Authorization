package in.security.oauth2_4.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService UserDetailsService;

	@Autowired
	private PasswordEncoder PasswordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// implement the authentication logic

		// if the request is authenticated return full authenticated authentication
		// instance

		// if the request is not authenticated throw AuthenticationException

		// if the authentication is not supported by this provider return null, null
		// checks another provider

		System.out.println(":::::::::::::::::::::::::::::::");
		String userName = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());
		UserDetails userDetails = UserDetailsService.loadUserByUsername(userName);
		if (userDetails != null) {
			if (PasswordEncoder.matches(password, userDetails.getPassword())) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userName, password, userDetails.getAuthorities());
				return usernamePasswordAuthenticationToken;
			}
		}
		throw new BadCredentialsException("Bad Credentials!!!!");
	}

	@Override
	public boolean supports(Class<?> authentication) { // parameter is type of authentication
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
