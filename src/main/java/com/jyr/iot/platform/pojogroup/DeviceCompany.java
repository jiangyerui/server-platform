package com.jyr.iot.platform.pojogroup;

import com.jyr.iot.platform.pojo.Company;
import lombok.*;

import java.util.List;

/**
 * 一个集团下的项目，每个项目下的设备
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeviceCompany {
    private Company company;
    private List<DeviceProject> deviceProjects;
}
