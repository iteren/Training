package com.iteren.model.plan;

import com.iteren.model.Currency;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExpenseRecord {
    private String itemId;
    private String recordId;
    private Currency currency;
    private String name;
    private Double amount;
    private LocalDateTime expenseTime;
}
