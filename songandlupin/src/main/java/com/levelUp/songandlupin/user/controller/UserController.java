package com.levelUp.songandlupin.user.controller;

import com.levelUp.songandlupin.user.dto.UserInputDto;
import com.levelUp.songandlupin.user.entity.UserEntity;
import com.levelUp.songandlupin.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    //Get: 조회
    //Post: 생성
    //Put: 수정
    //Patch: 부분 수정
    //Delete: 삭제
    @PostMapping("/user")
    public UserEntity saveUser(@RequestBody UserInputDto userInputDto) {
        return userService.signUp(userInputDto);
    }
}
