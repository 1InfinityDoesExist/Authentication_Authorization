package in.security.csrf2.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Component;

@Component
public class CsrfTokenConfig implements CsrfTokenRepository {

	@Override
	public CsrfToken generateToken(HttpServletRequest request) {
		CsrfToken csrf = new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", "ABCD12345");
		return csrf;
	}

	@Override
	public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public CsrfToken loadToken(HttpServletRequest request) {

		return null;
	}

}
