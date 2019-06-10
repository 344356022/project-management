package com.gedi.projectmanagement.service;

import com.gedi.projectmanagement.model.TaskSubclass;
import com.gedi.projectmanagement.vo.CodeAndMsg;

import java.util.List;

/**
 * @Author: renpu
 * @Date: 2019/6/5 15:25
 * @Description:
 */
public interface TaskSubClassService {

    //查询任务子类的id以及名称值
    CodeAndMsg queryTaskSubIdAndName();

}
