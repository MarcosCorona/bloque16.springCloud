package com.bosonit.tripbackend.user.infraestructure.repo;

import com.bosonit.tripbackend.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findByUserId(Long id);

}
