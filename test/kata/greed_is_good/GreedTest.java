package kata.greed_is_good;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GreedTest {

    @Test
    public void testExample() {
        assertEquals("Score for [5,1,3,4,1] must be 250:", 250, Greed.greedy(new int[]{5,1,3,4,1}));
        assertEquals("Score for [1,1,1,3,1] must be 1100:", 1100, Greed.greedy(new int[]{1,1,1,3,1}));
        assertEquals("Score for [2,3,2,3,5] must be 450:", 350, Greed.greedy(new int[]{2,3,2,3,5}));
    }
}