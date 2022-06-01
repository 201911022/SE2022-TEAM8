package com.closet.SE8.dto;

import com.closet.SE8.dto.UserDTO;
import com.closet.SE8.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDTO {
    private Integer userNo; // pk
    private String userId;
    private String name;
    private String passwd;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .userId(userId)
                .name(name)
                .passwd(passwd)
                .build();
    }
}
