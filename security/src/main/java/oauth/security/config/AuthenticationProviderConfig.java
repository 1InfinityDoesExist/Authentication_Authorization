package oauth.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.db.dialect.MySQLDialect;

/*
 * Issue being called twice
 */
@Component
public class AuthenticationProviderConfig implements AuthenticationProvider {

	@Value("${secret_key:patel}")
	String secretKey;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("::::::Inside AuthenticationProviderConfig class, authenticate:::::");

//		String password = authentication.getCredentials().toString();
//		String username = authentication.getName();
//		// fetch records form in-memory
//		UserDetails user = userDetailsService.loadUserByUsername(username);
//		if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//			return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials());
//		}
//		return null;

		if (secretKey.equals(authentication.getName())) {
			return new UserNamePassAuthenticationToken(null, null);
		}
		return null;

	}

	@Override
	public boolean supports(Class<?> authentication) {
		System.out.println(":::::Inside AuthenticationProviderConfig class, support method:::::::");
		// return UsernamePasswordAuthenticationToken.class.equals(authentication);

		return UserNamePassAuthenticationToken.class.equals(authentication);
	}

}
