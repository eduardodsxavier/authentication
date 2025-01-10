package com.jwt.authentication.controllers;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jwt.authentication.models.User;
import com.jwt.authentication.repositorys.UserRepository;
import com.jwt.authentication.assembler.UserModelAssembler;

@RequestMapping(path="/user")
@Controller
public class UserController {
    private UserRepository repository;
    private UserModelAssembler assembler;
    
    UserController(UserRepository repository, UserModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    // return all users from db
    @GetMapping("")
    @ResponseBody
    public CollectionModel<EntityModel<User>> all() {
        List<EntityModel<User>> users = repository.findAll().stream().map(
                assembler::toModel).collect(Collectors.toList());

        return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
    }
    
    // try to login as a user in the db
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User u) {
        if (repository.findByName(u.getName()).get(0).getPassword().equals(u.getPassword())) {
            return "200";
        }
        
        return "201";
    }


    // try to add a user in the db
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<EntityModel<User>> register(@RequestBody User u) {
        User newUser = repository.save(u);
        
        return ResponseEntity.created(linkTo(methodOn(UserController.class).all()).toUri()).body(
                assembler.toModel(newUser));
    }
}
