package in.security.oauth2_5.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import in.security.oauth2_5.security.authentication.CustomAuthentication;

@Component
//delegate the responsibility to AuthenticationManager
public class CustomeAuthenticationFilter implements Filter {

	@Autowired
	private AuthenticationManager authenticationManger;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String authorization = req.getHeader("Authorization");

		System.out.println(authorization);
		CustomAuthentication customeAuth = new CustomAuthentication(authorization, null, null);
		Authentication result = authenticationManger.authenticate(customeAuth);
		System.out.println(result);
		if (result.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(result);
			chain.doFilter(request, response);
		}

	}

}
