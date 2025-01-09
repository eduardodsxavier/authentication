package com.jwt.authentication.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.jwt.authentication.models.User;
import com.jwt.authentication.controllers.UserController;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {
    @Override
    public EntityModel<User> toModel(User u) {
        EntityModel<User> UserModel = EntityModel.of(u);

        return UserModel;
    }
}
