package com.levelUp.songsipan.user.service;

import com.levelUp.songsipan.user.dto.UserInputDto;
import com.levelUp.songsipan.user.dto.UserUpdateDto;
import com.levelUp.songsipan.user.entity.UserEntity;
import com.levelUp.songsipan.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class UserService {

    private UserRepository userRepository;

    //회원 가입
    public UserEntity signUp(UserInputDto userInputDto) {
        String username = userInputDto.getUsername();

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        return userRepository.save(userEntity);
    }

    //회원 정보 수정
    public UserEntity update(UserUpdateDto userUpdateDto) {
        UserEntity userEntity = userRepository.findById(userUpdateDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("수정 못해요. id 없어."));
        userEntity.setUsername(userUpdateDto.getUsername());
        return userRepository.findById(userEntity.getId()).get();
    }

    //회원 탈퇴
    public void delete(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("탈퇴 못해요. id가 존재하지 않아요."));
        userRepository.delete(userEntity);
    }
}
