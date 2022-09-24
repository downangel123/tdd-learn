package com.odde.tdd;

import java.util.Arrays;
import java.util.List;

public class TenisScore {

    public static int a = 0;

    public static int b = 0;

    private final static List<String> list = Arrays.asList("Love","Fifteen","Thirty","Forty");

    public static String getScore(){
        String result = list.get(a);
        if(a == 40 & b == 40){
            return "Deuce";
        }
        if(a == b){
            result += " All";
        }else {
            result += " " + list.get(b);
        }
        return result;
    }

    public void leftWin(){
        a += 1;
    }

    public void rightWin(){
        b += 1;
    }
}
