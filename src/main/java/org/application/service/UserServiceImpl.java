package org.application.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.application.Repository.UserRepository;
import org.application.entities.Role;
import org.application.entities.User;
import org.application.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(),registrationDto.getLastName(),
				registrationDto.getEmail(),passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		 User user = userRepository.findByEmail(username);
		 if(user == null) {
			 	throw new UsernameNotFoundException("Invalid username or password.");
		 }
		 	return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAutorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAutorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
	
	}
	
}
