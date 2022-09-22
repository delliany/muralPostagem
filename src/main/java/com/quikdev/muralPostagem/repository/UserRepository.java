package com.quikdev.muralPostagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quikdev.muralPostagem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);
}
