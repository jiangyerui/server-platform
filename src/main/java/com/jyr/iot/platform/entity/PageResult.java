package com.jyr.iot.platform.entity;


import com.jyr.iot.platform.pojo.User;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageResult implements Serializable {
    private long total;//总记录数
    private List rows;//当前页结果
}

