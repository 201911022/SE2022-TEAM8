package com.closet.SE8.entities;

import static javax.persistence.GenerationType.SEQUENCE;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.closet.SE8.dto.UserDTO;
import com.closet.SE8.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user")
@Entity(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
	
	@Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_sequence")
    private Long userNo; // pk

    @Column(name = "userId", unique = true, nullable = false)
    private String userId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "pw", nullable = false)
    private String pw;
    
    @Column(name = "tel", nullable = false)
    private String tel;
    
    @Column(name = "role", nullable = false)
    private String role;
 
    public UserDTO toDTO() {
        return UserDTO.builder()
                .userId(userId)
                .name(name)
                .pw(pw)
                .tel(tel)
                .role(role)
                .build();
    }
}
