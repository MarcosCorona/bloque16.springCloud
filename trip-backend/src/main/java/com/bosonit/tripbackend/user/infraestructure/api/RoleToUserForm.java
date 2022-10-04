package com.bosonit.tripbackend.user.infraestructure.api;

import lombok.Data;

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
