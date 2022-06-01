package com.closet.SE8.entities;

import static javax.persistence.GenerationType.SEQUENCE;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue(strategy = SEQUENCE, generator = "user_sequence")
    private Long userNo; // pk

    @Column(name = "userId", unique = true, nullable = false)
    private String userId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "passwd", nullable = false)
    private String passwd;
    
 
    public UserDTO toDTO() {
        return UserDTO.builder()
                .userId(userId)
                .name(name)
                .passwd(passwd)
                .build();
    }
}
