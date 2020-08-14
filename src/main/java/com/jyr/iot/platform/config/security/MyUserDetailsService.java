package com.jyr.iot.platform.config.security;

import com.jyr.iot.platform.mapper.PermissionMapper;
import com.jyr.iot.platform.mapper.UserMapper;
import com.jyr.iot.platform.pojo.Permission;
import com.jyr.iot.platform.pojo.PermissionExample;
import com.jyr.iot.platform.pojo.User;
import com.jyr.iot.platform.pojo.UserExample;
import com.jyr.iot.platform.pojogroup.UserGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionMapper permissionMapper;


//    @Autowired
//    private PasswordEncoder passwordEncoder;
    /**
     * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<com.jyr.iot.platform.pojo.User> users = userMapper.selectByExample(example);
        if (null == users) {
            throw new UsernameNotFoundException(username);
        }
        User user = users.get(0);
        PermissionExample permissionExample = new PermissionExample();
        PermissionExample.Criteria criteriaPermission = permissionExample.createCriteria();
        criteriaPermission.andPermissionIdEqualTo(user.getUserPermissionId());
        List<Permission> permissions = permissionMapper.selectByExample(permissionExample);
        Permission permission = permissions.get(0);

        return new UserGroup(user,permission,null,null);

//        List<GrantedAuthority> authorities = new ArrayList<>();
//        switch (users.get(0).getUserRole()){
//            case 0:
//                authorities.add(new SimpleGrantedAuthority("SUPER"));
//                authorities.add(new SimpleGrantedAuthority("COMPANY"));
//                authorities.add(new SimpleGrantedAuthority("PROJECT"));
//                authorities.add(new SimpleGrantedAuthority("COMMON"));
////                authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("SUPER,COMPANY,PROJECT,COMMON");
//                break;
//            case 1:
//                authorities.add(new SimpleGrantedAuthority("COMPANY"));
//                authorities.add(new SimpleGrantedAuthority("PROJECT"));
//                authorities.add(new SimpleGrantedAuthority("COMMON"));
////                authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("COMPANY,PROJECT,COMMON");
//                break;
//            case 2:
//                authorities.add(new SimpleGrantedAuthority("PROJECT"));
//                authorities.add(new SimpleGrantedAuthority("COMMON"));
////                authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("PROJECT,COMMON");
//                break;
//            case 3:
//                authorities.add(new SimpleGrantedAuthority("COMMON"));
////                authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("COMMON");
//                break;
//            default:
//                authorities.add(new SimpleGrantedAuthority("COMMON"));
////                authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("COMMON");
//                break;
//        }
//        return users.get(0);
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for (SysRole role : sysUser.getRoleList()) {
//            for (SysPermission permission : role.getPermissionList()) {
//                authorities.add(new SimpleGrantedAuthority(permission.getCode()));
//            }
//        }
        //根据用户名查出用户后交给security，security再与form表单输入的内容校对，这一步只是交给security
//        users.get(0).setUserPassword(this.passwordEncoder.encode(users.get(0).getUserPassword()));
//        log.info("this.passwordEncoder.encode(users.get(0).getUserPassword())=="+this.passwordEncoder.encode(users.get(0).getUserPassword()));
//        log.info("用户名："+users.get(0).getUserName()+"=="+users.get(0).getUserPhone()+"==role=="+users.get(0).getUserRole().toString());
        //加授权
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new  SimpleGrantedAuthority("JIANG"));

//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("JIANG");
//        return new org.springframework.security.core.userdetails.User(
//                users.get(0).getUserName(),
//                users.get(0).getUserPassword(),true,true,true,true,
//                authorities);
//        return new org.springframework.security.core.userdetails.User(users.get(0).getUserName(), users.get(0).getUserPassword(), authorities);
    }
}