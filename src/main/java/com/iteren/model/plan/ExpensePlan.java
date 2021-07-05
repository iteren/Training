package com.iteren.model.plan;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Table(schema = "mywallet", name = "expense_plan")
@NamedQueries(
        {
                @NamedQuery(name = "Plan.getAllWithDetails",
                        query = "select distinct p from ExpensePlan p left join fetch p.expenseItems i"),
                @NamedQuery(name = "Plan.getById",
                        query = "select p from ExpensePlan p where p.planId = :id")
        }
)
public class ExpensePlan {
    private String planId;
    private List<ExpenseItem> expenseItems;

    @Id
    @Column(name = "plan_id")
    public String getPlanId() {
        return planId;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "plan_id", nullable = false)
    public List<ExpenseItem> getExpenseItems() {
        return expenseItems;
    }

    public void addExpenseItem(ExpenseItem expenseItem) {
        if (this.expenseItems == null) this.expenseItems = new ArrayList<>();
        this.expenseItems.add(expenseItem);
    }
}
