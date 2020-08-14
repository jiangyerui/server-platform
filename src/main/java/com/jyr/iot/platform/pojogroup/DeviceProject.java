package com.jyr.iot.platform.pojogroup;

import com.jyr.iot.platform.pojo.Camera;
import com.jyr.iot.platform.pojo.Device;
import com.jyr.iot.platform.pojo.Project;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 一个项目下的设备
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeviceProject implements Serializable {
    private Project project;
    private List<DeviceGroup> deviceGroups;
    private List<Camera> cameras;
}
