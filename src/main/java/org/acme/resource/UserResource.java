package org.acme.resource;

import lombok.Getter;
import org.acme.dto.UserDetailedDto;
import org.acme.dto.UserDto;
import org.acme.mapper.UserMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserResource {
    @Inject
    UserMapper userMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> getAll(@QueryParam("page") @DefaultValue("1") Integer page, @QueryParam("limit") @DefaultValue("10") Integer limit) {
        Integer offset=(page-1)*20;
        return userMapper.getAllUsers(limit,offset);
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDetailedDto getSpecificUser(@PathParam("id") Integer id) {
        return userMapper.getSpecificUser(id);
    }
}
