package com.iteren.dao.plan;

import com.iteren.model.plan.IncomeSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface IncomeSourceRepository extends CrudRepository<IncomeSource, UUID> {
}
