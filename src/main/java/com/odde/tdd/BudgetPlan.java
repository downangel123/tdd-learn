package com.odde.tdd;

import cn.hutool.core.date.DateUtil;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BudgetPlan {

    private final BudgetRepo budgetRepo;

    public BudgetPlan(BudgetRepo budgetRepo){
        this.budgetRepo = budgetRepo;
    }

    public BudgetPlan(){
        this.budgetRepo = () -> {
            //查询逻辑
            return null;
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


        Map<YearMonth,Long> budgets =  findAllMap();

        while (start.compareTo(end)<=0){
            YearMonth yearMonth = YearMonth.of(start.getYear(),start.getMonthValue());
            long dayAmount = budgets.getOrDefault(yearMonth,0L)/monthTotalDays(yearMonth);

            totalAmount += dayAmount;
            start = start.plusDays(1);
        }

        return totalAmount;
    }
}
