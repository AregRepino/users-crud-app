package com.example.application.controller;

import com.example.application.dto.UserContactDto;
import com.example.application.dto.UserDetailsDto;
import com.example.application.dto.UserDto;
import com.example.application.entity.User;
import com.example.application.mapper.UserMapper;
import com.example.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        return userMapper.toUserDto(user);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody @Validated UserDto userDto) {
        User user = userMapper.toUser(userDto);
        User createdUser = userService.create(user);
        return userMapper.toUserDto(createdUser);
    }

    @PatchMapping("/{id}/details")
    public UserDto updateUserDetail(@PathVariable Long id, @RequestBody @Validated UserDetailsDto userDetailsDto) {
        User user = userMapper.toUser(id, userDetailsDto);
        User createdUser = userService.update(user);
        return userMapper.toUserDto(createdUser);
    }

    @PatchMapping("/{id}/contact")
    public UserDto updateUserContact(@PathVariable Long id, @RequestBody @Validated UserContactDto userContactDto) {
        User user = userMapper.toUser(id, userContactDto);
        User createdUser = userService.update(user);
        return userMapper.toUserDto(createdUser);
    }
}
