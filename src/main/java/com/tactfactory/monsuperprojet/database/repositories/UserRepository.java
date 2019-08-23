package com.tactfactory.monsuperprojet.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tactfactory.monsuperprojet.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
