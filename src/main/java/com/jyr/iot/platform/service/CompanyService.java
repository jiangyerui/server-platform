package com.jyr.iot.platform.service;

import com.github.pagehelper.PageHelper;
import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.mapper.CompanyMapper;
import com.jyr.iot.platform.mapper.UserMapper;
import com.jyr.iot.platform.pojo.Company;
import com.jyr.iot.platform.pojo.CompanyExample;
import com.jyr.iot.platform.pojo.User;
import com.jyr.iot.platform.pojogroup.CompanyGroup;
import com.jyr.iot.platform.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 增
     */
    public void addCompany(Company company){
        try {
            companyMapper.insert(company);
        }catch (Exception e){
            e.printStackTrace();
            log.error("CompanyService/addCompany/增加集团/错误");
        }
    }

    /**
     * 删
     */
    public void deleteCompanyById(Integer id){
        try {
            companyMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            log.error("CompanyService/deleteCompanyById/删除集团/错误");
        }
    }

    /**
     * 改
     */
    public void updateCompany(Company company){
        try {
            companyMapper.updateByPrimaryKey(company);
        }catch (Exception e){
            e.printStackTrace();
            log.error("CompanyService/updateCompany/更新集团/错误");
        }
    }

    /**
     * 查
     */
    public Company selectCompanyById(Integer id){
        try {
            return companyMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            log.error("CompanyService/selectCompanyById/查询集团/错误");
        }
        return null;
    }

    public List<Company> selectAllCompany(){
        try {
            return companyMapper.selectByExample(null);
        }catch (Exception e){
            e.printStackTrace();
            log.error("CompanyService/selectAllCompany/查询所有集团/错误");
        }
        return null;
    }

    //按页查询，按当前登陆用户查询集团
    public PageResult selectCompanyByPage(int pageNum, int pageSize, String companyName) {
        try {
            User currentUser = UserUtils.getCurrentUser();
            switch (currentUser.getUserRole()){
                case 1:// 如果是超级用户，查所有
                    List<Company> companies = selectAllCompany();
                    PageHelper.startPage(pageNum, pageSize);
                    List<CompanyGroup> superCompanyGroups = selectCompanyGroupByRole(1, companyName);
                    return new PageResult(companies.size(), superCompanyGroups);
                case 2://如果是集团用户，查所管辖的集团
                    Integer size = selectSizeByCurrentCompanyUser();
                    PageHelper.startPage(pageNum, pageSize);
                    List<CompanyGroup> companyCompanyGroups = selectCompanyGroupByRole(2, companyName);
                    return new PageResult(size, companyCompanyGroups);
                case 3:
                case 4://如果是项目用户或普通用户，暂无可查
                    return new PageResult(0, null);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("CompanyService/selectCompanyByPage/按页查询，按当前登陆用户查询集团/错误");
        }
        return null;
    }

    //子方法，根据角色查集团
    private List<CompanyGroup> selectCompanyGroupByRole(Integer role,String companyName){
        List<Company> superCompanies = new ArrayList<Company>();
        CompanyExample superExample = new CompanyExample();
        CompanyExample.Criteria companyCriteria = superExample.createCriteria();
        //如果是超级用户，查所有
        if (role==1){
            if(companyName!=null&&companyName!=""){
                companyCriteria.andCompanyNameLike("%"+companyName+"%");
                superCompanies = companyMapper.selectByExample(superExample);
            }else {
                superCompanies = companyMapper.selectByExample(null);
            }
        }
        //如果是集团用户，查管辖内的集团
        if (role==2){
            companyCriteria.andCompanyUserIdEqualTo(UserUtils.getCurrentUser().getUserId());
            if(companyName!=null&&companyName!=""){
                companyCriteria.andCompanyNameLike("%"+companyName+"%");
            }
            superCompanies = companyMapper.selectByExample(superExample);
        }

        //封装组合实体类CompanyGroup
        List<CompanyGroup> superCompanyGroups = new ArrayList<CompanyGroup>();
        for (Company company: superCompanies){
            User superUser = userMapper.selectByPrimaryKey(company.getCompanyUserId());
            superCompanyGroups.add(new CompanyGroup(company,superUser));
        }
        return superCompanyGroups;
    }

    //子方法，查询当前登陆集团用户下所有集团数
    private Integer selectSizeByCurrentCompanyUser(){
        CompanyExample example = new CompanyExample();
        CompanyExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyUserIdEqualTo(UserUtils.getCurrentUser().getUserId());
        List<Company> companies = companyMapper.selectByExample(example);
        return companies.size();
    }

}
