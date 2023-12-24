package com.example.JWTPRACTICE.service;

import com.example.JWTPRACTICE.entity.Role;
import com.example.JWTPRACTICE.entity.User;

public interface UserService {
	
	
	User createUser (User user);
	User getAll();
	User getUserById(long id);
	
	Role createRole(Role role);
	Role getAllRole();
	Role getRoleBYId(long roleId);

}
