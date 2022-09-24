package com.odde.tdd.exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseTest {

    /**
     * 分解质因数
     */
    @Test
    public void ExerciseTest1(){
        assertEquals(Arrays.asList(2,2,2,5,5,5), Exercise.decompositionPrimeFactors(1000));
        assertEquals(Arrays.asList(2,2,2), Exercise.decompositionPrimeFactors(8));
        assertEquals(Arrays.asList(2,2,5,5), Exercise.decompositionPrimeFactors(100));
    }

    /**
     * FIZZ BUZZ
     * 数字能被3,5整除时,输出FIZZBUZZ
     */
    @Test
    public void ExerciseTest2(){
        assertEquals(Exercise.FIZZ, Exercise.fizzBuzz(3));
        assertEquals(Exercise.FIZZ, Exercise.fizzBuzz(6));
        assertEquals(Exercise.FIZZ, Exercise.fizzBuzz(-3));
        assertEquals(Exercise.BUZZ, Exercise.fizzBuzz(5));
        assertEquals(Exercise.BUZZ, Exercise.fizzBuzz(10));
        assertEquals(Exercise.FIZZBUZZ, Exercise.fizzBuzz(15));
        assertEquals("1", Exercise.fizzBuzz(1));
        assertEquals("-1", Exercise.fizzBuzz(-1));
        assertEquals("", Exercise.fizzBuzz(null));
    }

    /**
     * FIZZBUZZ
     * 增加 数字中包含 3,5 也需要输出对应的FIZZBUZZ
     */
    @Test
    public void ExerciseTest3(){
        assertEquals(Exercise.FIZZ, Exercise.fizzBuzz2(3));
        assertEquals(Exercise.FIZZ, Exercise.fizzBuzz2(6));
        assertEquals(Exercise.FIZZ, Exercise.fizzBuzz2(-3));
        assertEquals(Exercise.BUZZ, Exercise.fizzBuzz2(5));
        assertEquals(Exercise.BUZZ, Exercise.fizzBuzz2(10));
        assertEquals(Exercise.FIZZBUZZ, Exercise.fizzBuzz2(15));
        assertEquals("1", Exercise.fizzBuzz2(1));
        assertEquals("-1", Exercise.fizzBuzz2(-1));
        assertEquals("", Exercise.fizzBuzz2(null));
        assertEquals(Exercise.FIZZBUZZ, Exercise.fizzBuzz2(53));
        assertEquals(Exercise.FIZZBUZZ, Exercise.fizzBuzz2(54));
        assertEquals(Exercise.FIZZBUZZ, Exercise.fizzBuzz2(235));
        assertEquals(Exercise.FIZZBUZZ, Exercise.fizzBuzz2(15));
        assertEquals(Exercise.FIZZ, Exercise.fizzBuzz2(13));
    }

    /**
     * FIZZBUZZ
     * 增加 数字中包含 3,5 也需要输出对应的FIZZBUZZ
     */
    @Test
    public void ExerciseTest4(){
        assertEquals(Exercise.FIZZ, Exercise.fizzBuzz3(3));
        assertEquals(Exercise.FIZZ, Exercise.fizzBuzz3(6));
        assertEquals(Exercise.FIZZ, Exercise.fizzBuzz3(-3));
        assertEquals(Exercise.BUZZ, Exercise.fizzBuzz3(5));
        assertEquals(Exercise.BUZZ, Exercise.fizzBuzz3(10));
        assertEquals(Exercise.FIZZBUZZ, Exercise.fizzBuzz3(15));
        assertEquals("1", Exercise.fizzBuzz3(1));
        assertEquals("-1", Exercise.fizzBuzz3(-1));
        assertEquals("", Exercise.fizzBuzz3(null));
        assertEquals(Exercise.FIZZBUZZ, Exercise.fizzBuzz3(53));
        assertEquals(Exercise.FIZZBUZZ, Exercise.fizzBuzz3(54));
        assertEquals(Exercise.FIZZBUZZ, Exercise.fizzBuzz3(235));
        assertEquals(Exercise.FIZZBUZZ, Exercise.fizzBuzz3(15));
        assertEquals(Exercise.FIZZ, Exercise.fizzBuzz3(13));
    }



}
