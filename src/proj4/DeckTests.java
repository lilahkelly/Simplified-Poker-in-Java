package proj4;

public class DeckTests {
    private static final int FULL_DECK_LENGTH = 52;
    public static void main(String[] args) {
        Testing.startTests();
        testingDeal();
        testingShuffle();
        testingSize();
        testingGather();
        Testing.finishTests();
    }
    public static void testingDeal(){
        Deck deck = new Deck();
        boolean expected = true;
        String expectedCard = "2 of C";
        Card dealtCard = deck.deal();
        boolean actual = dealtCard.toString().equals(expectedCard);
        Testing.assertEquals("Testing if unshuffled deck deals first card correctly", expected, actual);
    }

    public static void testingShuffle(){
        Deck unshuffledDeck = new Deck();
        Deck shuffledDeck = new Deck();
        shuffledDeck.shuffle();
        boolean expected = false;
        boolean actual = unshuffledDeck.equals(shuffledDeck);
        Testing.assertEquals("Testing if shuffled deck is different from unshuffled deck", expected, actual);
    }

    public static void testingSize(){
        Deck deck = new Deck();
        deck.deal();
        int expected = 51;
        int actual = deck.size();
        Testing.assertEquals("Testing if size of deck is 51 after dealing one card", expected, actual);
    }


    public static void testingGather(){
        Deck ungatheredDeck = new Deck();
        Deck gatheredDeck = new Deck();
        ungatheredDeck.deal();
        gatheredDeck.deal();
        gatheredDeck.gather();
        boolean expected = false;
        boolean actual = gatheredDeck.size() == (ungatheredDeck.size());
        Testing.assertEquals("Tests if gathered and ungathered deck have different amount of cards after both dealing one card", expected, actual);
    }

}


