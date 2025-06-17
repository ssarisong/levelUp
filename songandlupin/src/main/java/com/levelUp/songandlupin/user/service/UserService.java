package com.levelUp.songandlupin.user.service;

import com.levelUp.songandlupin.user.dto.UserInputDto;
import com.levelUp.songandlupin.user.entity.UserEntity;
import com.levelUp.songandlupin.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public UserEntity signUp(UserInputDto userInputDto) {
        String username = userInputDto.getUsername();

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPoint(0);
        return userRepository.save(userEntity);
    }
}
