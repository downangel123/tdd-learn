package com.odde.tdd;

import cn.hutool.core.date.DateUtil;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BudgetPlan {

    private BudgetRepo budgetRepo;

    public BudgetPlan(BudgetRepo budgetRepo){
        this.budgetRepo = budgetRepo;
    }

    public BudgetPlan(){
        this.budgetRepo = new BudgetRepo() {
            @Override
            public List<Budget> findAll() {
                return Arrays.asList(new Budget(YearMonth.of(2022,9),3000),
                        new Budget(YearMonth.of(2022,10),2000),
                        new Budget(YearMonth.of(2022,11),3000));
            }
        };
    }

    public Map<YearMonth,Long> findAllMap(){
        List<Budget> list = budgetRepo.findAll();
        Map<YearMonth,Long> map = new HashMap<>();
        for(Budget budget : list){
            map.put(budget.getMonth(),budget.getAmount());
        }
        return map;
    }

    public int monthTotalDays(YearMonth yearMonth){
        return DateUtil.lengthOfMonth(yearMonth.getMonthValue(),DateUtil.isLeapYear(yearMonth.getYear()));
    }

    public long queryBudget(String startDate, String endDate){
        LocalDate start;
        LocalDate end;
        long totalAmount = 0L;
        try {
            start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }catch (Exception e){
            return totalAmount;
        }

        if(start.compareTo(end) > 0){
            return totalAmount;
        }
        Map<YearMonth,Long> budgets =  findAllMap();

        while (start.isBefore(end) || start.isEqual(end)){
            YearMonth yearMonth = YearMonth.of(start.getYear(),start.getMonthValue());
            long dayAmount = budgets.getOrDefault(yearMonth,0L)/monthTotalDays(yearMonth);

            totalAmount += dayAmount;
            start = start.plusDays(1);
        }

        return totalAmount;
    }
}
