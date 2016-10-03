package com.example.demo.service;

import com.example.demo.models.CustomUserDetails;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepositoryInterface;
import com.example.demo.repository.UserRoleRepositoryInterface;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	private final UserRepositoryInterface userRepositoryInterface;
	private final UserRoleRepositoryInterface userRoleRepositoryInterface;

	@Autowired(required = true)
	public CustomUserDetailsService(
			UserRepositoryInterface userRepositoryInterface,
			UserRoleRepositoryInterface userRoleRepositoryInterface) {
		this.userRepositoryInterface = userRepositoryInterface;
		this.userRoleRepositoryInterface = userRoleRepositoryInterface;
	}

	/*
	 * Verify if user and roles exists in database - if true send user to
	 * CustomUserDetails with Roles UserDetailsService - verify
	 */
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user = userRepositoryInterface.findByLogin(userName);
		if (null == user) {
			throw new UsernameNotFoundException(
					"INVALID USER WITH LOGIN: " + userName);
		} else {
			List<String> userRoles = userRoleRepositoryInterface
					.findRoleByUserId(user.getId());
			return new CustomUserDetails(user, userRoles);
		}
	}

}
