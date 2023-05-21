package com.example.application.mapper;

import com.example.application.entity.User;
import org.junit.Test;

import java.time.LocalDate;


public class UserMapperTest {


    private final UserMapperImpl userMapper = new UserMapperImpl();


    @Test
    public void apply() {
//        given
        User sourceUser = new User();
        sourceUser.setName("any name");
        sourceUser.setSurname("any surname");
        sourceUser.setMiddleName("any middle name");
        sourceUser.setPhone("any phone");
        sourceUser.setEmail("any@mail.ru");
        sourceUser.setBirthdate(LocalDate.now());
        sourceUser.setPhotoUrl("any-photo.png");

        User targetUser = new User();

//        when
        userMapper.apply(sourceUser, targetUser);

//        then
        assert targetUser.equals(sourceUser);
//        assertUser(sourceUser, targetUser);

    }

//    private void assertUser(User userA, User userB) {
//        assert userA.getBirthdate() == null || userA.getBirthdate().equals(userB.getBirthdate());
//        assert userA.getMiddleName() == null || userA.getMiddleName().equals(userB.getMiddleName());
//        assert userA.getName() == null || userA.getName().equals(userB.getName());
//        assert userA.getSurname() == null || userA.getSurname().equals(userB.getSurname());
//        assert userA.getPhone() == null || userA.getPhone().equals(userB.getPhone());
//        assert userA.getEmail() == null || userA.getEmail().equals(userB.getEmail());
//        assert userA.getPhotoUrl() == null || userA.getPhotoUrl().equals(userB.getPhotoUrl());
//    }

}
