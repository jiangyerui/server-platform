package com.jyr.iot.platform.pojogroup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jyr.iot.platform.pojo.Company;
import com.jyr.iot.platform.pojo.Permission;
import com.jyr.iot.platform.pojo.Project;
import com.jyr.iot.platform.pojo.User;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户组合类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserGroup implements UserDetails {
    //对应一个用户
    private User user;
    //对应一个权限
    private Permission permission;
    //对应集团，如果是超级用户，无此属性
    private Company company;
    //如果是超级用户、集团用户，无此属性；如果是项目经理、安全经理，对应一个项目
    private Project prooject;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        switch (user.getUserRole()){
            case 1:
                authorities.add(new SimpleGrantedAuthority("SUPER"));
                authorities.add(new SimpleGrantedAuthority("COMPANY"));
                authorities.add(new SimpleGrantedAuthority("PROJECT"));
                authorities.add(new SimpleGrantedAuthority("COMMON"));
//                authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("SUPER,COMPANY,PROJECT,COMMON");
                break;
            case 2:
                authorities.add(new SimpleGrantedAuthority("COMPANY"));
                authorities.add(new SimpleGrantedAuthority("PROJECT"));
                authorities.add(new SimpleGrantedAuthority("COMMON"));
//                authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("COMPANY,PROJECT,COMMON");
                break;
            case 3:
                authorities.add(new SimpleGrantedAuthority("PROJECT"));
                authorities.add(new SimpleGrantedAuthority("COMMON"));
//                authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("PROJECT,COMMON");
                break;
            case 4:
                authorities.add(new SimpleGrantedAuthority("COMMON"));
//                authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("COMMON");
                break;
            default:
                authorities.add(new SimpleGrantedAuthority("COMMON"));
//                authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("COMMON");
                break;
        }
        return authorities;
    }
    @JsonIgnore
    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
