package com.jyr.iot.platform.util;

import com.jyr.iot.platform.pojo.User;
import com.jyr.iot.platform.pojogroup.UserGroup;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by sang on 2017/12/30.
 */
public class UserUtils {
    public static User getCurrentUser() {
        UserGroup userGroup = (UserGroup) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userGroup.getUser();
    }
}
