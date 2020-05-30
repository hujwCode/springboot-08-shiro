package com.kuang.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义的UserRealm
 *
 * @author lenovo
 * @date 2020/5/28 14:37
 */

public class UserRealm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权-》doGetAuthorizationInfo");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证-》doGetAuthenticationInfo");

        //用户名，密码 从数据库中取
        String name ="root";
        String password = "root";
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        if(!userToken.getUsername().equals(name)){
            return null; //自动抛出异常 UnknownAccountException
        }
        //密码认证，shiro来做
        return new SimpleAuthenticationInfo("",password,"");
    }
}
