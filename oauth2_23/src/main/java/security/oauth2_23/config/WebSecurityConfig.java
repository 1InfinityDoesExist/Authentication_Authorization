package security.oauth2_23.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		UserDetails userDetails1 = User.withUsername("patel1").password("patel1").authorities("ROLE_manager").build();
		UserDetails userDetails2 = User.withUsername("patel2").password("patel2").authorities("ROLE_admin").build();
		inMemoryUserDetailsManager.createUser(userDetails1);
		inMemoryUserDetailsManager.createUser(userDetails2);
		return inMemoryUserDetailsManager;
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	// Role represents badge
	// authority represents action
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		// http.authorizeRequests().anyRequest().hasAuthority( "manager");
		// http.authorizeRequests().anyRequest().hasAnyAuthority("admin", "manager");
		http.authorizeRequests().anyRequest().hasRole("manager");

	}
}
