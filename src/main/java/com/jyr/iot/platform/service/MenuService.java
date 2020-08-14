package com.jyr.iot.platform.service;

import com.jyr.iot.platform.mapper.MenuMapper;
import com.jyr.iot.platform.mapper.RoleMapper;
import com.jyr.iot.platform.mapper.RoleMenuMapper;
import com.jyr.iot.platform.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;


    public List<Menu> getAllMenu() {
        return menuMapper.selectByExample(null);
    }

    public List<Role> getRolesByMenu(Menu menu) {
        RoleMenuExample example = new RoleMenuExample();
        RoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andMenuEqualTo(menu.getMenuId());
        List<RoleMenu> roleMenus = roleMenuMapper.selectByExample(example);

        List<Role> roles = new ArrayList<Role>();
        for (RoleMenu roleMenu: roleMenus){
            List<Role> rolesTemp = new ArrayList<Role>();
            RoleExample example1 = new RoleExample();
            RoleExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andRoleIdEqualTo(roleMenu.getRole());
            rolesTemp = roleMapper.selectByExample(example1);
            roles.addAll(rolesTemp);
        }
        return roles;
    }

}
