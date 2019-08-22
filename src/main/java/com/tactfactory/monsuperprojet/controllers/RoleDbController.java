package com.tactfactory.monsuperprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.monsuperprojet.database.repositories.RoleRepository;
import com.tactfactory.monsuperprojet.entities.Role;

@RestController
public class RoleDbController {

    @Autowired
    private RoleRepository repository;

    @RequestMapping(value = {"/role/insert"})
    public void insert(Role role) {
        repository.save(new Role("test"));
    }
}
