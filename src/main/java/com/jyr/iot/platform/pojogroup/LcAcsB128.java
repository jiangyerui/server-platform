package com.jyr.iot.platform.pojogroup;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LcAcsB128 implements Serializable {
    private String mac;
    private Integer dataLength;
    private Integer lcAcsNum;
    private List<LcAcs> lcAcsList;
}
