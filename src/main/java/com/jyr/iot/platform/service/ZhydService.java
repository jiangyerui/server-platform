package com.jyr.iot.platform.service;

import com.alibaba.fastjson.JSON;
import com.jyr.iot.platform.mapper.DeviceMapper;
import com.jyr.iot.platform.mqtt.MqttUtil;
import com.jyr.iot.platform.netty.StartupEvent;
import com.jyr.iot.platform.pojo.AlarmLog;
import com.jyr.iot.platform.pojo.Device;
import com.jyr.iot.platform.pojo.DeviceExample;
import com.jyr.iot.platform.pojo.User;
import com.jyr.iot.platform.pojogroup.LcAcs;
import com.jyr.iot.platform.pojogroup.ZhydData;
import com.jyr.iot.platform.rabbitmq.RabbitmqService;
import com.jyr.iot.platform.redis.RedisService;
import com.jyr.iot.platform.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class ZhydService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private AlarmLogService alarmLogService;
    @Autowired
    private DeviceMapper deviceMapper;

    public ZhydData selectDeviceDataByMac(String mac){
        User currentUser = UserUtils.getCurrentUser();
        redisService.setCurrentDeviceMac(currentUser.getUserPhone()+"/currentDevKey",mac);
        return redisService.getZhyd(mac);
    }

    //由rabbitmq中监听出一个LcAcs对象，存redis
    @RabbitListener(queues = "rabbitmq_queue_zhyd")
    public void rabbitListener(ZhydData zhydData){
        try {
            MqttUtil.publish("currentdevdata/"+zhydData.getMac(), JSON.toJSONString(zhydData));
            analysisDataOnce(zhydData);
        }catch (Exception e){
            e.printStackTrace();
            log.warn("ZhydService/rabbitListener/发送实时数据失败");
        }
    }

    public void analysisZhydToRabbitmq(List<String> list){
        try {
            ZhydData zhydData = new ZhydData();
            String mac = list.get(15)
                    +list.get(16)
                    +list.get(17)
                    +list.get(18)
                    +list.get(19)
                    +list.get(20);
//        private String mac;26
            zhydData.setMac(mac);
//        漏电或温度:
//        Type 1为漏电 2为温度
//        Status 1为正常，2为报警，3为故障
//        private Integer l1Type;28
            zhydData.setL1Type(Integer.parseInt(list.get(28),16)>>4);
//        private Integer l1Status;28
            zhydData.setL1Status(Integer.parseInt(list.get(28),16)&0x0F);
//        private Integer l1Value;2930
            zhydData.setL1Value(Integer.parseInt(list.get(29),16)+(Integer.parseInt(list.get(30),16)));

//        private Integer l2Type;31
            zhydData.setL2Type(Integer.parseInt(list.get(31),16)>>4);
//        private Integer l2Status;31
            zhydData.setL2Status(Integer.parseInt(list.get(31),16)&0x0F);
//        private Integer l2Value;3233
            zhydData.setL2Value(Integer.parseInt(list.get(32),16)+(Integer.parseInt(list.get(33),16)));

//        private Integer l3Type;34
            zhydData.setL3Type(Integer.parseInt(list.get(34),16)>>4);
//        private Integer l3Status;34
            zhydData.setL3Status(Integer.parseInt(list.get(34),16)&0x0F);
//        private Integer l3Value;3536
            zhydData.setL3Value(Integer.parseInt(list.get(35),16)+(Integer.parseInt(list.get(36),16)));

//        private Integer l4Type;37
            zhydData.setL4Type(Integer.parseInt(list.get(37),16)>>4);
//        private Integer l4Status;37
            zhydData.setL4Status(Integer.parseInt(list.get(37),16)&0x0F);
//        private Integer l4Value;3839
            zhydData.setL4Value(Integer.parseInt(list.get(38),16)+(Integer.parseInt(list.get(39),16)));

//        private Integer l5Type;40
            zhydData.setL5Type(Integer.parseInt(list.get(40),16)>>4);
//        private Integer l5Status;40
            zhydData.setL5Status(Integer.parseInt(list.get(40),16)&0x0F);
//        private Integer l5Value;4142
            zhydData.setL5Value(Integer.parseInt(list.get(41),16)+(Integer.parseInt(list.get(42),16)));

//        private Integer l6Type;43
            zhydData.setL6Type(Integer.parseInt(list.get(43),16)>>4);
//        private Integer l6Status;43
            zhydData.setL6Status(Integer.parseInt(list.get(43),16)&0x0F);
//        private Integer l6Value;4445
            zhydData.setL6Value(Integer.parseInt(list.get(44),16)+(Integer.parseInt(list.get(45),16)));

//        private Integer l7Type;46
            zhydData.setL7Type(Integer.parseInt(list.get(46),16)>>4);
//        private Integer l7Status;46
            zhydData.setL7Status(Integer.parseInt(list.get(46),16)&0x0F);
//        private Integer l7Value;4748
            zhydData.setL7Value(Integer.parseInt(list.get(47),16)+(Integer.parseInt(list.get(48),16)));

//        private Integer l8Type;49
            zhydData.setL8Type(Integer.parseInt(list.get(49),16)>>4);
//        private Integer l8Status;49
            zhydData.setL8Status(Integer.parseInt(list.get(49),16)&0x0F);
//        private Integer l8Value;5051
            zhydData.setL8Value(Integer.parseInt(list.get(50),16)+(Integer.parseInt(list.get(51),16)));

//        常用电压
//        private Integer arvStatus;55
            zhydData.setArvStatus(Integer.parseInt(list.get(55),16));
//        private Integer arvValue;5657
            zhydData.setArvValue(Integer.parseInt(list.get(56),16)+(Integer.parseInt(list.get(57),16)));
//        private Integer brvStatus;58
            zhydData.setBrvStatus(Integer.parseInt(list.get(58),16));
//        private Integer brvValue;5960
            zhydData.setBrvValue(Integer.parseInt(list.get(59),16)+(Integer.parseInt(list.get(60),16)));
//        private Integer crvStatus;61
            zhydData.setCrvStatus(Integer.parseInt(list.get(61),16));
//        private Integer crvValue;6263
            zhydData.setCrvValue(Integer.parseInt(list.get(62),16)+(Integer.parseInt(list.get(63),16)));

//        备用电压
//        private Integer anvStatus;64
            zhydData.setAnvStatus(Integer.parseInt(list.get(64),16));
//        private Integer anvValue;6566
            zhydData.setAnvValue(Integer.parseInt(list.get(65),16)+(Integer.parseInt(list.get(66),16)));
//        private Integer bnvStatus;67
            zhydData.setBnvStatus(Integer.parseInt(list.get(67),16));
//        private Integer bnvValue;6869
            zhydData.setBnvValue(Integer.parseInt(list.get(68),16)+(Integer.parseInt(list.get(69),16)));
//        private Integer cnvStatus;70
            zhydData.setCnvStatus(Integer.parseInt(list.get(70),16));
//        private Integer cnvValue;7172
            zhydData.setCnvValue(Integer.parseInt(list.get(71),16)+(Integer.parseInt(list.get(72),16)));

//        负载电流，电流状态 1为正常，2为过流，3为故障
//        private Integer aiStatus;73
            zhydData.setAiStatus(Integer.parseInt(list.get(73),16));
//        private Integer aiValue;7475
            zhydData.setAiValue(Integer.parseInt(list.get(74),16)+(Integer.parseInt(list.get(75),16)));
//        private Integer biStatus;76
            zhydData.setBiStatus(Integer.parseInt(list.get(76),16));
//        private Integer biValue;7778
            zhydData.setBiValue(Integer.parseInt(list.get(77),16)+(Integer.parseInt(list.get(78),16)));
//        private Integer ciStatus;79
            zhydData.setCiStatus(Integer.parseInt(list.get(79),16));
//        private Integer ciValue;8081
            zhydData.setCiValue(Integer.parseInt(list.get(80),16)+(Integer.parseInt(list.get(81),16)));


//        电量
//        private Integer dlStatus;84
            zhydData.setDlStatus(Integer.parseInt(list.get(84),16));
//        private Integer dlValue;8283
            zhydData.setDlValue(Integer.parseInt(list.get(82),16)+(Integer.parseInt(list.get(83),16)));


//        烟感 1为正常 2为报警
//        private Integer ygStatus;85
            zhydData.setYgStatus(Integer.parseInt(list.get(85),16));
//        绝缘电阻
//        private Integer jydzStatus;88
            zhydData.setJydzStatus(Integer.parseInt(list.get(88),16));
//        private Integer jydzValue;8687
            zhydData.setJydzValue(Integer.parseInt(list.get(86),16)+(Integer.parseInt(list.get(87),16)));

            RabbitmqService rabbitmqService = (RabbitmqService) StartupEvent.getBean(RabbitmqService.class);
            rabbitmqService.setZhyd(zhydData);
        }catch (Exception e){
            e.printStackTrace();
            log.warn("ZhydService/analysisZhydToRabbitmq/错误");
        }

    }

    //解析一个设备的一帧数据
    private void analysisDataOnce(ZhydData zhydData){
        ZhydData zhydDataFromRedis = redisService.getZhyd(zhydData.getMac());
        if (zhydDataFromRedis==null){  //如果是第一次接收到该设备数据
            if (zhydData.getL1Status()==2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL1Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(1);
                alarmLogService.addAlarmLog(alarmLog);
            }
            else if (zhydData.getL2Status()==2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL2Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(2);
                alarmLogService.addAlarmLog(alarmLog);
            }
            else if (zhydData.getL3Status()==2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL3Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(3);
                alarmLogService.addAlarmLog(alarmLog);
            }
            else if (zhydData.getL4Status()==2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL4Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(4);
                alarmLogService.addAlarmLog(alarmLog);
            }
            else if (zhydData.getL5Status()==2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL5Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(5);
                alarmLogService.addAlarmLog(alarmLog);
            }
            else if (zhydData.getL6Status()==2){Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL6Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(6);
                alarmLogService.addAlarmLog(alarmLog);}
            else if (zhydData.getL7Status()==2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL7Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(7);
                alarmLogService.addAlarmLog(alarmLog);
            }
            else if (zhydData.getL8Status()==2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL8Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(8);
                alarmLogService.addAlarmLog(alarmLog);
            }
        }
        else {  //如果不是第一次接收到该设备数据
            if (zhydData.getL1Status()==2&&zhydDataFromRedis.getL1Status()!=2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL1Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(1);
                alarmLogService.addAlarmLog(alarmLog);
            }
            else if (zhydData.getL2Status()==2&&zhydDataFromRedis.getL2Status()!=2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL2Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(2);
                alarmLogService.addAlarmLog(alarmLog);
            }
            else if (zhydData.getL3Status()==2&&zhydDataFromRedis.getL3Status()!=2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL3Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(3);
                alarmLogService.addAlarmLog(alarmLog);
            }
            else if (zhydData.getL4Status()==2&&zhydDataFromRedis.getL4Status()!=2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL4Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(4);
                alarmLogService.addAlarmLog(alarmLog);
            }
            else if (zhydData.getL5Status()==2&&zhydDataFromRedis.getL5Status()!=2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL5Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(5);
                alarmLogService.addAlarmLog(alarmLog);
            }
            else if (zhydData.getL6Status()==2&&zhydDataFromRedis.getL6Status()!=2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL6Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(6);
                alarmLogService.addAlarmLog(alarmLog);}
            else if (zhydData.getL7Status()==2&&zhydDataFromRedis.getL7Status()!=2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL7Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(7);
                alarmLogService.addAlarmLog(alarmLog);
            }
            else if (zhydData.getL8Status()==2&&zhydDataFromRedis.getL8Status()!=2){
                Device device = deviceService.selectDeviceByMac(zhydData.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (zhydData.getL8Type()){
                    case 1:
                        alarmLog.setAlarmName("回路1漏电报警");
                        alarmLog.setAlarmType(3);
                        break;
                    case 2:
                        alarmLog.setAlarmName("回路1温度报警");
                        alarmLog.setAlarmType(4);
                        break;
                    default:
                        alarmLog.setAlarmName("回路1报警");
                        break;
                }
                alarmLog.setAlarmL(8);
                alarmLogService.addAlarmLog(alarmLog);
            }
        }
        ZhydData zhydDataNow = resetCalculZhydStatus(zhydData);// 重新计算
        //如果存在之前
        if (zhydDataFromRedis!=null){
            //如果之前不报警，现在报警
            if (zhydDataFromRedis.getStatus()!=2&&zhydDataNow.getStatus()==2)
                setDeviceStatus(zhydDataNow);
            //如果之前报警，现在也报警，不必改变
            //如果之前不报警，现在也不报警，不必改变
            //如果之前报警，现在不报警
            if (zhydDataFromRedis.getStatus()!=2&&zhydDataNow.getStatus()==2)
                setDeviceStatus(zhydDataNow);
        }else {//如果不存在之前
            setDeviceStatus(zhydDataNow);
        }
        redisService.setZhyd(zhydDataNow);
    }

    //重新计算一个设备的状态
    private ZhydData resetCalculZhydStatus(ZhydData zhydData){
        ZhydData zhydDataTemp = zhydData;
        if (zhydDataTemp.getL1Status()==2){
            zhydDataTemp.setStatus(2);
            return zhydDataTemp;
        }else if (zhydDataTemp.getL2Status()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getL3Status()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getL4Status()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getL5Status()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getL6Status()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getL7Status()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getL8Status()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getArvStatus()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getBrvStatus()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getCrvStatus()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getAnvStatus()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getBnvStatus()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getCnvStatus()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getAiStatus()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getBiStatus()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getCiStatus()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getYgStatus()==2){
            zhydDataTemp.setStatus(2);
            return  zhydDataTemp;
        }else if (zhydDataTemp.getDlStatus()==2) {
            zhydDataTemp.setStatus(2);
            return zhydDataTemp;
        }else {
            zhydData.setStatus(1);
            return zhydDataTemp;
        }


    }

    //持久化device状态
    private void setDeviceStatus(ZhydData zhydData){
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria deviceExampleCriteria = deviceExample.createCriteria();
        deviceExampleCriteria.andDeviceNoEqualTo(zhydData.getMac());
        List<Device> devices = deviceMapper.selectByExample(deviceExample);
        if (devices.size()>0){
            Device device = devices.get(0);
            device.setDeviceUseStatus(zhydData.getStatus());
            deviceMapper.updateByPrimaryKey(device);
        }
    }
}
