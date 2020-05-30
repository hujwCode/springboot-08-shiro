package com.kuang.config;

import com.kuang.pojo.User;
import com.kuang.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义的UserRealm
 *
 * @author lenovo
 * @date 2020/5/28 14:37
 */

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserServiceImpl userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权-》doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前登陆的对象
        Subject subject = SecurityUtils.getSubject();
        //拿到user对象
        User currentUser = (User) subject.getPrincipal();
        //设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证-》doGetAuthenticationInfo");

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        //连接数据库
        User user = userService.queryUserByName(userToken.getUsername());
        if (user == null){
            return null;
        }

        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser",user);

        //可以加密，  MD5加密      MD5盐值加密
        //密码认证，shiro来做
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
