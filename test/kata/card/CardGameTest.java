package kata.card;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardGameTest {

    @Test
    public void sampleTests() {
        assertEquals(8, CardGame.cardGame(10));
        assertEquals(3, CardGame.cardGame(4));
        assertEquals(2, CardGame.cardGame(5));
        assertEquals(9, CardGame.cardGame(12));
    }

}