package com.iteren.model.plan;

import com.iteren.model.Currency;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(schema = "mywallet", name = "income_source")
public class IncomeSource {
    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Type(type="pg-uuid")
    @Column(name = "income_source_id")
    private UUID incomeId;
    @Column(name = "plan_id")
    private String planId;
    @Column(name = "name")
    private String name;
    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "balance")
    private Double balance;
}
