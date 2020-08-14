package com.jyr.iot.platform.mapper;

import com.jyr.iot.platform.pojo.Camera;
import com.jyr.iot.platform.pojo.CameraExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CameraMapper {
    int countByExample(CameraExample example);

    int deleteByExample(CameraExample example);

    int deleteByPrimaryKey(Integer cameraId);

    int insert(Camera record);

    int insertSelective(Camera record);

    List<Camera> selectByExample(CameraExample example);

    Camera selectByPrimaryKey(Integer cameraId);

    int updateByExampleSelective(@Param("record") Camera record, @Param("example") CameraExample example);

    int updateByExample(@Param("record") Camera record, @Param("example") CameraExample example);

    int updateByPrimaryKeySelective(Camera record);

    int updateByPrimaryKey(Camera record);
}