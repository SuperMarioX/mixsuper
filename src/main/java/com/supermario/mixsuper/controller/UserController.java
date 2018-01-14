package com.supermario.mixsuper.controller;

import com.supermario.mixsuper.entity.UserEntity;
import com.supermario.mixsuper.exception.BaseException;
import com.supermario.mixsuper.exception.BusinessException;
import com.supermario.mixsuper.mapper.UserMapper;
import com.supermario.mixsuper.wrapper.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseWrapper getAllUsers() throws BusinessException {

        LOG.info("Begin to get all users");
        LOG.error("Begin to get all users");
        LOG.debug("Begin to get all users");

        List<Object> allUsers =  userMapper.getAll();

        if (allUsers != null && allUsers.size() == 1) {
            return new ResponseWrapper(200, 200L, "ok", userMapper.getAll());
        } else {
            throw new BusinessException(100L, "ajsdk");
        }


    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseWrapper getUserById(@PathVariable String id) {
        return new ResponseWrapper(200, 200L, "ok", userMapper.getOne(Long.valueOf(id)));
    }
}
