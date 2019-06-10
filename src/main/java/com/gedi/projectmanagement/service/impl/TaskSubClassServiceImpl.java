package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.TaskSubclassMapper;
import com.gedi.projectmanagement.model.TaskSubclass;
import com.gedi.projectmanagement.service.TaskSubClassService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.CodeAndMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: renpu
 * @Date: 2019/6/5 15:26
 * @Description:
 */

@Service
@Transactional
public class TaskSubClassServiceImpl implements TaskSubClassService {

    @Autowired
    private TaskSubclassMapper taskSubclassMapper;


    @Override
    public CodeAndMsg queryTaskSubIdAndName() {

        if(taskSubclassMapper.queryTaskSubIdAndName().size()!=0&&taskSubclassMapper.queryTaskSubIdAndName()!=null){

               return CodeAndMsgUtil.setOK("msg",taskSubclassMapper.queryTaskSubIdAndName());

        }else {

            return CodeAndMsgUtil.setERROR("msg",null);

        }
    }
}
