package com.mimosa.common.mapper;

import com.mimosa.common.bean.Drug;

public interface DrugMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Drug record);

    int insertSelective(Drug record);

    Drug selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKey(Drug record);
}