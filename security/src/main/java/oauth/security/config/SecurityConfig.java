package oauth.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

	/**
	 * Just to override default username and password
	 * 
	 * @return
	 */
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		UserDetails userDetails = User.withUsername("patel").password("patel").authorities("read").build();
		inMemoryUserDetailsManager.createUser(userDetails);
		return inMemoryUserDetailsManager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
