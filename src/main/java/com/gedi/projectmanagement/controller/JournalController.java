package com.gedi.projectmanagement.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gedi.projectmanagement.config.AuthHelperDaily;
import com.gedi.projectmanagement.config.AuthHelperProjectTotle;
import com.gedi.projectmanagement.model.User;
import com.gedi.projectmanagement.service.UserService;
import com.gedi.projectmanagement.service.WeekReportService;
import com.gedi.projectmanagement.util.DetialDayDate;
import com.gedi.projectmanagement.util.LoginUtil;
import com.gedi.projectmanagement.util.UUIDUtil;
import com.gedi.projectmanagement.vo.CodeAndMsg;
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

	@Autowired
	private WeekReportService weekReportService;

	@Autowired
	private UserService userService;

	/**
	 * zpl
	 * 查询日志列表
	 * 不需要传入用户id的参数 userId会在用户进入钉钉时获取信息放在session里
	 * @return HashMap
	 */
	@PostMapping("/journal/list")
	@ResponseBody
	public HashMap list(String authCode, HttpServletRequest request) {
		String userId = LoginUtil.login(authCode);
		CodeAndMsg codeAndMsg1 = userService.selectUserById(userId);
		User user = (User)codeAndMsg1.getData();
		String userId1 = user.getUserId();//暂时写死后续会从session获取用户信息
		HashMap resultMap = new HashMap();
		resultMap.put("code",300);
		resultMap.put("msg","未传入用户信息，请重新登录！");
		HashMap map = new HashMap();
		List<HashMap<String,Object>> list = null;
		if(userId1 != null && !"".equals(userId1)){//判断是否传入用户id 有的话把userId放到map中
			map.put("userId",userId1);
			//根据当前时间获取本周的周一到周五的时间
			StringBuffer sb = new StringBuffer();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
			for (Date date : getWeekDay()) {
				sb.append("'"+dateFormat.format(date)+"',");
			}
			String mToFday = sb.toString().substring(0,sb.toString().length() - 1);
			System.err.println("mToFday:"+mToFday);
			map.put("weekDay",mToFday);
			list = journalService.selectJournalResultList(map);//返回日报列表数据
			System.err.println("list:"+list);
			if(list.size() > 0){//大于0表示有数据
				resultMap.put("code",200);
				resultMap.put("msg","成功");
			}else{//无数据
				resultMap.put("code",300);
				resultMap.put("msg","无数据");
			}
			map.clear();//清空map
			map.put("result",list);
			//抄送人列表
			List<HashMap<String,Object>> userList = journalService.selectUserList();
			map.put("userList",userList);

		}
		resultMap.put("data",map);
		return resultMap;
	}

	/**
	 * zpl
	 * 新增保存日志
	 * @param request  传入的是json数据
	 * @return HashMap
	 */
	@ResponseBody
	@RequestMapping(value = "/journal/save",method = RequestMethod.POST,  produces = "application/json;charset=UTF-8")
	public HashMap addRb(HttpServletRequest request){
		HashMap resultMap = new HashMap();
		resultMap.put("code",300);
		resultMap.put("msg","失败");
		JSONObject jsonParam = this.getJSONParam(request);//转换传入json的数据
		Map<String, Object>  map = ( Map<String, Object>)jsonParam;//转换数据类型为map
		List<Map<String,Object>> ll = (List<Map<String, Object>>) map.get("para");//转换数据类型
		for (Object ob: ll) {
			Map mp = (Map) ob;
			mp.put("userId","025525064321734942");//用户id暂时写死之后从session里取或者前台传递
			mp.put("rbId",UUIDUtil.getUUID2());//日报主键UUID
		}
		try {
			int resultNum = journalService.insertJournalList(ll);//批量插入日报
			if(resultNum > 0){//大于0表示批量插入成功
				resultMap.put("code",200);
				resultMap.put("msg","保存成功");
				for (Object obj: ll) {//再次循环然后调用周报中的改变实际完成进度接口之所以再次循环是为了批量插入完整性
					Map mp = (Map) obj;
					//调用周报中修改周报实际完成进度接口
					weekReportService.updateActual(mp.get("w_id").toString(),Integer.valueOf(mp.get("r_finish").toString()));
				}
			}else {
				resultMap.put("code",300);
				resultMap.put("msg","失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMap;

	}

	/**
	 * 接收转换json数据的方法方法
	 * @param request
	 * @return
	 */
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
		}catch (Exception e){
			e.printStackTrace();
		}
		return jsonParam;
	}

	public CodeAndMsg getTwelveDayDate() {
		CodeAndMsg codeAndMsg = new CodeAndMsg();
		if (DetialDayDate.getTweleveDayDate().size() != 0) {
			codeAndMsg.setCode(200);
			codeAndMsg.setResult(true);
			codeAndMsg.setData(DetialDayDate.getTweleveDayDate());
		} else {
			codeAndMsg.setCode(400);
			codeAndMsg.setResult(false);
			codeAndMsg.setMsg("获取失败");

		}

		return codeAndMsg;
	}

	/**
	 * 当前时间所在一周的周一和周日时间
	 * @param
	 * @return
	 */
	public static Date[] getWeekDay() {
		Calendar calendar = Calendar.getInstance();
		while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
			calendar.add(Calendar.DAY_OF_WEEK, -1);
		}
		Date[] dates = new Date[12];
		for (int i = 0; i < 12; i++) {
			dates[i] = calendar.getTime();
			calendar.add(Calendar.DATE, 1);
		}
		return dates;

	}

	//获取企业ID值，appkey，serectkey等所必须的参数
	@GetMapping("/journal/queryEmterpriseMesg")
	@ResponseBody
	public String queryEmterpriseMesg(HttpServletRequest request){
		CodeAndMsg codeAndMsg=new CodeAndMsg();
		String config = AuthHelperDaily.getConfig(request);
		codeAndMsg.setMsg("获取成功");
		codeAndMsg.setCode(200);
		codeAndMsg.setData(config);
		codeAndMsg.setResult(true);
		return config;
	}


}
