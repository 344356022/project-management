package com.gedi.projectmanagement.service.impl;

import java.util.HashMap;
import java.util.List;

import com.gedi.projectmanagement.dao.JournalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gedi.projectmanagement.model.Journal;
import com.gedi.projectmanagement.service.IJournalService;

import javax.annotation.Resource;

/**
 * 日志 服务层实现
 * 
 * @author ruoyi
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

	//日报接收人
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


}
