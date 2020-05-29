package com.kuang.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 * @author lenovo
 * @date 2020/5/28 14:34
 */
@Configuration
public class ShiroConfig {

    //ShiroFileterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //关联securityManager
        bean.setSecurityManager(securityManager);
        return bean;
    }

    //DafaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UerRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建 realm 对象 ，需要自定义 1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }


}
