package com.blog.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2020/8/15 20:10  by xinghang
 */
@Configuration
public class ShiroConfig {

    @Bean
    public AdminRealm adminRealm() {
        return new AdminRealm();
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(adminRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());
        //这里还要添加过滤器链

        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *    常用的过滤器：
         *       anon: 无需认证（登录）可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememberMe的功能可以直接访问
         *       perms： 该资源必须得到资源权限才可以访问
         *       role: 该资源必须得到角色权限才可以访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();


        shiroFilterFactoryBean.setLoginUrl("/admin");
        shiroFilterFactoryBean.setUnauthorizedUrl("/admin");
        //放行登录的验证请求
        filterMap.put("/admin/login", "anon");
        filterMap.put("/admin/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);


        return shiroFilterFactoryBean;

    }

}
