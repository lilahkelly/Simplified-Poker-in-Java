package proj4; // do not erase. Gradescope expects this.
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Deck{
    private final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"};
    private final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final int NUMBER_OF_CARDS=52;
    private static final int NUMBER_OF_SUITS=4;
    private static final int CARDS_IN_SUIT=13;
    private static final int HAND_LENGTH = 5;
    private ArrayList<Card> myDeck;
    private int nextToDeal;

    /**
     * creates ArrayList to represent deck of cards
     */
    public Deck() {
        nextToDeal = 0;
        myDeck = new ArrayList<Card>();
        for (String rank : ranks) {
            for (String suit : suits) {
                Card card = new Card(rank, suit);
                myDeck.add(card);

            }
        }
    }

    /**
     * returns shuffled deck by swapping card location with random card location and vice versa
     */
    public void shuffle() {
        for (int oldCardIndex = nextToDeal; oldCardIndex < myDeck.size(); oldCardIndex++) {
            int newCardIndex = ThreadLocalRandom.current().nextInt(myDeck.size());
            Card oldCard = myDeck.get(oldCardIndex);
            Card newCard = myDeck.get(newCardIndex);
            myDeck.set(oldCardIndex, newCard);
            myDeck.set(newCardIndex, oldCard);
        }
    }

    /**
     * returns size of deck by using nextToDeal as marker of which cards have been dealt
     */
    public int size() {
        return ((myDeck.size() - nextToDeal));
    }

    /**
     * deals single card from created deck; progresses through deck by adding one to nextToDeal after every card dealt
     * @return null if deck empty; otherwise first card in deck
     */
    public Card deal() {
        if (size() > 0) {
            Card dealtCard = myDeck.get(nextToDeal);
            nextToDeal++;
            return dealtCard;
            }
        return null;
    }

    /**
     * gathers deck to unshuffled state by setting nextToDeal to zero again (moving divider between dealt and undealt
     * cards to very front of deck
     */
    public void gather(){
        nextToDeal = 0;
    }

    /**
     * returns boolean indicating whether deck is empty or not
     */
    public boolean isEmpty(){
        if (size() == 0){
            return true;
        }
        return false;
    }

    /**
     * returns readable version of deck with each card in deck made into string
     */
    public String toString(){
        String toReturn = "";
        for (int i = nextToDeal; i < myDeck.size(); i++){
            Card card = myDeck.get(i);
            toReturn = (toReturn +"|" + card.toString() + "|");
        }
        return toReturn;
    }
}
