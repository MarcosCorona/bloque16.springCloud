package com.bosonit.tripfrontend.client;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long userId;
    private String name;
    private String lastname;
    private int age;
    private String email;
    private String telephone;
    private Collection<Role> roles = new ArrayList<>();
    private String username;
    private String password;

}
