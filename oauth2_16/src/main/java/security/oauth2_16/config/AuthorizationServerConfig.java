package security.oauth2_16.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// clients.withClientDetails(clientDetailsService());
		clients.inMemory().withClient("client").secret("secret").scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token").and().withClient("client1").secret("secret1")
				.scopes("read", "write").authorizedGrantTypes("authorization_code", "refresh_token")
				.redirectUris("http://localhost:9090").and().withClient("client2").secret("secret2")
				.scopes("read", "write").authorizedGrantTypes("client_credentials", "refresh_token");

	}

//	@Bean
//	public MongoClientDetailsService clientDetailsService() {
//		return new MongoClientDetailsService();
//	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(converter());
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(converter());
	}

	@Bean
	public JwtAccessTokenConverter converter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("secret");
		return converter;
	}

}
