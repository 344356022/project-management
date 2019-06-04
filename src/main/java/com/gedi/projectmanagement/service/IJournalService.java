package com.gedi.projectmanagement.service;

import com.gedi.projectmanagement.model.Journal;

import java.util.HashMap;
import java.util.List;

/**
 * 日志 服务层
 * 
 * @author ruoyi
 * @date 2019-06-03
 */
public interface IJournalService 
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
     * 删除日志信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteJournalByIds(String ids);

	/**
	 * 日报列表
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>> selectJournalResultList(HashMap map);

	//日报返回日志接收人
    List<HashMap<String, Object>> selectUserList();
}
