package com.gedi.projectmanagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.gedi.projectmanagement.config.AuthHelperDaily;
import com.gedi.projectmanagement.model.Weekreport;
import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.service.IJournalService;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.service.WeekReportService;
import com.gedi.projectmanagement.service.system.SysUserService;
import com.gedi.projectmanagement.util.DetialDayDate;
import com.gedi.projectmanagement.util.LoginUtil;
import com.gedi.projectmanagement.util.UUIDUtil;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

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
	private SysUserService sysUserService;

	@Autowired
	private ProjectPlanService projectPlanService;

	/**
	 * zpl
	 * 查询日志列表
	 * 不需要传入用户id的参数 userId会在用户进入钉钉时获取信息放在session里
	 * @return HashMap
	 */
	@PostMapping("/journal/list")
	@ResponseBody
	public HashMap list(String authCode, HttpServletRequest request) {
		Pattern pattern = Pattern.compile("[0-9]*");
		String userId ="";
		/*if(pattern.matcher(authCode).matches()){
			userId =authCode;
		}else{
			userId = LoginUtil.login(authCode);
		}*/

		//String
		SysUser user = this.sysUserService.queryUserDetail("0208286522656643");
		String userId1 = user.getUserId();//暂时写死后续会从session获取用户信息
		HashMap resultMap = new HashMap();
		HttpSession session = request.getSession();
		session.setAttribute("userj",user.getUserId());
		session.setAttribute("udepartment",user.getDepartment());
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
			for(int i=0;i<list.size();i++){
				HashMap<String,Object> item=list.get(i);
				String ts_id=(String) item.get("ts_id");//获取双周计划里的数据，如果是通过日报中   “其他”反写的数据  ts_id是空的，就不显示该计划，日报需要重新按空的填写
				if(StringUtils.isEmpty(ts_id)){
					list.clear();
					resultMap.put("code",300);
					resultMap.put("msg","无数据");
				}
			}
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

			/*HashMap<String,Object>  userHashMap= new HashMap<String,Object>();
			userHashMap.put("user_id",userId);
			userHashMap.put("user_name",user.getName());
			userList.remove(userHashMap);*/

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
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userj");
		List<Map<String,Object>> ll = (List<Map<String, Object>>) map.get("para");//转换数据类型
		for (Object ob: ll) {
			Map mp = (Map) ob;
			mp.put("userId",userId);//用户id暂时写死之后从session里取或者前台传递
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
		Date[] dates = new Date[7];
		for (int i = 0; i < 7; i++) {
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



	/**
	 * zlc
	 * 查询日志历史记录
	 * 不需要传入用户id的参数 userId会在用户进入钉钉时获取信息放在session里
	 * @return HashMap
	 */
	@PostMapping("/journal/history")
	@ResponseBody
	public HashMap history(String authCode,String type,String pageNum,String  pageSize,String startTime,String endTime,String sendUserId,HttpServletRequest request) {
		HashMap resultMap = new HashMap();

		HttpSession session2 = request.getSession();
		String userId= (String)session2.getAttribute("userj");
		if(isEmpry(userId)){
			resultMap.put("code",300);
			resultMap.put("msg","未传入用户信息，请重新登录！");
			return resultMap;
		}
		//给分页设置默认数据
		if(isEmpry(pageNum)){
			pageNum="1";
		}
		if(isEmpry(pageSize)){
			pageSize="2";
		}
		//查询用户信息
		SysUser user = this.sysUserService.queryUserDetail(userId);
		if(null==user  || isEmpry(user.getUserId())){
			resultMap.put("code",300);
			resultMap.put("msg","获取用户信息失败！");
			return resultMap;
		}
		String userId1 =user.getUserId();//获取用户信息
		if(isEmpry(userId1)){
			resultMap.put("code",300);
			resultMap.put("msg","获取用户信息失败！");
			return resultMap;
		}

		HttpSession session = request.getSession();
		session.setAttribute("userj",user.getUserId());

		//参数  查询用
		HashMap map = new HashMap();
		List<HashMap<String,Object>> list = null;

		//1，查询参数第一个   userid
		map.put("userId",userId1);


		//2，查询参数第二个   开始时间和结束时间
		if(!StringUtils.isEmpty(startTime)){
			String time = getTime(startTime)+" 00:00:00";
			map.put("startTime",time);
		}
		if(!StringUtils.isEmpty(endTime)){
			String time = getTime(endTime) +" 23:59:59";
			map.put("endTime",time);
		}

		//3,查询参数第三个    发送人
		//获取发送人的id    根据name获取对应的id


		map.put("sendUserId",sendUserId);
		//4,查询参数第四个    1-全部 2-我发出的 3-我的团队
		map.put("type",type);

		map.put("user",user);

		//获取筛选下拉框  人员信息
		CodeAndMsg userCodeAndMsg =this.sysUserService.selectUserBySign(user.getDepartment());
		List<SysUser> userDepList=(List<SysUser>) userCodeAndMsg.getData();
		map.put("userDepList",userDepList);

		//判断是否是普通员工筛选都得
		if(!StringUtils.isEmpty(sendUserId) && !sendUserId.equals(userId)   &&  !user.getIsAdmin() && !user.getIsBoss() && !user.getIsLeader()){
			resultMap.put("code",300);
			resultMap.put("msg","无数据");
			return resultMap;
		}


		//调用服务 查询数据
		list = journalService.selectJournalHistory(map,Integer.parseInt(pageSize),Integer.parseInt(pageNum));//返回日报列表数据

		if(null==list || list.size() <=0){//无数据
			resultMap.put("code",300);
			resultMap.put("msg","无数据");
			return resultMap;
		}

		for (HashMap<String, Object> stringObjectHashMap : list) {
			//转换创建日期格式
			Date createTime=(Date) stringObjectHashMap.get("create_time");
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format1 = format.format(createTime);
			stringObjectHashMap.put("create_time",format1);

			//处理日报接收人的字符串
			java.lang.Object delvers=stringObjectHashMap.get("deliver");
			String deliverArray []=delvers.toString().split(",");
			String str="";
			for (int i = 0; i < deliverArray.length; i++) {
				String deliId =deliverArray[i];
				//根据查询出的id  查询出名称
				SysUser userReturn = this.sysUserService.queryUserDetail(deliId);
				String userName=userReturn.getName();
				str+=userName+",";

			}
			//将转换好的name  放入map返回页面
			stringObjectHashMap.put("deliverNames",str.substring(0,str.length()));
		}


		//分页
		com.github.pagehelper.PageInfo<HashMap<String,Object>> pageInfo=new com.github.pagehelper.PageInfo<HashMap<String,Object>>(list);




		resultMap.put("code",200);
		resultMap.put("msg","成功");

		map.clear();//清空map
		map.put("result",pageInfo.getList());
		map.put("user",user);
		map.put("userDepList",userDepList);
		//分页数据   已经写好  目前不用，但是以后会用到的
		//map.put("pageNum",pageInfo.getPageNum());
		//map.put("pageSize",pageInfo.getPageSize());
		resultMap.put("data",map);
		return resultMap;
	}


	/**
	 * zlc
	 * 查询日志填写  上次接收人
	 *
	 * @return HashMap
	 */
	@PostMapping("/journal/lastReceiver")
	@ResponseBody
	public HashMap lastReceiver(String authCode, HttpServletRequest request) {

		//String userId = LoginUtil.login(authCode);
		HttpSession session = request.getSession();
		String userId= (String)session.getAttribute("userj");

		//String userId=authCode;
		HashMap resultMap = new HashMap();


		if(isEmpry(userId)  ){
			resultMap.put("code",300);
			resultMap.put("msg","传入参数异常，请退出重试！");
			return resultMap;
		}

		SysUser user = this.sysUserService.queryUserDetail(userId);
		if(null==user){
			resultMap.put("code",300);
			resultMap.put("msg","获取用户信息失败！");
			return resultMap;
		}


		//HttpSession session = request.getSession();
		//session.setAttribute("userj",user.getUserId());

		//参数  查询用
		HashMap map = new HashMap();
		List<HashMap<String,Object>> list = null;

		//1，查询参数第1个   userid
		map.put("userId",userId);
		map.put("type","2");//只查询自己的
		map.put("user",user);
		list = journalService.selectJournalHistory(map,1,1);//返回日报列表数据
		if(null==list || list.size() <=0){//无数据
			resultMap.put("code",300);
			resultMap.put("msg","无数据");
			return resultMap;
		}
		//查询成功  就获取第一个记录即可
		HashMap<String,Object>  mapInList=list.get(0);
		String deliver=(String) mapInList.get("deliver");
		List<HashMap<String,Object>> returnList = new ArrayList<>();
		System.out.println(!isEmpry(deliver));
		if(!isEmpry(deliver) ){
			String deliverArray []=deliver.split(",");
			for (int i = 0; i < deliverArray.length; i++) {
				String deliId =deliverArray[i];
				//根据查询出的id  查询出名称
				SysUser userReturn = this.sysUserService.queryUserDetail(deliId);
				String userName=userReturn.getName();
				HashMap mapLoc = new HashMap();
				mapLoc.put("acatar",userReturn.getAcatar());
				mapLoc.put("name",userName);
				mapLoc.put("user_id",deliId);
				returnList.add(mapLoc);
			}
		}else{
			resultMap.put("code",300);
			resultMap.put("msg","无数据");
			return resultMap;
		}

		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",returnList);
		return resultMap;
	}

	/**
	 * zlc
	 * 新增保存日志（当没有任务选项的时候，选择其他）
	 * @param request  传入的是json数据
	 * @return HashMap
	 */
	@ResponseBody
	@RequestMapping(value = "/journal/addRbOther",method = RequestMethod.POST,  produces = "application/json;charset=UTF-8")
	public HashMap addRbOther(HttpServletRequest request,String pId,String wActualProportion,String wWorkReport
		,String rGongshi,String descText,String deliver
	){

		HashMap resultMap = new HashMap();
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userj");
		//获取参数信息完整性
		if(isEmpry(userId)){
			resultMap.put("code",300);
			resultMap.put("msg","获取用户信息失败！");
			return resultMap;
		}
		String userDepartmet = (String)session.getAttribute("udepartment");


		Weekreport weekreport = new Weekreport();
		weekreport.setpId(pId);
		weekreport.setwActualProportion(Integer.valueOf(wActualProportion));
		weekreport.setwWorkReport(wWorkReport);
		//首先保存双周计划
		weekreport.setUserDepartmet(userDepartmet);
		weekreport.setUserId(userId);
		//weekreport.setrFinish(rGongshi);

		//调用周报中  增加其他的  接口
		CodeAndMsg codeAndMsg=weekReportService.dailyAddRecord(weekreport);
		if(!codeAndMsg.getMsg().equals("添加成功")){
			resultMap.put("code",401);
			resultMap.put("msg","保存失败");
			return resultMap;
		}
		//拿到保存的双周计划的id
		String wId=(String) codeAndMsg.getData();
		if(isEmpry(wId)){
			resultMap.put("code",300);
			resultMap.put("msg","提交异常，请重试！");
			return resultMap;
		}

		List<Map<String,Object>> ll = new ArrayList<Map<String,Object>>();//转换数据类型
		Map mp = new HashMap();
		mp.put("rbId",UUIDUtil.getUUID2());//日报主键UUID
		mp.put("w_id",wId);
		mp.put("p_id",pId);
		mp.put("userId",userId);//用户id暂时写死之后从session里取或者前台传递
		mp.put("ts_id","");
		mp.put("deliver",deliver);
		mp.put("r_finish",wActualProportion);
		mp.put("r_gongshi",rGongshi);
		mp.put("descText",descText);
		ll.add(mp);
		try {
			int resultNum = journalService.insertJournalList(ll);//批量插入日报
			if(resultNum > 0){//大于0表示批量插入成功
				resultMap.put("code",200);
				resultMap.put("msg","成功");
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
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public boolean  isEmpry(String str){
		boolean flag=false;
		if(str == null || str.equals("") || str.length()==0){
			flag=true;
		}
		return flag;
	}
	public String  getTime(String praTime){
		Date date = new Date(praTime);
		/*try {
			date = new SimpleDateFormat("MMM d, yyyy HH:m:s a", Locale.ENGLISH).parse(praTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		System.out.println("转化后====" + time);
		return time;
	}*/

		String c=null;
		try{
			 c = new SimpleDateFormat("yyyy-MM-dd").format(date);
			System.out.println(c);
		}catch (Exception e){
			e.printStackTrace();
		}
		return c;
	}

	@GetMapping("/journal/queryProjectNameandById")
	@ResponseBody
	public CodeAndMsg queryProjectNameandById(){
		return projectPlanService.selectAllProject();
	}

	/*****************************************************************************/

	/**
	 * zhang xingya
	 * 查询日志列表
	 * 1：优先查询上周未完成的任务项，放在最前面
	 * 2：本周的未完成的计划放在后面，按时间正序
	 * @return HashMap
	 */
	@PostMapping("/journal/getDailyList")
	@ResponseBody
	public HashMap getDailyList(String authCode, HttpServletRequest request) {
		HashMap resultMap = new HashMap();
//		if(StringUtils.isEmpty(authCode)){
//			resultMap.put("code",300);
//			resultMap.put("msg","未传入用户信息，请重新登录！");
//		}
//		String userId = LoginUtil.login(authCode); //放到正式环境时放开
		String userId ="0208286522656643";//暂时写死后续会从session获取用户信息
		//String
		SysUser user = this.sysUserService.queryUserDetail(userId);//当前登陆者
		HttpSession session = request.getSession();
		session.setAttribute("userj",user.getUserId());
		session.setAttribute("udepartment",user.getDepartment());
		HashMap map = new HashMap();
		List<HashMap<String,Object>> list = null;
		if(StringUtils.isNotEmpty(userId)){//判断是否传入用户id 有的话把userId放到map中
			map.put("userId",userId);
			//根据当前时间获取本周的周一到周五的时间
			StringBuffer sb = new StringBuffer();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
			for (Date date : getWeekDay()) {
				sb.append("'"+dateFormat.format(date)+"',");
			}
			String mToFday = sb.toString().substring(0,sb.toString().length() - 1);
			System.err.println("mToFday:"+mToFday);
			map.put("weekDay",mToFday);
			list = journalService.queryJournalResultList(map);//返回日报列表数据
			System.err.println("list:"+list);
			for(int i=0;i<list.size();i++){
				HashMap<String,Object> item=list.get(i);
				String ts_id=(String) item.get("ts_id");//获取双周计划里的数据，如果是通过日报中   “其他”反写的数据  ts_id是空的，就不显示该计划，日报需要重新按空的填写
				if(StringUtils.isEmpty(ts_id)){
					list.clear();
					resultMap.put("code",300);
					resultMap.put("msg","无数据");
				}
			}
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

			/*HashMap<String,Object>  userHashMap= new HashMap<String,Object>();
			userHashMap.put("user_id",userId);
			userHashMap.put("user_name",user.getName());
			userList.remove(userHashMap);*/

			map.put("userList",userList);


		}
		resultMap.put("data",map);
		return resultMap;
	}
}
