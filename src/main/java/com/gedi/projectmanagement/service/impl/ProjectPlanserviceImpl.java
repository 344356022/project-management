package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.ProjectPlanMapper;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.CodeAndMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangyanbin
 * @D
 */
@Service
public class ProjectPlanserviceImpl implements ProjectPlanService {

    @Resource
    private ProjectPlanMapper projectPlanMapper;

    //查询所有用于列表展示
    @Override
    public CodeAndMsg selectById() {
        System.out.println(projectPlanMapper.selectById() + "查询成功");
        if (projectPlanMapper.selectById()!=null){
            return CodeAndMsgUtil.setOK("查询成功",projectPlanMapper.selectById());
        }else {
            return CodeAndMsgUtil.setERROR("查询失败", null);
        }
    }

}
