package com.jyr.iot.platform.pojogroup;

import com.jyr.iot.platform.pojo.Device;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ZhydData implements Serializable {
//    private Device device;
    private String mac;
    //设备状态，1为正常，2为报警，3为故障
    private Integer status;
    //常用电压
    private Integer arvStatus;
    private Integer arvValue;
    private Integer brvStatus;
    private Integer brvValue;
    private Integer crvStatus;
    private Integer crvValue;
    //备用电压
    private Integer anvStatus;
    private Integer anvValue;
    private Integer bnvStatus;
    private Integer bnvValue;
    private Integer cnvStatus;
    private Integer cnvValue;
    //负载电流，电流状态 1为正常，2为过流，3为故障
    private Integer aiStatus;
    private Integer aiValue;
    private Integer biStatus;
    private Integer biValue;
    private Integer ciStatus;
    private Integer ciValue;

    //漏电或温度:
    // Type 1为漏电 2为温度
    // Status 1为正常，2为报警，3为故障
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
    //电量
    private Integer dlStatus;
    private Integer dlValue;
    //烟感 1为正常 2为报警
    private Integer ygStatus;
    //绝缘电阻
    private Integer jydzStatus;
    private Integer jydzValue;
}
