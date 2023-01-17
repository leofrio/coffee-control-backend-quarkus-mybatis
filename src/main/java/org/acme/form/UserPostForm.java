package org.acme.form;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.acme.model.User;

@NoArgsConstructor
@AllArgsConstructor
public class UserPostForm {
    public String name;
    public String registration;
    public String password;
    public String profile_type;
}
