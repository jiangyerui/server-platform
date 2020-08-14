package com.jyr.iot.platform.mapper;

import com.jyr.iot.platform.pojo.AlarmLog;
import com.jyr.iot.platform.pojo.AlarmLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmLogMapper {
    int countByExample(AlarmLogExample example);

    int deleteByExample(AlarmLogExample example);

    int deleteByPrimaryKey(Integer alarmId);

    int insert(AlarmLog record);

    int insertSelective(AlarmLog record);

    List<AlarmLog> selectByExample(AlarmLogExample example);

    AlarmLog selectByPrimaryKey(Integer alarmId);

    int updateByExampleSelective(@Param("record") AlarmLog record, @Param("example") AlarmLogExample example);

    int updateByExample(@Param("record") AlarmLog record, @Param("example") AlarmLogExample example);

    int updateByPrimaryKeySelective(AlarmLog record);

    int updateByPrimaryKey(AlarmLog record);
}