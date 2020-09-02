package com.daeunp.springsecurityclient.repository;

import com.daeunp.springsecurityclient.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{
	boolean existsByUsername(String username);
	Optional<User> findByUsername(String username);
	Optional<User> findByName(String name);
}
