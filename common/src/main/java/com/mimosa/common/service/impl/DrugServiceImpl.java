package com.mimosa.common.service.impl;

import com.mimosa.common.bean.Drug;
import com.mimosa.common.mapper.DrugMapper;
import com.mimosa.common.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugMapper mapper;

    public Drug findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Drug drug) {
        return  mapper.insertSelective(drug);
    }
}
