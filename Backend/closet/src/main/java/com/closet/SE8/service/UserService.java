package com.closet.SE8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.closet.SE8.dao.UserDAO;
import com.closet.SE8.dto.UserDTO;
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
}
