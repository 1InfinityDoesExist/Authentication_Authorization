package in.security.oauth2_5.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import in.security.oauth2_5.security.filter.CustomeAuthenticationFilter;
import in.security.oauth2_5.security.provider.CustomAuthentionProvider;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomeAuthenticationFilter customeAuthenticationFilter;

	@Autowired
	private CustomAuthentionProvider customAuthentionProvider;

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	// adding provider
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthentionProvider);
	}

	// adding filter
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAt(customeAuthenticationFilter, BasicAuthenticationFilter.class);

		http.authorizeRequests().anyRequest().permitAll();
	}

}
