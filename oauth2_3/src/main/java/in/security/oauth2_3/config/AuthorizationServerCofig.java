package in.security.oauth2_3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

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
		clients.inMemory().withClient("avinash").secret("avinash").scopes("read")
				.authorizedGrantTypes("password", "refresh_token").and().withClient("avinash1").secret("avinash1")
				.scopes("read").authorizedGrantTypes("authorization_code").redirectUris("http://localhost:8083").and()
				.withClient("avinash2").secret("avinash2").scopes("read").authorizedGrantTypes("client_credentials");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
	}

}
