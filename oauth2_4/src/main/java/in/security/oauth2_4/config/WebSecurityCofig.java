package in.security.oauth2_4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/*
 * http://localhost:8080/oauth/authorize?response_type=code&client_id=avinash&scope=read
 */
@Configuration
public class WebSecurityCofig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetails() {
		InMemoryUserDetailsManager iMemoryUserDetailsmanager = new InMemoryUserDetailsManager();
		UserDetails userDetails = User.withUsername("Mark").password(passwordEncoder().encode("12345"))
				.authorities("read").build();
		iMemoryUserDetailsmanager.createUser(userDetails);
		return iMemoryUserDetailsmanager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * Combiner userDetails with authentication server
	 */
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	/*
	 * For browser form
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().anyRequest().authenticated();
	}

}
