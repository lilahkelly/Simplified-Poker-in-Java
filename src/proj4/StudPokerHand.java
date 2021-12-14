package proj4;
import java.util.ArrayList;

public class StudPokerHand {
    final int STUD_CARDS_LENGTH = 2;
    final int HAND_LENGTH = 5;
    final int STUD_HAND_LENGTH = 7;
    private ArrayList<Card> communityCards = new ArrayList<Card>();
    private ArrayList<Card> masterHand = new ArrayList<Card>();
    private ArrayList<Card> studHand = new ArrayList<Card>();
    private ArrayList<PokerHand> handCombos = new ArrayList<PokerHand>();
    /**
     * constructor for stud poker hand; makes three hands; a community card hand, a stud poker hand, and a master hand
     * which contains both community cards and stud cards
     * @param cc community cards
     * @param cardList list of card objects to add to stud poker hand
     */
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList){
        for (int i = 0; i < HAND_LENGTH; i++){
            communityCards.add(cc.getIthCard(i));
            masterHand.add(cc.getIthCard(i));
        }
        for (int j = 0; j < STUD_CARDS_LENGTH; j++){
            studHand.add(cardList.get(j));
            masterHand.add(cardList.get(j));
        }
    }

    /**
     * constructor for stud poker hand; makes three hands; a community card hand, a stud poker hand, and a master hand
     * which contains both community cards and stud cards
     * @param cc community cards
     * @param gameDeck deck of card objects to take two card objects to add to stud poker hand
     */
    public StudPokerHand(CommunityCardSet cc, Deck gameDeck) {
        for (int i = 0; i < HAND_LENGTH; i++){
            communityCards.add(cc.getIthCard(i));
            masterHand.add(cc.getIthCard(i));
        }
        for (int j = 0; j < STUD_CARDS_LENGTH; j++){
            Card cardToAdd = gameDeck.deal();
            studHand.add(cardToAdd);
            masterHand.add(cardToAdd);
        }
    }

    /**
     * adds card to stud hand if it contains less than two hole cards
     * @param card representation of playing card to add to hand
     */
    public void addCard(Card card) {
        if (studHand.size() < STUD_CARDS_LENGTH) {
            studHand.add(card);
        }
    }

    /**
     * gets card from certain location of stud hand
     * @param index indicates location of card in hand
     * @return null if index is less than zero
     */
    public Card getIthCard(int index) {
        if (index < STUD_CARDS_LENGTH) {

            return studHand.get(index);
        }
        return null;
    }

    /**
     * gets all possible five card poker hands that can be made from master hand which contains seven card hand
     * containing both community cards and two cards in stud hand
     * @return array list of all 21 possible poker hands made from seven cards
     */
    private ArrayList<PokerHand> getAllFiveCardHands(){
        for (int i = 0; i < STUD_HAND_LENGTH; i++ ){
            for (int j = i+1; j < STUD_HAND_LENGTH; j++){
                Card card1 = masterHand.get(i);
                Card card2 = masterHand.get(j);
                masterHand.remove(card1);
                masterHand.remove(card2);
                PokerHand hand = new PokerHand(masterHand);
                handCombos.add(hand);
                masterHand.add(i, card1);
                masterHand.add(j, card2);
            }
        }
        return handCombos;
    }

    /**
     * gets best possible hand out of all 21 poker hands made in getAllFiveCardHands method by using compareTo method
     * in PokerHand class
     * @return PokerHand that is the best possible poker hand out of all 21 poker hands
     */
    private PokerHand getBestFiveCardHand() {
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);
        for (int i = 1; i < hands.size(); i++) {
            if (hands.get(i).compareTo(bestSoFar) > 0) {
                bestSoFar = hands.get(i);
            }
        }
        return bestSoFar;
    }

    /**
     * Determines how this hand compares to another hand, using the
     * community card set to determine the best 5-card hand it can
     * make. Returns positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(StudPokerHand other){
       PokerHand hand1 = getBestFiveCardHand();
       PokerHand hand2 = other.getBestFiveCardHand();
       return hand1.compareTo(hand2);
    }

    /**
     * returns readable string version of stud cards
     */
    public String toString(){
        String toReturn = "";
        for (int i = 0; i < STUD_CARDS_LENGTH; i++){
            Card card = studHand.get(i);
            toReturn = (toReturn + "|" + card.toString() + "|");
        }
        return toReturn;
    }
}

