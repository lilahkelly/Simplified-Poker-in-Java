package proj4;
import java.util.ArrayList;

public class CommunityCardSet {
    final int HAND_LENGTH = 5;
    private ArrayList<Card> communityHand = new ArrayList<Card>();

    /**
     * constructor for Community Card Set
     * @param cardList takes list of Cards to add to Community Card Set
     */
    public CommunityCardSet(ArrayList<Card> cardList){
        for (int i = 0; i < cardList.size(); i++) {
            Card card = cardList.get(i);
            communityHand.add(card);
        }
    }

    /**
     * constructor for Community Card Set
     * @param gameDeck takes deck of cards and adds first five to Community Card Set
     */
    public CommunityCardSet(Deck gameDeck) {
        for (int i = 0; i < HAND_LENGTH; i++){
            Card card = gameDeck.deal();
            communityHand.add(card);
        }
    }

    /**
     * checks if poker hand has standard amount of five cards, and adds new card only if poker hand has less than five cards
     * @param card representation of playing card to add to hand
     */
    public void addCard(Card card) {
        if (communityHand.size() < HAND_LENGTH) {
            communityHand.add(card);
        }
    }

    /**
     * gets card from certain location of poker hand
     * @param index indicates location of card in hand
     * @return null if index is less than zero
     */
    public Card getIthCard(int index) {
        if (index < HAND_LENGTH) {
            return communityHand.get(index);
        }
        return null;
    }

    /**
     * returns readable string version of community hand
     */
    public String toString(){
        String toReturn = "";
        for (int i = 0; i < HAND_LENGTH; i++){
            Card card = communityHand.get(i);
            toReturn = (toReturn + "|" + card.toString() + "|");
        }
        return toReturn;
    }


}
