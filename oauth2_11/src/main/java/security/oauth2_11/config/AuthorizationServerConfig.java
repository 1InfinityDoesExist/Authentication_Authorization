package security.oauth2_11.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	/*
	 * authorization_code, password, refresh_token, client_credentials, implicit
	 */

	// http://localhost:8080/oauth/authorize?response_type=code&client_id=client1&scope=read
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("client").secret("secret").scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token").and().withClient("client1").secret("secret1")
				.scopes("read", "write").authorizedGrantTypes("authorization_code", "refresh_token")
				.redirectUris("http://localhost:9090").and().withClient("client2").secret("secret2")
				.scopes("read", "write").authorizedGrantTypes("client_credentials", "refresh_token");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(converter());
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(converter());
	}

	@Bean
	public JwtAccessTokenConverter converter() {
		return new JwtAccessTokenConverter();
	}
}
