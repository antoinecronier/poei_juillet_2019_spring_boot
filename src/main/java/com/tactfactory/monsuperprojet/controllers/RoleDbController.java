package com.tactfactory.monsuperprojet.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.monsuperprojet.database.repositories.RoleRepository;
import com.tactfactory.monsuperprojet.entities.Role;

@RestController
@RequestMapping(value = { "/role" })
public class RoleDbController {

    @Autowired
    private RoleRepository repository;

    @RequestMapping(value = { "" }, method = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH })
    public ResponseEntity<Role> rolePost(@RequestBody Role role) {
        return new ResponseEntity<Role>(repository.save(role), HttpStatus.CREATED);
    }

    @RequestMapping(value = { "" }, method = RequestMethod.GET)
    public List<Role> roleGet() {
        return (List<Role>) repository.findAll();
    }

    @RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
    public Optional<Role> roleGetById(@PathVariable(value = "id") Integer id) {
        return repository.findById(id);
    }

    @RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
    public void roleDelete(@PathVariable(value = "id") Integer id) {
        repository.deleteById(id);
    }
}
