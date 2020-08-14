package com.jyr.iot.platform.controller;

import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.entity.Result;
import com.jyr.iot.platform.mapper.CompanyMapper;
import com.jyr.iot.platform.pojo.Company;

import com.jyr.iot.platform.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * paramType：参数放在哪个地方
 * header-->请求参数的获取：@RequestHeader
 * query-->请求参数的获取：@RequestParam
 * path（用于restful接口）-->请求参数的获取：@PathVariable
 * body（不常用）
 * form（不常用）
 */
@RestController
@Api(value = "CompanyController|集团管理控制器")
@RequestMapping("/platform/company/")
//@CrossOrigin(origins = "http://localhost:8082",maxAge = 3600)
@CrossOrigin
@Slf4j
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("addCompany")
    @ApiOperation(value = "增加集团",notes = "增加一个集团")
    @ApiImplicitParam(paramType = "body",name = "company",value = "集团信息",required = true,dataType = "Company")
    public Result addCompany(@RequestBody Company company){
        try {
            companyService.addCompany(company);
            return new Result(true,"增加集团成功了");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加集团失败");
        }
    }

    @DeleteMapping("deleteCompanyById/{id}")
    @ApiOperation(value = "删除集团",notes = "根据集团ID删除一个集团")
    @ApiImplicitParam(paramType = "path",name = "id",value = "集团ID",required = true,dataType = "Integer")
    public Result deleteCompanyById(@PathVariable("id") Integer id){
        try {
            companyService.deleteCompanyById(id);
            return new Result(true,"删除集团成功");
        }catch (Exception e){
            return new Result(false,"删除集团失败");
        }
    }

    @PutMapping("updateCompany")
    @ApiOperation(value = "更新集团",notes = "更新一个集团")
    @ApiImplicitParam(paramType = "body",name = "company",value = "集团信息",required = true,dataType = "Company")
    public Result updateCompany(@RequestBody Company company){
        try {
            companyService.updateCompany(company);
            return new Result(true,"更新集团成功");
        }catch (Exception e){
            return new Result(false,"更新集团失败");
        }
    }

    @GetMapping("selectCompanyById/{id}")
    @ApiOperation(value = "查询集团",notes = "根据集团ID查询集团")
    @ApiImplicitParam(paramType = "path",name = "id",value = "集团ID",required = true,dataType = "Integer")
    public Company selectCompanyById(@PathVariable("id") Integer id){
        return companyService.selectCompanyById(id);
    }

    @GetMapping("selectAllCompany")
    @ApiOperation(value = "查询集团",notes = "查询所有集团")
    public List<Company> selectAllCompany(){
        return companyService.selectAllCompany();
    }

    @GetMapping("selectCompanyByPage")
    @ApiOperation(value = "查询集团",notes = "分页查询集团")
    @ApiImplicitParams ({
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页码",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value = "每页记录数",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "companyName",value = "查询条件companyName",required = false,dataType = "String")
    })
    public PageResult selectCompanyByPage(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("companyName") String companyName){
        return companyService.selectCompanyByPage(pageNum,pageSize,companyName);
    }

}
