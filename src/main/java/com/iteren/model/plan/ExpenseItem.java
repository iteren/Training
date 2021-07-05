package com.iteren.model.plan;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(schema = "mywallet", name = "expense_item")
public class ExpenseItem {
    private UUID itemId;
    private String name;
    private Double limit;
    private List<ExpenseRecord> expenseRecords;

    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Type(type="pg-uuid")
    @Column(name = "item_id")
    public UUID getItemId() {
        return itemId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "\"limit\"")
    public Double getLimit() {
        return limit;
    }

    @Transient
    public List<ExpenseRecord> getExpenseRecords() {
        return expenseRecords;
    }

    public void addExpenseRecord(ExpenseRecord expenseRecord) {
        if(this.expenseRecords == null)  this.expenseRecords = new ArrayList<>();
        this.expenseRecords.add(expenseRecord);
//        expenseRecord.set
    }

    @Override
    public String toString() {
        return "ExpenseItem{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", limit=" + limit +
                ", expenseRecords=" + expenseRecords +
                '}';
    }
}
