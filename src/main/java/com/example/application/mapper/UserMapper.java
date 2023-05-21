package com.example.application.mapper;

import com.example.application.dto.UserContactDto;
import com.example.application.dto.UserDetailsDto;
import com.example.application.dto.UserDto;
import com.example.application.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.Optional;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {
    public abstract UserDto toUserDto(User user);

    public abstract User toUser(UserDto userDto);

    public abstract User toUser(Long id, UserContactDto userContactDto);

    public abstract User toUser(Long id, UserDetailsDto userDetailsDto);

    public void apply(User source, User target) {
        if (source.getBirthdate() != null) {
            target.setBirthdate(source.getBirthdate());
        }
        if (source.getMiddleName() != null) {
            target.setMiddleName(source.getMiddleName());
        }
        Optional.ofNullable(source.getName()).ifPresent(target::setName);

        if (source.getSurname() != null) {
            target.setSurname(source.getSurname());
        }

        if (source.getPhone() != null) {
            target.setPhone(source.getPhone());
        }

        if (source.getEmail() != null) {
            target.setEmail(source.getEmail());
        }

        if (source.getPhotoUrl() != null) {
            target.setPhotoUrl(source.getPhotoUrl());
        }

    }


}
