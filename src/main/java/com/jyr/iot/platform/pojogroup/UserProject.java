package com.jyr.iot.platform.pojogroup;

import com.jyr.iot.platform.pojo.Project;
import com.jyr.iot.platform.pojo.User;
import lombok.*;

import java.util.List;

/**
 * 项目经理树，
 *
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserProject {
    //对应一个项目经理
    private User userProject;
    //对应一个项目
    private Project project;
    //对应一组普通用户树
    private List<UserGroup> userCommons;
}
