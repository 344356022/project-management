package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.Journal;

public interface JournalMapper {
    int deleteByPrimaryKey(String rbId);

    int insert(Journal record);

    int insertSelective(Journal record);

    Journal selectByPrimaryKey(String rbId);

    int updateByPrimaryKeySelective(Journal record);

    int updateByPrimaryKey(Journal record);
}