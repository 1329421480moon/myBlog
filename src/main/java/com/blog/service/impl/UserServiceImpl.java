package com.blog.service.impl;

import com.blog.dao.UserDao;
import com.blog.pojo.User;
import com.blog.service.UserService;
import com.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.queryByUsernameAndPassword(username, MD5Utils.code(password));
//        User user = userDao.queryByUsernameAndPassword(username,password);
        return user;
    }

    @Override
    public User selectUserByUserName(String username){
        User user = userDao.selectUserByUserName(username);
        return user;
    }
}
