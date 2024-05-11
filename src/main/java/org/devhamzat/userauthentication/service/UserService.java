package org.devhamzat.userauthentication.service;

import org.devhamzat.userauthentication.dto.UserDto;
import org.devhamzat.userauthentication.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(UserDto userDto);

   Optional<User> findUserByEmailOrUserName(String email,String userName);

}
