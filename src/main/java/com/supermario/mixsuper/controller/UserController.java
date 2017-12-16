package com.supermario.mixsuper.controller;

import com.supermario.mixsuper.entity.UserEntity;
import com.supermario.mixsuper.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RestController
public class UserController {

    private static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<UserEntity> getAllUsers() {

        LOG.info("Begin to get all users");
        LOG.error("Begin to get all users");
        LOG.debug("Begin to get all users");

        return userMapper.getAll();
    }
}
