package com.blog.config;

import com.blog.pojo.User;
import com.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description TODO
 * @Date 2020/8/15 19:44  by xinghang
 */
@Slf4j
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.warn("用户的授权");
        log.warn(principalCollection.getPrimaryPrincipal().toString());
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //根据用户的姓名获取用户
        User user = userService.selectUserByUserName(token.getUsername());
        //没有用户就返回
        if (user == null) {
            log.warn("用户登录失败，无此用户。");
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), "");

        return authenticationInfo;
    }
}
