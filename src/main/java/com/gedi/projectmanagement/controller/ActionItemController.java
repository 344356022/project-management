package com.gedi.projectmanagement.controller;

import com.gedi.projectmanagement.model.ActionItem;
import com.gedi.projectmanagement.service.ActionItemService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: ActionItemController
 * @Description:
 * @Author: zhangshuai
 * @Date 2019/6/5 18:06
 * @Version 1.0
 **/
@RestController
@RequestMapping("/actionItem")
public class ActionItemController {

    @Resource
    private ActionItemService actionItemService;

    // 项目总体计划清单的动态修改
    @PostMapping(value = "/updateActionItemList")
    public CodeAndMsg updateActionItemList(List<ActionItem> actionItems) {
        CodeAndMsg msg = new CodeAndMsg();
        if(actionItems.size() == 0 || actionItems == null){
            msg.setCode(400);
            msg.setMsg("参数为空");
            msg.setResult(false);
        }
        String flag = this.actionItemService.batchUpdateActionItems(actionItems);
        if("success".equals(flag)){
            msg.setCode(200);
            msg.setMsg("修改成功");
            msg.setResult(true);
        }else{
            msg.setCode(401);
            msg.setMsg("修改失败");
            msg.setResult(false);
        }
        return msg;
    }

}
