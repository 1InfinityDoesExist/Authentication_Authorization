package in.security.oauth2_4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerCofig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	/*
	 * Authorized Grant Types --how resource owner gonna interact with Authorization
	 * directly or via client server
	 */

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {// you can add here multiple clients
		clients.inMemory().withClient("avinash").secret("avinash").scopes("read").accessTokenValiditySeconds(80000)
				.authorizedGrantTypes("password", "refresh_token");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
	}

	/*
	 * This is mainly for validation for resource server
	 */
	// by default it denies all
	// http://localhost:8080/oauth/check_token?token=839fcd96-5032-48f1-a0c0-6aa4732d519d
	// add .checkTokenAccess("isAuthenticated()") pass basic auth
	// add .checkTokenAccess("permitAll()") disable basic auth bad approach
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.passwordEncoder(NoOpPasswordEncoder.getInstance()).checkTokenAccess("permitAll()");
	}

}
