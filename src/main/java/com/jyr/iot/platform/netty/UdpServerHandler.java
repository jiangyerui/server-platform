package com.jyr.iot.platform.netty;

import com.jyr.iot.platform.service.LcAcsB128Service;
import com.jyr.iot.platform.service.ZhydService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * netty-upd服务器的handler
 * 注：可在handler中收、发数据
 */
@Slf4j
@Service
public class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    //    入口方法，重写channelRead0函数，编写主逻辑
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
        ByteBuf buf = datagramPacket.copy().content();
//        接收一帧监听到的数据
        List<String> list = receiveFromNetty(buf);

//    子方法，解析数据，主逻辑，封装-->存rabbitmq
        analysisToRabbitmq(list);

//        发送数据
//        String str = "jiang";
//        sendData(channelHandlerContext,datagramPacket,str);
    }

//    子方法，接收一帧netty发来的数据，并转为16进制字符串数组
    private List<String> receiveFromNetty(ByteBuf buf) {
        List<String> list = new ArrayList<String>();
        try {
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
//            将收到的数据转为16进制字符串数组
            for (int i = 0; i < req.length; i++) {
                String hex = Integer.toHexString(req[i] & 0xFF);
                if (hex.length() == 1) {// 如果是一位数，前面补0
                    hex = "0" + hex;
                }
                list.add(hex);
            }
        } catch (Exception e) {
            log.error("数据接收错误");
        }
//            打印收到的数据
        for (String str : list) {
            System.out.print(str + " ");
//            log.info(str+"");
        }
        System.out.println();
        return list;
    }

//    子方法，解析数据，主逻辑，封装-->存rabbitmq
    private void analysisToRabbitmq(List<String> list) {
        if (Integer.parseInt(list.get(0), 16) == 0xAA) {
//            模块类型，智慧用电模块
            if (Integer.parseInt(list.get(23), 16) == 0x01) {
                ZhydService zhydService = (ZhydService) StartupEvent.getBean(ZhydService.class);
                zhydService.analysisZhydToRabbitmq(list);
            }
//            模块类型，电气火灾主机
            else if (Integer.parseInt(list.get(23), 16) == 0x04) {
                LcAcsB128Service lcAcsB128Service = (LcAcsB128Service) StartupEvent.getBean(LcAcsB128Service.class);
                lcAcsB128Service.analysisLcAcsB128ToRabbitmq(list);
            }
            else {
                log.warn("未定义设备数据");
            }
        }else {
            log.warn("帧头错误");
        }
//        log.info(list.toString());
    }

//    子方法，发送数据
    private void sendToNetty(ChannelHandlerContext ctx, DatagramPacket packet, String str) throws UnsupportedEncodingException {
        // 由于数据报的数据是以字符数组传的形式存储的，所以传转数据
        byte[] bytes = str.getBytes("UTF-8");
        DatagramPacket data = new DatagramPacket(Unpooled.copiedBuffer(bytes), packet.sender());
        ctx.writeAndFlush(data);//向客户端发送消息
    }


}
