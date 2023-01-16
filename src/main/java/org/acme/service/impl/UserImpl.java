package org.acme.service.impl;

import org.acme.dto.UserDetailedDto;
import org.acme.dto.UserDto;
import org.acme.mapper.UserMapper;
import org.acme.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UserImpl implements UserService {

    @Inject
    UserMapper userMapper;

    @Override
    public List<UserDto> getAll(Integer page, Integer limit) {
        Integer offset=(page-1)*limit;
        return userMapper.getAllUsers(limit,offset);
    }

    @Override
    public UserDetailedDto getSpecificUser(Integer id) {
        return userMapper.getSpecificUser(id);
    }
}
