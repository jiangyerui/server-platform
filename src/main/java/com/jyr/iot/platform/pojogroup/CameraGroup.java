package com.jyr.iot.platform.pojogroup;

import com.jyr.iot.platform.pojo.Camera;
import com.jyr.iot.platform.pojo.Project;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CameraGroup {
    private Camera camera;
    private Project project;
}
