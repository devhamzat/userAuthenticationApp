package org.devhamzat.userauthentication.service;

import org.devhamzat.userauthentication.dto.UserDto;
import org.devhamzat.userauthentication.entity.User;
import org.devhamzat.userauthentication.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceIMPL implements UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserServiceIMPL(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(UserDto userDto) {
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getUserName(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
        if (user == null){
            throw new
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email,String userName) {
       Optional<User> userPresent = findUserByEmailOrUserName(email, userName);
        if (userPresent.isPresent()){
            throw new
        }

        return userRepository.findUserByEmailOrUserName(email,userName);
    }
}
