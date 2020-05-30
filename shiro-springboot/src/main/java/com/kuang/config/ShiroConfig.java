package com.kuang.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lenovo
 * @date 2020/5/28 14:34
 */
@Configuration
public class ShiroConfig {

    //ShiroFileterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //关联securityManager
        bean.setSecurityManager(securityManager);

        //添加shiro的内置过滤器
        /*
         *  anon:无需认证就可以访问
         *  authc：必须认证了才能访问
         *  user：必须拥有了记住我功能才能用
         *  perms：拥有对某个资源的权限才能访问
         *  role：拥有某个角色权限才可以访问
         * */
        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();

        //授权,未授权正常跳到401
        filterMap.put("/user/add", "perms[user:add]");
        filterMap.put("/user/update", "perms[user:update]");

        filterMap.put("/user/*", "authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //设置未授权页面
        bean.setUnauthorizedUrl("/noauth");
        //设置登陆页面
        bean.setLoginUrl("/toLogin");

        return bean;
    }

    //DafaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UerRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建 realm 对象 ，需要自定义 1
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    //整合shiroDdialect：用来整合shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
