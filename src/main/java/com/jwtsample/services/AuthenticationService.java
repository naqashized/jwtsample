package com.jwtsample.services;

import com.jwtsample.dtos.SignupRequest;
import com.jwtsample.models.User;
import com.jwtsample.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public User authenticateUser(String username ,String accessId){
		User user = userRepository.findUserByUsernameAndAccessId(username, accessId).orElseThrow(() -> new BadCredentialsException("Invalid credentials"));
		return user;
	}

	public void signupUser(SignupRequest signupRequest){
		User user = new User();
		user.setUsername(signupRequest.getUsername());
		user.setAccessId(signupRequest.getAccessId());
		user.setEnabled(true);
		user.setAccountNonExpired(true);
		user.setAccountNonExpired(true);
		user.setCredentialsNonExpired(true);
		user.setAccountNonLocked(true);
		user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
		userRepository.save(user);
	}

	@Transactional
	public UserDetails loadUserById(Long id) throws Exception {
		return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {
		return userRepository.findUserByUsername(username).orElseThrow(() -> new EntityNotFoundException("User not found"));
	}
}
