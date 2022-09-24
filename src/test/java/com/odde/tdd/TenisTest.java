package com.odde.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TenisTest {

    TenisScore  tenis = new TenisScore();

    @Test
    void score_0_0() {
        assertEquals("Love All",TenisScore.getScore());
    }

    @Test
    void score_15_0(){
        tenis.leftWin();
        assertEquals("Fifteen Love",TenisScore.getScore());
    }

    @Test
    void score_15_15(){
        tenis.leftWin();
        tenis.rightWin();
        assertEquals("Fifteen All",TenisScore.getScore());
    }

    @Test
    void score_40_40(){
        tenis.leftWin();
        tenis.leftWin();
        tenis.leftWin();
        tenis.rightWin();
        tenis.rightWin();
        tenis.rightWin();
        assertEquals("Deuce",TenisScore.getScore());
    }

    @Test
    void score_45_40(){
        tenis.leftWin();
        tenis.leftWin();
        tenis.leftWin();
        tenis.rightWin();
        tenis.rightWin();
        tenis.rightWin();
        tenis.leftWin();
        assertEquals("Deuce",TenisScore.getScore());
    }

}
