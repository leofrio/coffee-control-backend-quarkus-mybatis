package org.acme.service;

import org.acme.dto.UserDetailedDto;
import org.acme.dto.UserDto;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.util.List;

public interface UserService {
    public List<UserDto> getAll(Integer page, Integer limit);


    public UserDetailedDto getSpecificUser(@PathParam("id") Integer id);
}
