package kata.card;

public class CardGame {


    public static long cardGame(long n) {
        long aliceCardsCount = 0;
        long bobCardsCount = 0;
        long playingDeck;

        playingDeck = n;
        while (playingDeck > 0) {
            if (playingDeck%2==0) {
                aliceCardsCount = aliceCardsCount + (playingDeck/2);
                playingDeck = playingDeck/2;
            } else {
                aliceCardsCount = aliceCardsCount + 1;
                playingDeck = playingDeck -1;
            }
            if (playingDeck%2==0) {
                bobCardsCount = bobCardsCount + (playingDeck/2);
                playingDeck = playingDeck/2;
            } else {
                bobCardsCount = bobCardsCount + 1;
                playingDeck = playingDeck -1;
            }
        }
        return aliceCardsCount;
    }


}
