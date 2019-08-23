package com.tactfactory.monsuperprojet.database.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tactfactory.monsuperprojet.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
