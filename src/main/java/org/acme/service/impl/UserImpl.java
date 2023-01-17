package org.acme.service.impl;

import org.acme.dto.UserDetailedDto;
import org.acme.dto.UserDto;
import org.acme.form.UserPostForm;
import org.acme.mapper.ProfileMapper;
import org.acme.mapper.UserMapper;
import org.acme.model.User;
import org.acme.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UserImpl implements UserService {

    @Inject
    UserMapper userMapper;
    @Inject
    ProfileMapper profileMapper;

    @Override
    public List<UserDto> getAll(Integer page, Integer limit) {
        Integer offset=(page-1)*limit;
        return userMapper.getAllUsers(limit,offset);
    }

    @Override
    public UserDetailedDto getSpecificUser(Integer id) {
        return userMapper.getSpecificUser(id);
    }

    @Override
    public UserDto register(UserPostForm form) {
        Integer profileId=profileMapper.getIdFromProfileType(form.profile_type);
        User user =new User(form,profileId);
        userMapper.register(user);
        return new UserDto(user,form.profile_type);
    }
}
