package com.daeunp.springsecurityclient.service;

import com.daeunp.springsecurityclient.model.MyUserDetails;
import com.daeunp.springsecurityclient.model.User;
import com.daeunp.springsecurityclient.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	/*
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    */
	
	public boolean exists(String username) {
		return userRepository.existsByUsername(username);
	}
	
	public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        return user.get();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)  {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        return user.map(MyUserDetails::new).get();
	}
	
	public void saveUser(User user) {
		user.setActive(true);
		user.setRoles("ROLE_USER");
		userRepository.save(user);
	}
	
	public User findByName(String name) {
		Optional<User> user = userRepository.findByName(name);	
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + name));
        return user.get();
	}

}
