package com.jyr.iot.platform.pojogroup;

import com.jyr.iot.platform.pojo.Company;
import com.jyr.iot.platform.pojo.User;
import lombok.*;

import java.util.List;

/**
 * 集团经理树
 */
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCompany {
    //对应一个集团经理
    private User UserCompany;
    //对应一个集团
    private Company company;
    //对应一组项目经理树
    private List<UserProject> userProjects;
}
