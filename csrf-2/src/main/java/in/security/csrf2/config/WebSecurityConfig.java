package in.security.csrf2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CsrfFilter filter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.csrf().disable();

		http.csrf(csrf -> csrf.csrfTokenRepository(new CsrfTokenConfig()));
		//http.addFilterAfter(filter, CsrfFilter.class);
	}

}
