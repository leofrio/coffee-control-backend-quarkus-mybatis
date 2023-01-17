package org.acme.service;

import org.acme.dto.UserDetailedDto;
import org.acme.dto.UserDto;
import org.acme.form.UserPostForm;
import org.acme.form.UserUpdateForm;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.util.List;

public interface UserService {
    public List<UserDto> getAll(Integer page, Integer limit);


    public UserDetailedDto getSpecificUser(@PathParam("id") Integer id);

    UserDto register(UserPostForm form);


    UserDto update(Integer id, UserUpdateForm form);

    UserDto deleteUser(Integer id);
}
