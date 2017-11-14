package com.cicc.common.service.impl;

import com.cicc.common.bean.Drug;
import com.cicc.common.mapper.DrugMapper;
import com.cicc.common.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugMapper mapper;

    public Drug findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
}
