package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.Journal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

/**
 * 日志 数据层
 * 
 * @author ruoyi
 * @date 2019-06-03
 */
@Mapper
public interface JournalMapper 
{
	/**
     * 查询日志信息
     * 
     * @param rbId 日志ID
     * @return 日志信息
     */
	public Journal selectJournalById(String rbId);
	
	/**
     * 查询日志列表
     * 
     * @param journal 日志信息
     * @return 日志集合
     */
	public List<Journal> selectJournalList(Journal journal);
	
	/**
     * 新增日志
     * 
     * @param journal 日志信息
     * @return 结果
     */
	public int insertJournal(Journal journal);
	
	/**
     * 修改日志
     * 
     * @param journal 日志信息
     * @return 结果
     */
	public int updateJournal(Journal journal);
	
	/**
     * 删除日志
     * 
     * @param rbId 日志ID
     * @return 结果
     */
	public int deleteJournalById(String rbId);
	
	/**
     * 批量删除日志
     * 
     * @param rbIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteJournalByIds(String[] rbIds);

	//返回日报列表
	List<HashMap<String, Object>> selectJournalResultList(HashMap map);

	//返回日报接收人
	List<HashMap<String, Object>> selectUserList();
}