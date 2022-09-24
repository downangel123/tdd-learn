package com.odde.tdd;

import org.junit.jupiter.api.Test;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetPlanTest {

    BudgetPlan budgetPlan = new BudgetPlan(() -> Arrays.asList(
            new Budget(YearMonth.of(2022,9),3000),
            new Budget(YearMonth.of(2022,10),620),
            new Budget(YearMonth.of(2022,11),300),
            new Budget(YearMonth.of(2023,1),31000),
            new Budget(YearMonth.of(2022,8),3000)));

    @Test
    public void query_start_to_end_smaller_than_0_days(){
        assertEquals(0L,budgetPlan.queryBudget("2022-09-24","2022-09-23"));
    }

    @Test
    public void query_start_to_end_1(){
        assertEquals(100L,budgetPlan.queryBudget("2022-09-24","2022-09-24"));
    }

    @Test
    public void query_start_to_end_2(){
        assertEquals(200L,budgetPlan.queryBudget("2022-09-23","2022-09-24"));
    }

    @Test
    public void query_start_to_end_month_9_to_10(){
        assertEquals(120L,budgetPlan.queryBudget("2022-09-30","2022-10-01"));
    }

    @Test
    public void query_start_to_end_month_9_to_11(){
        assertEquals(100L+620L+10L,budgetPlan.queryBudget("2022-09-30","2022-11-01"));
    }

    @Test
    public void query_start_to_end_2_years(){
        assertEquals(2000L+10L,budgetPlan.queryBudget("2022-11-31","2023-01-02"));
    }

    @Test
    public void not_long_value(){
        assertEquals(96L,budgetPlan.queryBudget("2022-08-30","2022-08-30"));
    }

    @Test
    public void not_available_date(){
        assertEquals(0L,budgetPlan.queryBudget("2022-08-32","2022-08-30"));
    }
}
