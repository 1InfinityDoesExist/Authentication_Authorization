package in.security.oauth2_9.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

import in.security.oauth2_9.csrf.CustomCsrfRepository;
import in.security.oauth2_9.logger.CsrfTokenFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		// http.csrf().disable();
		http.csrf(c -> {
			c.ignoringAntMatchers("/csrfDisabled/**");
			c.csrfTokenRepository(new CustomCsrfRepository());
		});

		http.addFilterAfter(new CsrfTokenFilter(), CsrfFilter.class);

	}

}
