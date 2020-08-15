package com.blog.service;

import com.blog.pojo.User;

import javax.websocket.server.PathParam;

public interface UserService {

    public User checkUser(String username, String password);

    public User selectUserByUserName(String username);
}
