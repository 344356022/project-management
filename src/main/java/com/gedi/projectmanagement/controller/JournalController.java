package com.gedi.projectmanagement.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gedi.projectmanagement.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.gedi.projectmanagement.model.Journal;
import com.gedi.projectmanagement.service.IJournalService;

import javax.servlet.http.HttpServletRequest;

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
	@Autowired
	private IJournalService journalService;

	/**
	 * 查询日志列表
	 * 不需要传入用户id的参数 userId会在用户进入钉钉时获取信息放在session里
	 */
	@PostMapping("/journal/list")
	@ResponseBody
	public HashMap list()
	{
		String userId = "userId";//暂时写死后续会从session获取用户信息
		System.err.println("-------------");
		HashMap resultMap = new HashMap();
		resultMap.put("code",400);
		resultMap.put("msg","未传入用户信息，请重新登录！");
		HashMap map = new HashMap();
		List<HashMap<String,Object>> list = null;
		if(userId != null && !"".equals(userId)){//判断是否传入用户id 有的话把userId放到map中
			map.put("userId",userId);
			 list = journalService.selectJournalResultList(map);//返回日报列表数据
			System.err.println("----list----"+list.size());
			 if(list.size() > 0){
				 resultMap.put("code",200);
				 resultMap.put("msg","成功");
			 }else{
				 resultMap.put("code",300);
				 resultMap.put("msg","无数据");
			 }
			 map.clear();
			 map.put("result",list);
			 //抄送人列表
			List<HashMap<String,Object>> userList = journalService.selectUserList();
			map.put("userList",userList);

		}
		resultMap.put("data",map);
		return resultMap;
	}

	/**
	 * 新增保存日志
	 */
	@ResponseBody
	@RequestMapping(value = "/journal/save",method = RequestMethod.POST,  produces = "application/json;charset=UTF-8")
	public HashMap addRb(HttpServletRequest request)
	{	HashMap resultMap = new HashMap();
		JSONObject jsonParam = this.getJSONParam(request);
      Map<String, Object>  map = ( Map<String, Object>)jsonParam;
      List<Map<String,Object>> ll = (List<Map<String, Object>>) map.get("para");
        System.err.println("--------:"+map);
        System.err.println("--------:"+ll);

        System.err.println("-----ll---:"+ll);
		/*String result = jsonParam.getString("para");
        result=result.substring(1,result.length()-1);
        String [] stringArr= result.split(",");
        List list = Arrays.asList(stringArr);*/
      /*  for(int i=0;i<list.size();i++){
            HashMap<String,Object> map = (HashMap) list.get(i);
            map.put("rbId", UUIDUtil.getUUID2());
            map.put("userId","userId");
            System.err.println("--------:"+list.get(i));
        }*/

        int resultNum = journalService.insertJournalList(ll);
		return resultMap;

	}

	public JSONObject getJSONParam(HttpServletRequest request){
		JSONObject jsonParam = null;
		try {
			// 获取输入流
			BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			// 写入数据到Stringbuilder
			 StringBuilder sb = new StringBuilder(); String line = null;
			 while ((line = streamReader.readLine()) != null){
			 	sb.append(line);
	 			}
	 		jsonParam = JSONObject.parseObject(sb.toString()); // 直接将json信息打印出来
			System.out.println(jsonParam.toJSONString());
		}catch (Exception e){
			e.printStackTrace();
		   }
		return jsonParam;
	}

	@ResponseBody
	@RequestMapping(value = "/journal/add",method = RequestMethod.POST,  produces = "application/json;charset=UTF-8")
	public HashMap add(HttpServletRequest request)
	{
		HashMap resultMap = new HashMap();
        JSONObject jsonParam = this.getJSONParam(request);
        Map<String, Object> map = (Map<String, Object>)jsonParam;
        String result = jsonParam.getString("para");
        System.err.println("-------:"+map);
       // HashMap<String,Object> mmp = result;


		return resultMap;

	}
}
