package com.jyr.iot.platform.pojogroup;

import com.jyr.iot.platform.pojo.Company;
import com.jyr.iot.platform.pojo.User;
import lombok.*;

import java.util.List;

/**
 * 集团组合类
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompanyGroup {
    //对应一个集团
    private Company company;
    // 对应一个集团经理
    private User user;
}
