package com.jyr.iot.platform.pojogroup;

import com.jyr.iot.platform.pojo.*;
import lombok.*;

import java.util.List;

/**
 * 项目组合类
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProjectGroup {
    //对应一个项目
    private Project project;
    //对应一个项目经理
    private User user;
    //对应一个所属集团
    private Company company;
}
