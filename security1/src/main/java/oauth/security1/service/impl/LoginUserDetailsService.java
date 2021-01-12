package oauth.security1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import oauth.security1.entity.UserPDetails;
import oauth.security1.model.LoginUserDetails;
import oauth.security1.repository.UserPDetailsRepository;

/*
 * Note do not add service or component here if you have used @Bean in config class for LoginUserDetailsService
 */
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	private UserPDetailsRepository userPDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserPDetails userPDetails = userPDetailsRepository.findByUserName(username);
		return new LoginUserDetails(userPDetails);
	}

}
