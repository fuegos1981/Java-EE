package ua.fuego_2000.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ua.fuego_2000.model.User;
import ua.fuego_2000.service.UserService;

@Component
public class MyUserDeteilsService implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		User user = userService.getByLogin(login);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole().toString());
		System.out.println(user.getRole().toString() + "; " + login + "; " + user.getPassword());
		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(login,
				user.getPassword(), Arrays.asList(authority));
		return userDetails;
	}

}
