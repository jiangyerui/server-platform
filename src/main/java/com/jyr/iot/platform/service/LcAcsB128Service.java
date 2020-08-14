package com.jyr.iot.platform.service;

import com.jyr.iot.platform.netty.StartupEvent;
import com.jyr.iot.platform.pojogroup.LcAcs;
import com.jyr.iot.platform.rabbitmq.RabbitmqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class LcAcsB128Service {

    //    处理一帧LcAcsB128的Netty数据，封装多个LcAcs对象，并存到rabbitmq
    public void analysisLcAcsB128ToRabbitmq(List<String> list){
        try {
            if (list.size()<0)
                return;

            if (Integer.parseInt(list.get(8),16)!=0x00)
                return;

            String mac = list.get(15)
                    +list.get(16)
                    +list.get(17)
                    +list.get(18)
                    +list.get(19)
                    +list.get(20);
//        解析探测器
            for (int i = 0 ; i<2; i++){
                LcAcs lcAcs = new LcAcs();
                int no = Integer.parseInt(list.get(26 + 26 * i),16)+1;
                String strNo;
                if (no<10){
                    strNo = "00"+no;
                }else if (no>9&&no<100){
                    strNo = "0"+no;
                }else if (no>99&&no<257){
                    strNo = "" + no;
                }else {
                    strNo = "000";
                }
                lcAcs.setMac(mac+strNo);
                lcAcs.setStatus(Integer.parseInt(list.get(27+26*i),16));
                lcAcs.setL1Type(Integer.parseInt(list.get(28+26*i),16)>>4);
                lcAcs.setL1Status(Integer.parseInt(list.get(28+26*i),16)&0x0F);
                lcAcs.setL1Value(Integer.parseInt(list.get(29+26*i),16)+(Integer.parseInt(list.get(30+26*i),16)<<8));
                lcAcs.setL2Type(Integer.parseInt(list.get(31+26*i),16)>>4);
                lcAcs.setL2Status(Integer.parseInt(list.get(31+26*i),16)&0x0F);
                lcAcs.setL2Value(Integer.parseInt(list.get(32+26*i),16)+(Integer.parseInt(list.get(33+26*i),16)<<8));
                lcAcs.setL3Type(Integer.parseInt(list.get(34+26*i),16)>>4);
                lcAcs.setL3Status(Integer.parseInt(list.get(34+26*i),16)&0x0F);
                lcAcs.setL3Value(Integer.parseInt(list.get(35+26*i),16)+(Integer.parseInt(list.get(36+26*i),16)<<8));
                lcAcs.setL4Type(Integer.parseInt(list.get(37+26*i),16)>>4);
                lcAcs.setL4Status(Integer.parseInt(list.get(37+26*i),16)&0x0F);
                lcAcs.setL4Value(Integer.parseInt(list.get(38+26*i),16)+(Integer.parseInt(list.get(39+26*i),16)<<8));
                lcAcs.setL5Type(Integer.parseInt(list.get(40+26*i),16)>>4);
                lcAcs.setL5Status(Integer.parseInt(list.get(40+26*i),16)&0x0F);
                lcAcs.setL5Value(Integer.parseInt(list.get(41+26*i),16)+(Integer.parseInt(list.get(42+26*i),16)<<8));
                lcAcs.setL6Type(Integer.parseInt(list.get(43+26*i),16)>>4);
                lcAcs.setL6Status(Integer.parseInt(list.get(43+26*i),16)&0x0F);
                lcAcs.setL6Value(Integer.parseInt(list.get(44+26*i),16)+(Integer.parseInt(list.get(45+26*i),16)<<8));
                lcAcs.setL7Type(Integer.parseInt(list.get(46+26*i),16)>>4);
                lcAcs.setL7Status(Integer.parseInt(list.get(46+26*i),16)&0x0F);
                lcAcs.setL7Value(Integer.parseInt(list.get(47+26*i),16)+(Integer.parseInt(list.get(48+26*i),16)<<8));
                lcAcs.setL8Type(Integer.parseInt(list.get(49+26*i),16)>>4);
                lcAcs.setL8Status(Integer.parseInt(list.get(49+26*i),16)&0x0F);
                lcAcs.setL8Value(Integer.parseInt(list.get(50+26*i),16)+(Integer.parseInt(list.get(51+26*i),16)<<8));
                //存
                RabbitmqService rabbitmqService = (RabbitmqService) StartupEvent.getBean(RabbitmqService.class);
                rabbitmqService.setLcAcs(lcAcs);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("LcAcsB128Service/analysisLcAcsB128ToRabbitmq/错误");
        }
    }


}
