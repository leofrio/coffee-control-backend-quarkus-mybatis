package org.acme.resource;

import lombok.Getter;
import org.acme.dto.UserDetailedDto;
import org.acme.dto.UserDto;
import org.acme.mapper.UserMapper;
import org.acme.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Path("/users")
@ApplicationScoped
public class UserResource {
    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> getAll(@QueryParam("page") @DefaultValue("1")  Integer page, @QueryParam("limit") @DefaultValue("10") Integer limit) {
        return userService.getAll(page,limit);
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDetailedDto getSpecificUser(@PathParam("id") Integer id) {
        return userService.getSpecificUser(id);
    }
}
