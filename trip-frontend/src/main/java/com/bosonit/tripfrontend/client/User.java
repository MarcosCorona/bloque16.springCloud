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

    private String name;
    private String lastname;
    private String email;
    private String telephone;

}
