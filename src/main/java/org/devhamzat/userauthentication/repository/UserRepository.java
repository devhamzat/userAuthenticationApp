package org.devhamzat.userauthentication.repository;

import org.devhamzat.userauthentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmailOrUserName(String email,String userName);

    User findUserByUserName(String userName);


}
