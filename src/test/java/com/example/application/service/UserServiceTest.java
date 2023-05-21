package com.example.application.service;

import com.example.application.entity.User;
import com.example.application.mapper.UserMapper;
import com.example.application.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Configuration
    @Import(UserService.class)
    static class Config {

    }

    @MockBean
    private UserRepository userRepositoryMock;

    @MockBean
    private UserMapper userMapperMock;

    @Autowired
    private UserService userService;


    @Test
    public void findById() {
//        given
        User expected = new User();
        expected.setId(1L);
        given(userRepositoryMock.findById(1L)).willReturn(Optional.of(expected));

//        when
        User actual = userService.findById(1L);

//        then
        assert actual.equals(expected);
        verify(userRepositoryMock).findById(1L);
    }

    @Test
    public void create() {
//        given
        User user = new User();
        user.setName("Peter");

        User expected = new User();
        expected.setName("Peter");
        expected.setId(1L);
        given(userRepositoryMock.save(user)).willReturn(expected);

//        when
        User actual = userService.create(user);

//        then
        assert actual.equals(expected);
        verify(userRepositoryMock).save(user);

    }

    @Test
    public void update() {
        //        given
        User user = new User();
        user.setName("Peter");
        user.setId(1L);

        User dbUser = new User();
        dbUser.setName("Ivan");
        dbUser.setId(1L);
        given(userRepositoryMock.findById(user.getId())).willReturn(Optional.of(dbUser));
        given(userRepositoryMock.save(any())).willReturn(user);

//        when
        User actual = userService.update(user);

//        then
        assert actual.equals(user);
        verify(userMapperMock).apply(user, dbUser);
        verify(userRepositoryMock).save(any());
        verify(userRepositoryMock).findById(user.getId());
    }

    @Test
    public void delete() {
//        given

//        when
        userService.delete(1L);

//        then
        verify(userRepositoryMock).deleteById(1L);
    }
}
