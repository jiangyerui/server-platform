package com.jyr.iot.platform.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.mapper.OperationLogMapper;
import com.jyr.iot.platform.pojo.OperationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OperationLogService {

    @Autowired
    private OperationLogMapper operationlogMapper;

    /**
     * 增
     */
    public void addOperationLog(OperationLog operationlog){
        operationlogMapper.insert(operationlog);
    }


    /**
     * 删
     */
    public void deleteOperationLogById(Integer id){
        operationlogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 改
     */
    public void updateOperationLog(OperationLog operationlog){
        operationlogMapper.updateByPrimaryKey(operationlog);
    }

    /**
     * 查
     */
    public OperationLog selectOperationLogById(Integer id){
        return operationlogMapper.selectByPrimaryKey(id);
    }
    public List<OperationLog> selectAllOperationLog(){
        return operationlogMapper.selectByExample(null);
    }
    public PageResult selectOperationLogByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<OperationLog> page = (Page<OperationLog>) operationlogMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
