package com.jyr.iot.platform.pojogroup;

import com.jyr.iot.platform.pojo.Device;
import com.jyr.iot.platform.pojo.Project;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProjectThing implements Serializable {
    private Project project;
    private List<Device> devices;
    private List<ZhydData> zhydData;
}
