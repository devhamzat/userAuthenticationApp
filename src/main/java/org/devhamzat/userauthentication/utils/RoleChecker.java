package org.devhamzat.userauthentication.utils;

import org.devhamzat.userauthentication.entity.Role;

public class RoleChecker {
    private RoleRepository roleRepository;

    public Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
