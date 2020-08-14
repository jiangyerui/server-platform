package com.jyr.iot.platform.pojogroup;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LcAcs implements Serializable {
    private String mac;
    private Integer status;
    private Integer l1Type;
    private Integer l1Status;
    private Integer l1Value;
    private Integer l2Type;
    private Integer l2Status;
    private Integer l2Value;
    private Integer l3Type;
    private Integer l3Status;
    private Integer l3Value;
    private Integer l4Type;
    private Integer l4Status;
    private Integer l4Value;
    private Integer l5Type;
    private Integer l5Status;
    private Integer l5Value;
    private Integer l6Type;
    private Integer l6Status;
    private Integer l6Value;
    private Integer l7Type;
    private Integer l7Status;
    private Integer l7Value;
    private Integer l8Type;
    private Integer l8Status;
    private Integer l8Value;
}
