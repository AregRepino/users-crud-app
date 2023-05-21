package com.example.application.service;

import com.example.application.entity.User;
import com.example.application.exceptions.ResourceNotFoundException;
import com.example.application.mapper.UserMapper;
import com.example.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    private final UserMapper userMapper;

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public User create(User user) {
        user.setId(null);
        return repository.save(user);
    }

    public User update(User user) {
        User dbUser = this.findById(user.getId());
        userMapper.apply(user, dbUser);
        return repository.save(dbUser);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
