package com.jyr.iot.platform.service;

import com.alibaba.fastjson.JSON;
import com.jyr.iot.platform.mqtt.MqttUtil;
import com.jyr.iot.platform.pojo.AlarmLog;
import com.jyr.iot.platform.pojo.Device;
import com.jyr.iot.platform.pojo.User;
import com.jyr.iot.platform.pojogroup.LcAcs;
import com.jyr.iot.platform.pojogroup.ZhydData;
import com.jyr.iot.platform.redis.RedisService;
import com.jyr.iot.platform.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class LcAcsService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private AlarmLogService alarmLogService;
    @Autowired
    private DeviceService deviceService;

    @RabbitListener(queues = "rabbitmq_queue_lcacs")
    public void rabbitListener(LcAcs lcAcs){
        try {
            MqttUtil.publish("currentdevdata/"+lcAcs.getMac(), JSON.toJSONString(lcAcs));
            analysisDataOnce(lcAcs);
            redisService.setLcAcs(lcAcs);
        }catch (Exception e){
            e.printStackTrace();
            log.error("LcAcsService/rabbitListener/向前台发送实时数据，解析存缓存/错误");
        }

    }

    //根据设备MAC查询设备实时数据
    public LcAcs selectDeviceDataByMac(String mac){
        try {
            User currentUser = UserUtils.getCurrentUser();
            redisService.setCurrentDeviceMac(currentUser.getUserPhone()+"/currentDevKey",mac);
            return redisService.getLcAcs(mac);
        }catch (Exception e){
            e.printStackTrace();
            log.error("LcAcsService/selectDeviceDataByMac/根据设备MAC查询设备实时数据/错误");
        }
        return null;
    }

    //处理一条报警，更新缓存（含智慧用电）
    public void sloveDevcieChannelAlarmlog(String mac,Integer channelId){
        try {
            if (mac.length()>12){
                LcAcs lcAcs = redisService.getLcAcs(mac);
                if (lcAcs==null)return;
                switch (channelId){
                    case 1:
                        lcAcs.setL1Status(1);
                        break;
                    case 2:
                        lcAcs.setL2Status(1);
                        break;
                    case 3:
                        lcAcs.setL3Status(1);
                        break;
                    case 4:
                        lcAcs.setL4Status(1);
                        break;
                    case 5:
                        lcAcs.setL5Status(1);
                        break;
                    case 6:
                        lcAcs.setL6Status(1);
                        break;
                    case 7:
                        lcAcs.setL7Status(1);
                        break;
                    case 8:
                        lcAcs.setL8Status(1);
                        break;
                }
                redisService.setLcAcs(lcAcs);
            }else {
                ZhydData zhydData = redisService.getZhyd(mac);
                if (zhydData==null)return;
                switch (channelId){
                    case 1:
                        zhydData.setL1Status(1);
                        break;
                    case 2:
                        zhydData.setL2Status(1);
                        break;
                    case 3:
                        zhydData.setL3Status(1);
                        break;
                    case 4:
                        zhydData.setL4Status(1);
                        break;
                    case 5:
                        zhydData.setL5Status(1);
                        break;
                    case 6:
                        zhydData.setL6Status(1);
                        break;
                    case 7:
                        zhydData.setL7Status(1);
                        break;
                    case 8:
                        zhydData.setL8Status(1);
                        break;
                    case 9:
                        zhydData.setArvStatus(1);
                        break;
                    case 10:
                        zhydData.setBrvStatus(1);
                        break;
                    case 11:
                        zhydData.setCrvStatus(1);
                        break;
                    case 12:
                        zhydData.setAnvStatus(1);
                        break;
                    case 13:
                        zhydData.setBnvStatus(1);
                        break;
                    case 14:
                        zhydData.setCnvValue(1);
                        break;
                    case 15:
                        zhydData.setDlStatus(1);
                        break;
                    case 16:
                        zhydData.setYgStatus(1);
                        break;
                    case 17:
                        zhydData.setJydzStatus(1);
                        break;
                }
                redisService.setZhyd(zhydData);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("LcAcsService/sloveDevcieChannelAlarmlog/处理redis中设备一通道报警/错误");
        }

    }

    //解析一个设备的一帧数据
    private void analysisDataOnce(LcAcs lcAcs){
//        log.info(lcAcs.getMac()+"***"+lcAcs.getL5Status()+"");
        LcAcs lcAcsFromRedis = redisService.getLcAcs(lcAcs.getMac());
        if (lcAcsFromRedis==null){  //如果是第一次接收到该设备数据
//            log.info("第一次，解析一个设备的一帧数据");
            if (lcAcs.getL1Status()==2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL1Type()){
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
            else if (lcAcs.getL2Status()==2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL2Type()){
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
            else if (lcAcs.getL3Status()==2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL3Type()){
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
            else if (lcAcs.getL4Status()==2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL4Type()){
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
            else if (lcAcs.getL5Status()==2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL5Type()){
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
            else if (lcAcs.getL6Status()==2){Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL6Type()){
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
            else if (lcAcs.getL7Status()==2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL7Type()){
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
            else if (lcAcs.getL8Status()==2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL8Type()){
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
            //        log.info(lcAcs.getMac()+"***"+lcAcs.getL5Status()+"");
//            log.info(lcAcs.getL5Status()+"==解析一个设备的一帧数据=="+lcAcsFromRedis.getL5Status());
            if (lcAcs.getL1Status()==2&&lcAcsFromRedis.getL1Status()!=2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL1Type()){
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
            else if (lcAcs.getL2Status()==2&&lcAcsFromRedis.getL2Status()!=2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL2Type()){
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
            else if (lcAcs.getL3Status()==2&&lcAcsFromRedis.getL3Status()!=2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL3Type()){
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
            else if (lcAcs.getL4Status()==2&&lcAcsFromRedis.getL4Status()!=2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL4Type()){
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
            else if (lcAcs.getL5Status()==2&&lcAcsFromRedis.getL5Status()!=2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL5Type()){
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
            else if (lcAcs.getL6Status()==2&&lcAcsFromRedis.getL6Status()!=2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL6Type()){
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
            else if (lcAcs.getL7Status()==2&&lcAcsFromRedis.getL7Status()!=2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL7Type()){
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
            else if (lcAcs.getL8Status()==2&&lcAcsFromRedis.getL8Status()!=2){
                Device device = deviceService.selectDeviceByMac(lcAcs.getMac());
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setAlarmTime(new Date());
                alarmLog.setAlarmCompanyId(device.getDeviceCompanyId());
                alarmLog.setAlarmProjectId(device.getDeviceProjectId());
                alarmLog.setAlarmDeviceId(device.getDeviceId());
                alarmLog.setAlarmExtend1(device.getDeviceNo());//报警设备MAC
                switch (lcAcs.getL8Type()){
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
    }



}
