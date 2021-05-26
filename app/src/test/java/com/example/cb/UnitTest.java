package com.example.cb;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    // Units tests to see if the addition of days works
    @Test
    public void sumOfDate_isCorrect() {
        Product tmp = new Product("test", "0000", "26-05-2021", "test");
        assertEquals(737846, tmp.getSum());
    }
    @Test
    public void sumOfDate_isCorrect2() {
        Product tmp = new Product("test", "0000", "00-00-2000", "test");
        assertEquals(730000, tmp.getSum());
    }
}