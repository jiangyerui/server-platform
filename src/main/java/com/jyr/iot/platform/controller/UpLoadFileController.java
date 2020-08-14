package com.jyr.iot.platform.controller;

import com.jyr.iot.platform.entity.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import java.io.File;

@Slf4j
@Controller
@RequestMapping("/platform/upload/")
public class UpLoadFileController {


    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;// 文件服务器地址

    @Value("${FILE_LOCAL_CACHE_URL}")
    private String FILE_LOCAL_CACHE_URL;// 文件本地缓存地址

    @ApiOperation(value = "上传图片", notes = "upload")
//    @ApiImplicitParam(name="pathType",value="图片类型：1广告图片，2商品图片，3头像图片，4公司logo",required=true, dataType = "Integer", paramType = "Integer")
    @RequestMapping(value = "/uploadimg", method = RequestMethod.POST, headers = "content-type=multipart/form-data", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Result upload(
//            HttpServletRequest servletRequest,
//                         @ApiParam(value = "上传的文件", required = true)
            @RequestParam(value = "file", required = true) MultipartFile file
//                         @RequestParam(value = "pathType", required = true) Integer pathType
    ) throws Exception {
//    public Result upload(MultipartFile file) throws  Exception{
//        log.info("file.getOriginalFilename() = " + file.getOriginalFilename());
//        String localPath = FILE_LOCAL_CACHE_URL+file.getOriginalFilename();
        String localPath = "D:\\" + file.getOriginalFilename();
//        log.info("localPath = " + localPath);
        File localFile = new File(localPath);
        if (!localFile.getParentFile().exists()) {
            localFile.mkdir();
            localFile.delete();
        }
        file.transferTo(localFile);
        try {
            // 实例化一个Jersey
            Client client = new Client();
            // 保存图片服务器的请求路径
//            IdWorker iw = new IdWorker();
//            long nextId = iw.nextId();
            double random = Math.random();
            long nextId = (long) random * 1000000;
//            String remotePath = FILE_SERVER_URL + nextId;
            String remotePath = "http://localhost:8888/kkk" + file.getOriginalFilename();
            // 设置请求路径
            WebResource resource = client.resource(remotePath);
            // 读取图片到内存,将其变成二进制数组
            byte[] readFileToByteArray = FileUtils.readFileToByteArray(localFile);
            // 发送post get put
            resource.put(String.class, readFileToByteArray);
            localFile.delete();
            return new Result(true, remotePath);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }
    }
}
