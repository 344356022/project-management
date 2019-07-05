package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.Journal;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 日志 数据层
 *
 * @author zpl
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

	/**
	 * 返回日报列表
	 * @param map 需要用户信息
	 * @return
	 */
	List<HashMap<String, Object>> selectJournalResultList(HashMap map);

	/**
	 * 查询个人日志列表
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>> queryJournalResultList(HashMap map);

	/**
	 * 返回日报接收人列表
	 * @return
	 */
	List<HashMap<String, Object>> selectUserList();

	/**
	 * 批量插入日报信息
	 * @param list
	 * @return
	 */
    int insertJournalList(List list);



	/**
	 * 查询日报记录列表
	 *
	 * @param map 日志信息
	 * @return 日志集合
	 */
	public List<HashMap<String, Object>> selectJournalHistory(HashMap map);

	/**
	 * 查询我的团队的日报记录
	 * @param map
	 * @return
	 */
	public List<HashMap<String, Object>> querySelfTeamDaily(HashMap map);

	/**
	 * 查询所有的日报信息
	 * @param map
	 * @return
	 */
	public List<HashMap<String, Object>> queryAllDaily(HashMap map);


	List<Journal> selectBypId(String pId);

}