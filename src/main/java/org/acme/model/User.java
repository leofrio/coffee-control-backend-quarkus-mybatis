package org.acme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.form.UserPostForm;
import org.acme.form.UserUpdateForm;

@NoArgsConstructor
@AllArgsConstructor
public class User {
    public Integer id;
    public String name;
    public String registration;
    public String password;
    public Integer profile_id;
    public User(UserPostForm form,Integer profileId) {
        this.name = form.name;
        this.registration = form.registration;
        this.password = form.password;
        this.profile_id = profileId;
    }
}
