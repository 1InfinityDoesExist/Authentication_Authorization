package security.oauth2_24.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/*
 * EndPoint Authorization 
 * 
 * And GloblaMethodSecurity
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	// authorities("ROLE_admin") becomes hasRole("admin")
	// user must have a role or authority
	// spring security adds ROLE_ before ADMIN so dont add...
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		UserDetails user1 = User.withUsername("patel1").password("patel1").authorities("ROLE_ADMIN").build();
		UserDetails user2 = User.withUsername("patel2").password("patel2").roles("MANAGER").build();
		inMemoryUserDetailsManager.createUser(user1);
		inMemoryUserDetailsManager.createUser(user2);
		return inMemoryUserDetailsManager;
	}

	/*
	 * hasAuthority(), hasAnyAuthority(), hasRole(), hasAnyRole(), access()
	 * 
	 */
	// authority represents action, role represents badge
	// GrantedAuthority is a contract that represents both authority and role
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic();
		http.csrf().disable();// for post request you have to disable it also for delete...
		// http.authorizeRequests().anyRequest().hasRole("ADMIN");

		/*
		 * MVC matchers
		 * 
		 * ANT matchers
		 * 
		 * regex matchers
		 */
		http.authorizeRequests().mvcMatchers("/hello").hasRole("ADMIN").mvcMatchers("/ciao").hasRole("MANAGER")
				.anyRequest().authenticated();
	}
}
