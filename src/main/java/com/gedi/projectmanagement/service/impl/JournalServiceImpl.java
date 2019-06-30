package com.gedi.projectmanagement.service.impl;

import java.util.HashMap;
import java.util.List;

import com.gedi.projectmanagement.dao.JournalMapper;
import com.gedi.projectmanagement.model.system.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gedi.projectmanagement.model.Journal;
import com.gedi.projectmanagement.service.IJournalService;

import javax.annotation.Resource;

/**
 * 日志 服务层实现
 * 
 * @author zpl
 * @date 2019-06-03
 */
@Service
public class JournalServiceImpl implements  IJournalService
{
	@Resource
	private JournalMapper journalMapper;

	@Override
	public Journal selectJournalById(String rbId) {
		return null;
	}

	@Override
	public List<Journal> selectJournalList(Journal journal) {
		return journalMapper.selectJournalList(journal);
	}

	@Override
	public int insertJournal(Journal journal) {
		return 0;
	}

	@Override
	public int updateJournal(Journal journal) {
		return 0;
	}

	@Override
	public int deleteJournalByIds(String ids) {
		return 0;
	}

	//返回日报列表
	@Override
	public List<HashMap<String, Object>> selectJournalResultList(HashMap map) {
		return journalMapper.selectJournalResultList(map);
	}

	/**
	 *
	 * 日报接收人
	 * @return List<HashMap<String, Object>>
	 */
	@Override
	public List<HashMap<String, Object>> selectUserList() {
		return journalMapper.selectUserList();
	}

	/**
	 * 批量插入日报信息
	 * @param list
	 * @return
	 */
	@Override
	public int insertJournalList(List list) {
		return journalMapper.insertJournalList(list);
	}


	/**
	 * 返回日报填写记录列表
	 */
	@Override
	public List<HashMap<String, Object>> selectJournalHistory(HashMap map,int pageSize,int pageNum) {
		//该设置是设置分页查询   暂时不用  如需  请打开
		//PageHelper.startPage( pageNum,pageSize);
		//判断权限
		SysUser user = (SysUser) map.get("user");
		String type = (String) map.get("type");
		//如果是管理员或者老板或者主管
		if(user.getIsAdmin() || user.getIsBoss() || user.getIsLeader()){
			if("2".equals(type)){//只查询自己的

				return journalMapper.selectJournalHistory(map);
			}else if ("3".equals(type)){//查询我的团队人员的
				return this.journalMapper.querySelfTeamDaily(map);
			}else { //查询全部
				return this.journalMapper.queryAllDaily(map);
			}
		}else { //说明是员工
			return journalMapper.selectJournalHistory(map);
		}
	}

}
