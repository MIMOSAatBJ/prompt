package com.mimosa.common.service;

import com.mimosa.common.bean.Drug;

public interface DrugService {
    Drug findById(Integer id);

    int insert(Drug drug);
}
