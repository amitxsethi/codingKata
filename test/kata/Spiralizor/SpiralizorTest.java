package kata.Spiralizor;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpiralizorTest {

    @Test
    public void test6() {
        assertArrayEquals(
                new int[][] {
                        { 1, 1, 1, 1, 1, 1 },
                        { 0, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 0, 1 },
                        { 1, 0, 0, 1, 0, 1 },
                        { 1, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1 }
                },
                Spiralizor.spiralize(6));
    }


    @Test
    public void test5() {
        assertArrayEquals(
                new int[][] {
                        { 1, 1, 1, 1, 1 },
                        { 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1 }
                },
                Spiralizor.spiralize(5));
    }

    @Test
    public void test8() {
        assertArrayEquals(
                new int[][] {
                        { 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 0, 1 },
                        { 1, 0, 0, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 1 },
                        { 1, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1 },
                },
                Spiralizor.spiralize(8));
    }

}