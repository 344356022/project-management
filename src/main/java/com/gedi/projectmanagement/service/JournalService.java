package com.gedi.projectmanagement.service;

import com.gedi.projectmanagement.model.Journal;

public interface JournalService {

    int deleteByPrimaryKey(String rbId);

    int insert(com.gedi.projectmanagement.model.Journal record);

    int insertSelective(com.gedi.projectmanagement.model.Journal record);

    com.gedi.projectmanagement.model.Journal selectByPrimaryKey(String rbId);

    int updateByPrimaryKeySelective(com.gedi.projectmanagement.model.Journal record);

    int updateByPrimaryKey(Journal record);
}
