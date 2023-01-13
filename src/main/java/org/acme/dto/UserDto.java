package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    public Integer id;
    public String name;
    public String registration;
    public String password;
    public String profile_type;

}