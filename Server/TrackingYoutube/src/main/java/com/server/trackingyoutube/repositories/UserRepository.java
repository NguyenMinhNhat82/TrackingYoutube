package com.server.trackingyoutube.repositories;

import com.server.trackingyoutube.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(String id);
}
