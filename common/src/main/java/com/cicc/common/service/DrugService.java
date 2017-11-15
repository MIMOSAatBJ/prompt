package com.cicc.common.service;

import com.cicc.common.bean.Drug;

public interface DrugService {
    Drug findById(Integer id);

    int insert(Drug drug);
}
