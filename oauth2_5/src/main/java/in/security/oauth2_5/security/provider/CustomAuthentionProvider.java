package in.security.oauth2_5.security.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import in.security.oauth2_5.security.authentication.CustomAuthentication;
import in.security.oauth2_5.security.filter.CustomeAuthenticationFilter;

@Component
public class CustomAuthentionProvider implements AuthenticationProvider {

	@Value("${key}")
	private String key;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String requestKey = authentication.getName();
		if (requestKey.equals(key)) {
			CustomAuthentication customAuthentication = new CustomAuthentication(null, null, null);
			return customAuthentication;
		} else {
			throw new BadCredentialsException("Bad Request");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return CustomAuthentication.class.equals(authentication);
	}

}
