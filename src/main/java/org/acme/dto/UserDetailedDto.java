package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.acme.model.User;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class UserDetailedDto {

    public Integer id;

    public String name;

    public String registration;

    public String password;

    public String profile_type;

    public Integer amountSolicitations;
    public Integer amountContributions;

    public User convert(Integer profileId) {
        return new User(this.id,this.name,this.registration,this.registration,profileId);
    }
}
