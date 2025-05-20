package com.imran.SpringSecurity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Long> {
    user findByUsername(String username); // optional but useful
}
