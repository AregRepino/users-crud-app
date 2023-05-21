package com.example.application.controller;

import com.example.application.dto.UserContactDto;
import com.example.application.dto.UserDetailsDto;
import com.example.application.dto.UserDto;
import com.example.application.entity.User;
import com.example.application.mapper.UserMapper;
import com.example.application.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Configuration
    @Import(UserController.class)
    static class Config {
    }


    @MockBean
    private UserService userServiceMock;

    @MockBean
    private UserMapper userMapperMock;

    @Autowired
    private UserController userController;

    @Test
    public void getUser() {
//        given
        UserDto expected = new UserDto();
        expected.setId(1L);
        User user = new User();
        user.setId(1L);
        given(userServiceMock.findById(1L)).willReturn(user);
        given(userMapperMock.toUserDto(user)).willReturn(expected);

//        when
        UserDto actual = userController.getUser(1L);
//        then
        assert actual.equals(expected);

    }


    @Test
    public void deleteUser() {
//        given
//        when
        userController.deleteUser(1L);
//        then
        verify(userServiceMock).delete(1L);

    }

    @Test
    public void createUser() {
//        given
        UserDto userDto = new UserDto();

        UserDto expectedUserDto = new UserDto();
        expectedUserDto.setId(1L);

        User user = new User();
        User dbUser = new User();
        dbUser.setId(1L);

        given(userMapperMock.toUser(userDto)).willReturn(user);
        given(userServiceMock.create(user)).willReturn(dbUser);
        given(userMapperMock.toUserDto(dbUser)).willReturn(expectedUserDto);

//        when
        UserDto actual = userController.createUser(userDto);

//        then
        assert actual.equals(expectedUserDto);

    }

    @Test
    public void updateUserDetails() {
//        given
        UserDetailsDto userDetailsDto = new UserDetailsDto();
        userDetailsDto.setName("any name");

        UserDto expectedUserDto = new UserDto();
        expectedUserDto.setId(1L);

        User user = new User();
        User dbUser = new User();
        dbUser.setId(1L);

        given(userMapperMock.toUser(1L, userDetailsDto)).willReturn(user);
        given(userServiceMock.update(user)).willReturn(dbUser);
        given(userMapperMock.toUserDto(dbUser)).willReturn(expectedUserDto);

//        when
        UserDto actual = userController.updateUserDetail(1L, userDetailsDto);

//        then
        assert actual.equals(expectedUserDto);

    }


    @Test
    public void updateUserContact() {
//        given
        UserContactDto userDetailsDto = new UserContactDto();
        userDetailsDto.setEmail("any name");

        UserDto expectedUserDto = new UserDto();
        expectedUserDto.setId(1L);

        User user = new User();
        User dbUser = new User();
        dbUser.setId(1L);

        given(userMapperMock.toUser(1L, userDetailsDto)).willReturn(user);
        given(userServiceMock.update(user)).willReturn(dbUser);
        given(userMapperMock.toUserDto(dbUser)).willReturn(expectedUserDto);

//        when
        UserDto actual = userController.updateUserContact(1L, userDetailsDto);

//        then
        assert actual.equals(expectedUserDto);

    }
}
