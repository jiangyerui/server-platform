package com.jyr.iot.platform.pojogroup;

import com.jyr.iot.platform.pojo.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 设备组合类
 * 一个设备的详细信息
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeviceGroup implements Serializable {
    private Device device;
    private Company company;//所属集团
    private Project project;//所属项目
    private Camera camera;//关联相机
//    private List<AlarmLog> alarmLogs;//报警日志
//    private List<OperationLog> operationLogs;//操作日志
}
