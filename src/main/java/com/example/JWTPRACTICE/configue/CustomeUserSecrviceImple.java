package com.example.JWTPRACTICE.configue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.JWTPRACTICE.entity.User;
import com.example.JWTPRACTICE.repo.Userrepo;

@Service
public class CustomeUserSecrviceImple implements UserDetailsService {

	@Autowired
	private Userrepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.repo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("not found");
		}

		return user;
	}

}
