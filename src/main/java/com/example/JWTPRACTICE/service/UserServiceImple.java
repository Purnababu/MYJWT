package com.example.JWTPRACTICE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JWTPRACTICE.entity.Role;
import com.example.JWTPRACTICE.entity.User;
import com.example.JWTPRACTICE.repo.Userrepo;

@Service
public class UserServiceImple  implements UserService{
	 @Autowired
	private Userrepo urp;

	@Override
	public User createUser(User user) {
		 
		return null;
	}

	@Override
	public User getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role createRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role getAllRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role getRoleBYId(long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
