package com.odde.tdd.exercise;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 练习
 */
public class Exercise {

    /**
     * 分解质因数
     *
     * @param value 需要分解的数字
     * @return 质因数列表
     */
    @NotNull
    public static List<Integer> decompositionPrimeFactors(Integer value) {
        List<Integer> list = new ArrayList<>();
        while (value > 1) {
            for (int i = 2; i <= value; i++) {
                if (value % i == 0) {
                    list.add(i);
                    value = value / i;
                    break;
                }
            }
        }
        return list;
    }

    public final static String FIZZBUZZ = "FIZZBUZZ";
    public final static String FIZZ = "FIZZ";
    public final static String BUZZ = "BUZZ";
    @NotNull
    public static String fizzBuzz(Integer num){
        if(num == null){
            return "";
        }
        if(num%3 == 0 && num%5 == 0){
            return FIZZBUZZ;
        }else if(num%3 == 0){
            return FIZZ;
        }else if(num%5 == 0){
            return BUZZ;
        }else {
            return ""+num;
        }
    }

    /**
     * 容易场景不全,使用 @link fizzBuzz3
     */
    public static String fizzBuzz2(Integer num){
        String str = "";
        if(num == null){
            return str;
        }
        String numStr = ""+num;
        if(num%3 == 0 && num%5 == 0) {
            return FIZZBUZZ;
        }else if(numStr.contains("3") && numStr.contains("5")){
            return FIZZBUZZ;
        }else if(numStr.contains("3") && num%5 == 0){
            return FIZZBUZZ;
        }else if(numStr.contains("5") && num%3 == 0){
            return FIZZBUZZ;
        }else if(num%3 == 0 || numStr.contains("3")){
            return FIZZ;
        }else if(num%5 == 0 || numStr.contains("5")){
            return BUZZ;
        }else {
            return numStr;
        }
    }

    public static String fizzBuzz3(Integer num){
        String str = "";
        if(num == null){
            return str;
        }
        String numStr = ""+num;
        if(num%3 == 0 || numStr.contains("3")){
            str += FIZZ;
        }
        if(num%5 == 0 || numStr.contains("5")){
            str += BUZZ;
        }
        if("".equals(str)){
            return numStr;
        }
        return str;
    }



}
