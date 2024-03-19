package com.ftn.realestatemanagement.repository;

import com.ftn.realestatemanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
