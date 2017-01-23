package com.velware.support.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by uriel on 1/22/2017.
 */
@RestController
public class UserResourceController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
