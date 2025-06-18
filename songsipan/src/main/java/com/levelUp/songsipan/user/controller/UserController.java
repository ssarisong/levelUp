package com.levelUp.songsipan.user.controller;

import com.levelUp.songsipan.user.dto.UserInputDto;
import com.levelUp.songsipan.user.dto.UserUpdateDto;
import com.levelUp.songsipan.user.entity.UserEntity;
import com.levelUp.songsipan.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public UserEntity saveUser(@RequestBody UserInputDto userInputDto) {
        return userService.signUp(userInputDto);
    }

    @PutMapping("/user")
    public UserEntity updateUser(@RequestBody UserUpdateDto userUpdateDto) {
        return userService.update(userUpdateDto);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
