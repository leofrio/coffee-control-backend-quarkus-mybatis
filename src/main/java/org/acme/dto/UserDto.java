package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.acme.model.User;

@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    public Integer id;
    public String name;
    public String registration;
    public String password;
    public String profile_type;

    public UserDto(User user,String profileType) {
        this.id = user.id;
        this.name = user.name;
        this.registration = user.registration;
        this.password = user.password;
        this.profile_type = profileType;
    }
}