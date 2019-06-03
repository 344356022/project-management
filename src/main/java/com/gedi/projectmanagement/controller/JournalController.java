package com.gedi.projectmanagement.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gedi.projectmanagement.model.Journal;
import com.gedi.projectmanagement.service.IJournalService;

/**
 * 日志 信息操作处理
 * 
 * @author zpl
 * @date 2019-06-03
 */
@Controller
//@RequestMapping("/journal")
public class JournalController
{
    private String prefix = "system/journal";
	
	@Autowired
	private IJournalService journalService;

	/**
	 * 查询日志列表
	 * 需要传入用户id的参数 userId
	 */
	@GetMapping("/journal/list")
	@ResponseBody
	public HashMap list(String userId)
	{
		HashMap resultMap = new HashMap();
		resultMap.put("code",400);
		resultMap.put("msg","未传入用户信息，请重新登录！");
		HashMap map = new HashMap();
		List<HashMap<String,Object>> list = null;
		if(userId != null && !"".equals(userId)){//判断是否传入用户id 有的话把userId放到map中
			 list = journalService.selectJournalResultList(map);//返回日报列表数据
			 if(list.size() > 0){
				 resultMap.put("code",200);
				 resultMap.put("msg","成功");
			 }else{
				 resultMap.put("code",300);
				 resultMap.put("msg","无数据");
			 }
		}
		resultMap.put("data",list);
		return resultMap;
	}

	/**
	 * 新增保存日志
	 */
	/*@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	@RequiresPermissions("system:journal:add")
	@Log(title = "日志", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Journal journal)
	{
		return toAjax(journalService.insertJournal(journal));
	}*/



	/**
	 * 修改日志
	 */
	@GetMapping("/edit/{rbId}")
	public String edit(@PathVariable("rbId") String rbId, ModelMap mmap)
	{
		Journal journal = journalService.selectJournalById(rbId);
		mmap.put("journal", journal);
	    return prefix + "/edit";
	}
	

}
