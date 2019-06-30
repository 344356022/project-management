package com.gedi.projectmanagement.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gedi.projectmanagement.model.ActionItem;
import com.gedi.projectmanagement.service.ActionItemService;
import com.gedi.projectmanagement.service.system.SysUserService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: ActionItemController
 * @Description: 用于对项目管理总计划清单的修改
 * @Author: zhangshuai
 * @Date 2019/6/5 18:06
 * @Version 1.0
 **/
@RestController
@RequestMapping("/actionItem")
public class ActionItemController {

    @Resource
    private ActionItemService actionItemService;

    @Resource
    private SysUserService sysUserService;

    /**
     * 项目总体计划清单的动态修改
     *
     * @param items
     * @return
     */
    @PostMapping(value = "/updateActionItemList")
    public CodeAndMsg updateActionItemList(@RequestBody String items) {
        CodeAndMsg msg = new CodeAndMsg();
        if (StringUtils.isEmpty(items)) {
            msg.setCode(400);
            msg.setMsg("参数为空");
            msg.setResult(false);
        } else {
            JSONObject jsonObject = JSON.parseObject(items);
            items = jsonObject.getString("items");
            List<ActionItem> actionItems = JSONArray.parseArray(items, ActionItem.class);
            String flag = this.actionItemService.batchUpdateActionItems(actionItems);
            if ("success".equals(flag)) {
                msg.setCode(200);
                msg.setMsg("修改成功");
                msg.setResult(true);
            } else {
                msg.setCode(401);
                msg.setMsg("修改失败");
                msg.setResult(false);
            }
        }
        return msg;
    }

    @PostMapping(value = "/getNameByUserId")
    public CodeAndMsg getNameByUserId(String userId) {
        CodeAndMsg msg = new CodeAndMsg();
        String userName = this.sysUserService.selectNameByUserId(userId);
        if (userName != null) {
            msg.setCode(200);
            msg.setMsg("查询成功");
            msg.setResult(true);
            msg.setData(userName);
        } else {
            msg.setCode(401);
            msg.setMsg("查询失败");
            msg.setResult(false);
        }
        return msg;
    }

}
