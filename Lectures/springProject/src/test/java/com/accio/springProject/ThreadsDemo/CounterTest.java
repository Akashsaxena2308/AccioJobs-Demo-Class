package com.accio.springProject.ThreadsDemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CounterTest {

    private Counter counter;

    @BeforeEach
    void setup(){
        counter = new Counter();
    }

    @Test
    void incrementIncreaseValueByOne(){
        counter.increment();
        assertEquals(1, counter.getValue());
    }

    @Test
    void incrementIncreaseValueByTwo(){
        counter.increment();
        counter.increment();

        assertEquals(2, counter.getValue());
    }

    @Test
    void rejectNonNumbers(){
        assertThrows(NumberFormatException.class ,
                () -> Integer.parseInt("1"));
    }
}
