/* author: Lilah Kelly
  date: 06.01.2020
  honor code: I affirm that I have carried out the attached academic endeavors with full academic honesty, in
  accordance with the Union College Honor Code and the course syllabus.
 */

package proj4;
import java.util.ArrayList;

public class PokerHandTests {
    private static final int HAND_LENGTH = 5;
    public static void main(String[] args) {
        Testing.startTests();
        testFlushHand1Wins();
        testFlushHand2Wins();
        testPairHand1Wins();
        testPairHand2Wins();
        testTwoPairHand1Wins();
        testTwoPairHand2Wins();
        testHighCardHand1Wins();
        testHighCardHand2Wins();
        testTwoFlushesHand1Wins();
        testTwoFlushesHand2Wins();
        testTwoTwoPairsHand1Wins();
        testTwoTwoPairsHand2Wins();
        testTwoPairsHand1Wins();
        testTwoPairsHand2Wins();
        testTwoHighCardsHand1Wins();
        testTwoHighCardsHand2Wins();
        testTies();
        Testing.finishTests();
    }

    public static void testFlushHand1Wins(){
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("4", "C"));
        cardList1.add(new Card("5", "C"));
        cardList1.add(new Card("6", "C"));
        cardList1.add(new Card("7", "C"));
        cardList1.add(new Card("8", "C"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("3", "C"));
        cardList2.add(new Card("5", "H"));
        cardList2.add(new Card("6", "C"));
        cardList2.add(new Card("7", "C"));
        cardList2.add(new Card("8", "C"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand1 winning with flush", 1, actual);
    }

    public static void testFlushHand2Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("14", "D"));
        cardList1.add(new Card("3", "D"));
        cardList1.add(new Card("12", "C"));
        cardList1.add(new Card("7", "C"));
        cardList1.add(new Card("9", "C"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("8", "S"));
        cardList2.add(new Card("9", "S"));
        cardList2.add(new Card("10", "S"));
        cardList2.add(new Card("11", "S"));
        cardList2.add(new Card("12", "S"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand2 winning with flush", -1, actual);
    }

    public static void testPairHand1Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("9", "H"));
        cardList1.add(new Card("9", "C"));
        cardList1.add(new Card("8", "D"));
        cardList1.add(new Card("11", "C"));
        cardList1.add(new Card("3", "S"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("14", "D"));
        cardList2.add(new Card("3", "D"));
        cardList2.add(new Card("12", "C"));
        cardList2.add(new Card("7", "C"));
        cardList2.add(new Card("9", "C"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand1 winning with a pair", 1, actual);
    }

    public static void testPairHand2Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("14", "S"));
        cardList1.add(new Card("13", "C"));
        cardList1.add(new Card("9", "D"));
        cardList1.add(new Card("11", "C"));
        cardList1.add(new Card("4", "H"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("2", "C"));
        cardList2.add(new Card("2", "H"));
        cardList2.add(new Card("3", "S"));
        cardList2.add(new Card("7", "S"));
        cardList2.add(new Card("8", "H"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand2 winning with a pair", -1, actual);
    }

    public static void testTwoPairHand1Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("6", "S"));
        cardList1.add(new Card("6", "C"));
        cardList1.add(new Card("9", "H"));
        cardList1.add(new Card("7", "D"));
        cardList1.add(new Card("8", "C"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("13", "D"));
        cardList2.add(new Card("3", "D"));
        cardList2.add(new Card("12", "C"));
        cardList2.add(new Card("7", "C"));
        cardList2.add(new Card("9", "C"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand1 winning with two pairs", 1, actual);
    }

    public static void testTwoPairHand2Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("2", "C"));
        cardList1.add(new Card("4", "C"));
        cardList1.add(new Card("7", "D"));
        cardList1.add(new Card("13", "H"));
        cardList1.add(new Card("8", "H"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("13", "C"));
        cardList2.add(new Card("13", "D"));
        cardList2.add(new Card("6", "H"));
        cardList2.add(new Card("7", "S"));
        cardList2.add(new Card("5", "D"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand2 winning with two pairs", -1, actual);
    }

    public static void testHighCardHand1Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("14", "D"));
        cardList1.add(new Card("3", "D"));
        cardList1.add(new Card("12", "C"));
        cardList1.add(new Card("7", "C"));
        cardList1.add(new Card("9", "C"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("13", "D"));
        cardList2.add(new Card("8", "H"));
        cardList2.add(new Card("11", "C"));
        cardList2.add(new Card("6", "C"));
        cardList2.add(new Card("4", "C"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand1 winning with high card", 1, actual);
    }

    public static void testHighCardHand2Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("13", "C"));
        cardList1.add(new Card("7", "H"));
        cardList1.add(new Card("6", "C"));
        cardList1.add(new Card("3", "S"));
        cardList1.add(new Card("8", "C"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("4", "C"));
        cardList2.add(new Card("9", "H"));
        cardList2.add(new Card("3", "D"));
        cardList2.add(new Card("7", "C"));
        cardList2.add(new Card("9", "C"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand2 winning with high card", -1, actual);
    }

    public static void testTwoFlushesHand1Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("4", "C"));
        cardList1.add(new Card("5", "C"));
        cardList1.add(new Card("6", "C"));
        cardList1.add(new Card("7", "C"));
        cardList1.add(new Card("8", "C"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("2", "H"));
        cardList2.add(new Card("4", "H"));
        cardList2.add(new Card("4", "H"));
        cardList2.add(new Card("5", "H"));
        cardList2.add(new Card("6", "H"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand1 winning if both hands were flushes", 1, actual);
    }

    public static void testTwoFlushesHand2Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("4", "C"));
        cardList1.add(new Card("5", "C"));
        cardList1.add(new Card("6", "C"));
        cardList1.add(new Card("7", "C"));
        cardList1.add(new Card("8", "C"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("8", "H"));
        cardList2.add(new Card("9", "H"));
        cardList2.add(new Card("10", "H"));
        cardList2.add(new Card("11", "H"));
        cardList2.add(new Card("12", "H"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand2 winning if both hands were flushes", -1, actual);
    }

    public static void testTwoTwoPairsHand1Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("6", "C"));
        cardList1.add(new Card("6", "D"));
        cardList1.add(new Card("13", "S"));
        cardList1.add(new Card("13", "H"));
        cardList1.add(new Card("2", "D"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("4", "C"));
        cardList2.add(new Card("4", "H"));
        cardList2.add(new Card("10", "D"));
        cardList2.add(new Card("10", "C"));
        cardList2.add(new Card("8", "C"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand1 winning if both hands had two pairs", 1, actual);
    }

    public static void testTwoTwoPairsHand2Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("2", "C"));
        cardList1.add(new Card("2", "H"));
        cardList1.add(new Card("7", "C"));
        cardList1.add(new Card("7", "S"));
        cardList1.add(new Card("8", "C"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("5", "C"));
        cardList2.add(new Card("5", "H"));
        cardList2.add(new Card("7", "C"));
        cardList2.add(new Card("7", "S"));
        cardList2.add(new Card("9", "H"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand2 winning if both hands had two pairs", -1, actual);
    }

    public static void testTwoPairsHand1Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("9", "H"));
        cardList1.add(new Card("9", "C"));
        cardList1.add(new Card("8", "D"));
        cardList1.add(new Card("11", "C"));
        cardList1.add(new Card("3", "S"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("7", "C"));
        cardList2.add(new Card("7", "S"));
        cardList2.add(new Card("6", "D"));
        cardList2.add(new Card("7", "H"));
        cardList2.add(new Card("9", "C"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand1 winning if both hands had a pair", 1, actual);
    }

    public static void testTwoPairsHand2Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("4", "C"));
        cardList1.add(new Card("4", "S"));
        cardList1.add(new Card("8", "D"));
        cardList1.add(new Card("10", "C"));
        cardList1.add(new Card("11", "H"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("2", "C"));
        cardList2.add(new Card("12", "H"));
        cardList2.add(new Card("12", "C"));
        cardList2.add(new Card("13", "C"));
        cardList2.add(new Card("14", "C"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand2 winning if both hands had a pair", -1, actual);
    }

    public static void testTwoHighCardsHand1Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("14", "D"));
        cardList1.add(new Card("3", "D"));
        cardList1.add(new Card("12", "C"));
        cardList1.add(new Card("7", "C"));
        cardList1.add(new Card("9", "C"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("12", "D"));
        cardList2.add(new Card("4", "H"));
        cardList2.add(new Card("6", "S"));
        cardList2.add(new Card("7", "H"));
        cardList2.add(new Card("10", "D"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand1 winning if both were high card hands", 1, actual);
    }
    public static void testTwoHighCardsHand2Wins() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card("12", "D"));
        cardList1.add(new Card("3", "H"));
        cardList1.add(new Card("10", "C"));
        cardList1.add(new Card("7", "C"));
        cardList1.add(new Card("9", "C"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("14", "D"));
        cardList2.add(new Card("3", "D"));
        cardList2.add(new Card("6", "S"));
        cardList2.add(new Card("7", "H"));
        cardList2.add(new Card("10", "D"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of hand2 winning if both were high card hands", -1, actual);
    }
    public static void testTies() {
        ArrayList<Card> cardList1 = new ArrayList<Card>();
        ArrayList<Card> cardList2 = new ArrayList<Card>();
        cardList1.add(new Card( "2", "H"));
        cardList1.add(new Card("3", "C"));
        cardList1.add(new Card("4", "S"));
        cardList1.add(new Card("5", "C"));
        cardList1.add(new Card("6", "C"));
        PokerHand hand1 = new PokerHand(cardList1);
        cardList2.add(new Card("2", "C"));
        cardList2.add(new Card("3", "H"));
        cardList2.add(new Card("4", "D"));
        cardList2.add(new Card("5", "H"));
        cardList2.add(new Card("6", "S"));
        PokerHand hand2 = new PokerHand(cardList2);
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("test of tie between two hands", 0, actual);
    }
}

