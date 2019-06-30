package com.gedi.projectmanagement.dao.system;


import com.gedi.projectmanagement.base.GeneralMapper;
import com.gedi.projectmanagement.model.system.SysDepartment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysDepartmentMapper extends GeneralMapper<SysDepartment> {

    /**
     * 根据部门的唯一标识查询部门信息
     * @param departmentId 唯一标识，系统生成
     * @return 部门详情
     */
    SysDepartment queryBySource(String departmentId);

}