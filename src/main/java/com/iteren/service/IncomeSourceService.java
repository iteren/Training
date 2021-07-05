package com.iteren.service;

import com.iteren.dao.plan.IncomeSourceRepository;
import com.iteren.model.plan.IncomeSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IncomeSourceService {
    @Autowired
    private IncomeSourceRepository repository;

    @Transactional
    public IncomeSource save(IncomeSource incomeSource) {
        return repository.save(incomeSource);
    }

    @Transactional
    public List<IncomeSource> getAll() {
        List<IncomeSource> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }
}
