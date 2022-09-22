package com.quikdev.muralPostagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quikdev.muralPostagem.model.User;
import com.quikdev.muralPostagem.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	static User userMuralPostagem = new User();

	public UserService() {
		super();
	}

	public User editUser(User user) {
		userMuralPostagem = userRepository.saveAndFlush(user);
		return userMuralPostagem;
	}

	public User login(User user) {
		userMuralPostagem = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

		if (userMuralPostagem != null) {
			userMuralPostagem.setHasAuthorization(true);

		} else {
			userMuralPostagem = new User();
			userMuralPostagem.setHasAuthorization(false);
		}
		
		userRepository.saveAndFlush(userMuralPostagem);

		return userMuralPostagem;
	}
}
