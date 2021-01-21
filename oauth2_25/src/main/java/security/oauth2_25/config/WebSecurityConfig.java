package security.oauth2_25.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
		UserDetails user1 = User.withUsername("patel1").password("patel1").authorities("read").build();
		UserDetails user2 = User.withUsername("patel2").password("patel2").authorities("write").build();
		inMemoryUserDetailsManager.createUser(user1);
		inMemoryUserDetailsManager.createUser(user2);
		return inMemoryUserDetailsManager;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		// mvnMatcher()
		// antMatcher()

		// /a/* it means /a/0-1
		// /a/** it means /a/0-more
		// .authenticated() looks for only validation not for authorization
//		http.authorizeRequests().mvcMatchers("/**").hasAuthority("read").mvcMatchers("/c/{name}").authenticated()
//				.anyRequest().denyAll();

//		http.authorizeRequests().antMatchers("/a/**").hasAuthority("read").anyRequest().denyAll();

		
		//don't use antMatchers() /a authenticate try with /a/ it also work.
		//to solve it use mvc matchers
		http.authorizeRequests().mvcMatchers(HttpMethod.GET,"/a").authenticated()
		.anyRequest().permitAll();
	}
}
