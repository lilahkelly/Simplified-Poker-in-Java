package proj4; // do not erase. Gradescope expects this.
import java.util.ArrayList;
import java.util.Collections;


public class PokerHand {
    private final int HAND_LENGTH = 5;
    private final int MAX_PAIRS = 2;
    private ArrayList<Integer> Ranks = new ArrayList<Integer>();
    private ArrayList<String> Suits = new ArrayList<String>();
    private ArrayList<Integer> Pairs = new ArrayList<Integer>();
    private ArrayList<Card> myHand = new ArrayList<Card>();

    /**
     * Creates representation of poker hand out of list of cards
     * @param cardList: list of card objects
     */
    public PokerHand(ArrayList<Card> cardList) {
        for (int i = 0; i < HAND_LENGTH; i++) {
            Card card = cardList.get(i);
            addCard(card);
        }
    }

    /**
     * Creates representation of poker hand out of deck of cards
     * @param gameDeck: deck of card objects
     */
    public PokerHand(Deck gameDeck) { {
            Card card = gameDeck.deal();
            addCard(card);
        }
    }

    /**
     * checks if poker hand has standard amount of five cards, and adds new card only if poker hand has less than five cards
     * @param card representation of playing card to add to hand
     */
    public void addCard(Card card) {
        if (myHand.size() < HAND_LENGTH) {
            myHand.add(card);
        }
    }

    /**
     * gets card from certain location of poker hand
     * @param index indicates location of card in hand
     * @return null if index is less than zero
     */
    public Card getIthCard(int index) {
        if (index < HAND_LENGTH) {
            return myHand.get(index);
        }
        return null;
    }

    /**
     * gets ranks from all cards in poker hand and adds them to Ranks array list
     * @return list of ranks
     */
    private ArrayList<Integer> getRanks() {
        for (int i = 0; i < HAND_LENGTH; i++) {
            Card card = myHand.get(i);
            Ranks.add(card.getRank());
        }
        return Ranks;
    }

    /**
     * gets suits from all cards in poker hand and adds them to Suits array list
     * @return list of suits
     */
    private ArrayList<String> getSuits() {
        for (int i = 0; i < HAND_LENGTH; i++) {
            Card card = myHand.get(i);
            Suits.add(card.getSuit());
        }
        return Suits;
    }

    /**
     * determines if all cards in hand have same suit, making it a flush
     * @return boolean value determining if hand is flush or not
     */
    public boolean isFlush() {
        int flush = 1;
        ArrayList<String> suits = getSuits();
        for (int i = 1; i < HAND_LENGTH; i++) {
            if (Suits.get(0).equals(Suits.get(i))) {
                flush++;
                if (flush == HAND_LENGTH) {
                    suits.clear();
                    return true;
                }
            }
        }
        suits.clear();
        return false;
    }

    /**
     * determines if any ranks of cards in hand match, making the hand have a pair;
     * if pair is found, rank of pair is found and removed twice from ranks list to get rid of pair;
     * pair rank is also saved to pair list once to see what rank pair was
     * @return modified list of ranks once pairs have been removed
     */
    private ArrayList<Integer> checkIfPair() {
        for (int i = 0; i < Ranks.size(); i++) {
            for (int j = i + 1; j < Ranks.size(); j++) {
                if (Ranks.get(i) == Ranks.get(j)) {
                    int pairRank = Ranks.get(i);
                    Pairs.add(Ranks.get(i));
                    Ranks.remove(Integer.valueOf(pairRank));
                    Ranks.remove(Integer.valueOf(pairRank));
                    return Ranks;
                }
            }
        }
        return Ranks;
    }

    /**
     * getter method for pairs array list
     * @return pairs array list
     */
    private ArrayList<Integer> getPairs() {
        return Pairs;
    }

    /**
     * checks length of ranks from checkIfPair() to determine which type of pairs hand has; runs checkIfPair() again if
     * length is 3 to check for two pairs
     * @return string twoPair if size of ranks is 1, meaning two sets of pairs were removed, string onePair if size of
     * ranks is 3, and null if size is neither 1 or 3
     */
    public String getPairType() {
        getRanks();
        checkIfPair();
        if (Ranks.size() == 3) {
            checkIfPair();
            if (Ranks.size() == 1) {
                Ranks.clear();
                return "twoPair";
            }
            if (Ranks.size() == 3) {
                Ranks.clear();
                return "onePair";
            }
        }
        return "none";
    }

    /**
     * sorts ranks in descending order
     * @return first rank after sorting, meaning it returns the highest value rank in list
     */
    private int getHighestRank() {
        Collections.sort(Ranks, Collections.reverseOrder());
        return Ranks.get(0);
    }

    /**
     * sorts ranks in descending order
     * @return sorted list of ranks from highest to lowest rank
     */
    private ArrayList<Integer> sortRank() {
        Collections.sort(Ranks, Collections.<Integer>reverseOrder());
        return Ranks;
    }

    /**
     * gets remaining ranks from list after running checkIfPair() to get highest rank value from remaining ranks;
     * if there is more than one remaining rank, checkIfPair() is run again to check for two pairs; if remaining ranks
     * still had more than one rank, ranks are sorted in descending order; first rank from each list of remaining ranks
     * is compared
     * @param other is hand to compare this hand to
     * @return a negative number if self is worth LESS than other,
     * zero if they are worth the SAME (a tie), and a positive number if
     * self is worth MORE than other
     */
    private int getRemainingRankWinner(PokerHand other){
        getRanks();
        other.getRanks();
        ArrayList<Integer> RemainingRanks1 = checkIfPair();
        ArrayList<Integer> RemainingRanks2 = other.checkIfPair();
        if (RemainingRanks1.size() != 1){
            checkIfPair();
            other.checkIfPair();
            if (RemainingRanks1.size() != 1){
                Collections.sort(RemainingRanks1, Collections.<Integer>reverseOrder());
                Collections.sort(RemainingRanks2, Collections.<Integer>reverseOrder());
            }
        }
        for (int i = 0; i < RemainingRanks1.size(); i++){
            if (RemainingRanks1.get(i) > RemainingRanks2.get(i)){
                Ranks.clear();
                other.Ranks.clear();
                return 1;
            }
            if (RemainingRanks1.get(i) < RemainingRanks2.get(i)){
                Ranks.clear();
                other.Ranks.clear();
                return -1;
            }
        }
        return 0;
    }

    /**
     * if compareTo determines both hands have same amount of pairs, gets which set of pairs has highest rank;
     * if both sets of pairs share the same ranks, getRemainingWinner() is run to determine which of remaining non-pair
     * ranks have highest value
     * @param other is hand to compare this hand to
     * @return a negative number if self is worth LESS than other,
     * zero if they are worth the SAME (a tie), and a positive number if
     * self is worth MORE than other
     */
    private int getPairsWinner(PokerHand other) {
        ArrayList<Integer> pairs = getPairs();
        ArrayList<Integer> otherPairs = other.getPairs();
        ArrayList<Integer> Pairs1 = new ArrayList<Integer>();
        ArrayList<Integer> Pairs2 = new ArrayList<Integer>();
        Pairs1.add(pairs.get(0));
        Pairs1.add(pairs.get(1));
        Pairs2.add(otherPairs.get(0));
        Pairs2.add(otherPairs.get(1));
        Collections.sort(pairs, Collections.<Integer>reverseOrder());
        Collections.sort(otherPairs, Collections.<Integer>reverseOrder());
        for (int i = 0; i < MAX_PAIRS; i++) {
            if (Pairs1.get(i) > Pairs2.get(i)) {
                return 1;
            }
            if (Pairs1.get(i) < Pairs2.get(i)) {
                return -1;
            }
        }
        return getRemainingRankWinner(other);
    }

    /**
     * if compareTo determines both hands are flushes, method determines which hand has highest rank in hand;
     * if both hands share highest rank, next highest rank is gotten and so on
     * @param other is hand to compare this hand to
     * @return a negative number if self is worth LESS than other,
     * zero if they are worth the SAME (a tie), and a positive number if
     * self is worth MORE than other
     */
    private int getFlushesWinner(PokerHand other){
        getRanks();
        other.getRanks();
        ArrayList<Integer> Ranks1 = sortRank();
        ArrayList<Integer> Ranks2 = other.sortRank();
        for (int i = 0; i < HAND_LENGTH; i++){
            int HighRank1 = Ranks1.get(i);
            int HighRank2 = Ranks2.get(i);
            if (HighRank1 > HighRank2){
                Ranks1.clear();
                Ranks2.clear();
                return 1;
            }
            if (HighRank1 < HighRank2){
                Ranks1.clear();
                Ranks2.clear();
                return -1;
            }
        }
        return 0;
    }

    /**
     * if compareTo determines both hands are high card hands (neither are flushes or have any pairs), method gets ranks
     * of both hands and sorts each in descending order, then
     * gets highest rank in both hands to determine which hand is worth more; if both hands share highest rank value,
     * second highest rank values are compared, and so on
     * @param other is hand to compare this hand to
     * @return a negative number if self is worth LESS than other,
     *zero if they are worth the SAME (a tie), and a positive number if
     * self is worth MORE than other
     */
    private int getHighCardWinner(PokerHand other){
        Ranks.clear();
        other.Ranks.clear();
        getRanks();
        sortRank();
        other.getRanks();
        other.sortRank();
        for (int i = 0; i < HAND_LENGTH; i++){
            int Rank1 = Ranks.get(i);
            int Rank2 = other.Ranks.get(i);
            if (Rank1 > Rank2){
                return 1;
            }
            if (Rank1 < Rank2){
                return -1;
            }

        }
        return 0;
    }

    /**
     * helper method for compareTo; gets results from isFlush method and if both hands are flushes, gets results from
     * getFlushesWinner method
     * @param other the hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     *if they are worth the SAME, and a positive number if this is worth
     *MORE than other
     */
    private int compareToFlush(PokerHand other){
        if (isFlush() & !other.isFlush()) {
            return 1;
        }
        else if (!isFlush() & (other.isFlush())) {
            return -1;
        }
        else if (isFlush() & (other.isFlush())) {
            return getFlushesWinner(other);
        }
        return 0;
    }

    /**
     * helper method for compareTo; gets results from getPairType method and determines which hand has better pair type;
     * if both have same pair type, gets results from getPairsWinner method
     * @param other the hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     *if they are worth the SAME, and a positive number if this is worth
     *MORE than other
     */
    private int compareToPairs(PokerHand other){
        if ((getPairType().equals("twoPair")) & (other.getPairType().equals("onePair"))) {
            return 1;
        }
        else if ((getPairType().equals("onePair")) & (other.getPairType().equals("twoPair"))) {
            return -1;
        }
        else if (((getPairType().equals("onePair")) & (other.getPairType().equals("onePair"))) ||
                ((getPairType().equals("twoPair")) & (other.getPairType().equals("twoPair")))) {
            return getPairsWinner(other);
        }
        else if ((getPairType().equals("onePair") || (getPairType().equals("twoPair"))) & (other.getPairType().equals("none"))) {
            return 1;
        }
        else if (getPairType().equals("none") & (other.getPairType().equals("onePair") || other.getPairType().equals("twoPair"))) {
            return -1;
        }
        return 0;
    }

    /**
     * helper method for compareTo; gets results from high card winner method
     * @param other the hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     *if they are worth the SAME, and a positive number if this is worth
     *MORE than other
     */
    private int compareToHighCard(PokerHand other){
        if (getHighCardWinner(other) == 1) {
            return 1;
        }
        if (getHighCardWinner(other) == -1) {
            return -1;
        }
        return 0;
    }

    /**
     * Determines how this hand compares to another hand, returns
     * positive, negative, or zero depending on the comparison.
     * @param other the hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     *if they are worth the SAME, and a positive number if this is worth
     *MORE than other
     */
    public int compareTo(PokerHand other) {
        if (compareToFlush(other) != 0){
            return compareToFlush(other);
        }
        else if (compareToPairs(other) != 0){
            return compareToPairs(other);
        }
        return compareToHighCard(other);
    }

    /**
     * returns readable version of hand where all cards are converted to strings
     */
    public String toString(){
        String toReturn = "";
        for (int i = 0; i < HAND_LENGTH; i++){
            Card card = myHand.get(i);
            toReturn = (toReturn + "|" + card.toString() + "|");
        }
        return toReturn;
    }



}
