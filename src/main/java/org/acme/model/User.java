package org.acme.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class User {
    Integer id;
    String name;
    String registration;
    String password;
    Integer profile_id;
}
