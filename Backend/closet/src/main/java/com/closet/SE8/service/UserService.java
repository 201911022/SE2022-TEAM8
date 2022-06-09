package com.closet.SE8.service;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.closet.SE8.dao.UserDAO;
import com.closet.SE8.dto.UserDTO;
import com.closet.SE8.entities.UserEntity;
import com.closet.SE8.repo.UserRepository;

@Service
public class UserService implements UserDAO{
	private final UserRepository userRepository;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	public Long join(UserDTO user) {
		String encryptedPassword = encoder.encode(user.getPw());
		user.setPw(encryptedPassword);
		return this.userRepository.saveAndFlush(user.toEntity()).getUserNo();
	}
	
	public boolean login(HashMap<String, String> map) {
		Optional<UserEntity> user= this.userRepository.findByUserId(map.get("userId"));
		return encoder.matches(map.get("pw"), user.get().getPw());
	}
	
	public boolean update(HashMap<String, String> map, String id) {
		Optional<UserEntity> user = this.userRepository.findByUserId(id);
		UserEntity newUser = user.get();
		String encryptedPassword = encoder.encode(map.get("pw"));
		if (user.isPresent()) {
			newUser.setName(map.get("name"));
			newUser.setPw(encryptedPassword);
			newUser.setTel(map.get("tel"));
			
			userRepository.save(newUser);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean delete(String id) {
		Optional<UserEntity> user = this.userRepository.findByUserId(id);
		if(user.isPresent()) {
			userRepository.delete(user.get());
			return true;
		}
		else {
			return false;
		}
	}
}
