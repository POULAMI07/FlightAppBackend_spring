package com.example.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.user;
@Service
public class JwtUserDetailsService implements UserDetailsService{
	String url="http://localhost:8989/user/userController/search";
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	public user user;
	
	public RestTemplate rest_template = new RestTemplate();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user userobj = rest_template.getForObject(url+"/"+username,user.class);
		
		/*if ("javainuse".equals(username)) {
			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}*/
		//System.out.println(userobj);
		
		if (userobj==null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	
		return new org.springframework.security.core.userdetails.User(userobj.getEmail(), bcryptEncoder.encode(userobj.getPassword()),
				new ArrayList<>());
	}
}
