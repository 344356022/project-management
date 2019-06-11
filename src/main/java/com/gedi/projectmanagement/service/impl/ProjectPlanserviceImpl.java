package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.ProjectPlanMapper;
import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.ProjectPlanList;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.CodeAndMsgUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangyanbin
 * @Description :
 */
@Service
@Transactional
public class ProjectPlanserviceImpl implements ProjectPlanService {

    @Resource
    private ProjectPlanMapper projectPlanMapper;

    //查询所有用于列表展示
    @Override
    public CodeAndMsg selectById() {
       // System.out.println(projectPlanMapper.selectById() + "查询成功");
        List<ProjectPlan> projectPlans = projectPlanMapper.selectById();
        if (projectPlans != null) {
            return CodeAndMsgUtil.setOK("查询成功", projectPlans);
        } else {
            return CodeAndMsgUtil.setERROR("查询失败", null);
        }
    }


    //新增项目总计划
    /*@Override
    public boolean addProject(ProjectPlan projectPlan) {
        //return (projectPlanMapper.addProject(projectPlan) == 0 ? false : true);
        return projectPlanMapper.addProject(projectPlan) == 0 ? false : true;
    }*/
    /*public void addProject(ProjectPlan projectPlan) {
            try {
                projectPlanMapper.addProject(projectPlan);
            } catch (Exception e) {
                throw e;
            }
        }*/
   @Override
    public String addProject(List<ProjectPlan> projectPlans) {
         projectPlanMapper.addProject(projectPlans);
         return "success";
    }

    /**
     * 查询所有用于项目总计划清单的展示
     *
     * @param pId
     * @param pProjectPhaseId
     * @return
     */
    @Override
    public List<ProjectPlanList> selectProjectPlanListByPidAndpProjectPhaseId(String pId, Integer pProjectPhaseId) {
        return projectPlanMapper.selectProjectPlanListByPidAndpProjectPhaseId(pId, pProjectPhaseId);
    }

    /**
     * 根据pName模糊查询项目总体计划列表展示
     *
     * @param pName
     * @return
     */
    @Override
    public List<ProjectPlan> selectBypName(String pName) {
        return projectPlanMapper.selectBypName(pName);
    }

    @Override
    public CodeAndMsg selectAllProject() {

        if(projectPlanMapper.selectAllProject().size()!=0){

            return CodeAndMsgUtil.setOK("msg",projectPlanMapper.selectAllProject());

        }else{
            return CodeAndMsgUtil.setERROR("msg",null);
        }

    }

}
