package proj4;

import java.util.ArrayList;

public class StudPokerHandTests {
    private static final int FULL_DECK_LENGTH = 52;
    private static final int STUD_HAND_LENGTH = 2;

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
        testTwoPairsHand1Wins();
        testTwoPairsHand2Wins();
        testTwoTwoPairsHand1Wins();
        testTwoTwoPairsHand2Wins();
        testTwoHighCardsHand1Wins();
        testTwoHighCardsHand2Wins();
        testPairHand2Wins();
        testHighCardHand1Wins();
        testHighCardHand2Wins();
        testTies();
        testTies2();
        Testing.finishTests();
    }

    public static void testFlushHand1Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("4", "C"));
        cardList.add(new Card("5", "C"));
        cardList.add(new Card("6", "C"));
        cardList.add(new Card("7", "C"));
        cardList.add(new Card("8", "C"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("3", "H"));
        hand1.add(new Card("King", "C"));
        hand2.add(new Card(4, 0));
        hand2.add(new Card(5, 1));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand1 winning with flush", 1, actual);
    }

    public static void testFlushHand2Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("4", "C"));
        cardList.add(new Card("5", "C"));
        cardList.add(new Card("6", "C"));
        cardList.add(new Card("7", "C"));
        cardList.add(new Card("8", "C"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card(2, 1));
        hand1.add(new Card(3, 0));
        hand2.add(new Card("King", "H"));
        hand2.add(new Card("Queen", "C"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand2 winning with flush", -1, actual);
    }

    public static void testPairHand1Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("9", "H"));
        cardList.add(new Card("7", "D"));
        cardList.add(new Card("8", "C"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("3", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("14", "H"));
        hand1.add(new Card("7", "D"));
        hand2.add(new Card("12", "C"));
        hand2.add(new Card("6", "S"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand1 winning with a pair", 1, actual);
    }
    public static void testPairHand2Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("6", "H"));
        cardList.add(new Card("9", "D"));
        cardList.add(new Card("8", "C"));
        cardList.add(new Card("3", "C"));
        cardList.add(new Card("10", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("14", "H"));
        hand1.add(new Card("7", "D"));
        hand2.add(new Card("12", "C"));
        hand2.add(new Card("6", "S"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand2 winning with a pair", -1, actual);
    }
    public static void testTwoPairHand1Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("9", "H"));
        cardList.add(new Card("7", "D"));
        cardList.add(new Card("8", "C"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("3", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("11", "H"));
        hand1.add(new Card("7", "D"));
        hand2.add(new Card("12", "C"));
        hand2.add(new Card("6", "S"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand1 winning with two pairs", 1, actual);
    }
    public static void testTwoPairHand2Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("3", "H"));
        cardList.add(new Card("8", "D"));
        cardList.add(new Card("13", "C"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("3", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("14", "H"));
        hand1.add(new Card("7", "D"));
        hand2.add(new Card("11", "H"));
        hand2.add(new Card("6", "S"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand2 winning with two pairs", -1, actual);
    }
    public static void testHighCardHand1Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("9", "H"));
        cardList.add(new Card("7", "D"));
        cardList.add(new Card("8", "C"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("3", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("14", "H"));
        hand1.add(new Card("2", "D"));
        hand2.add(new Card("12", "C"));
        hand2.add(new Card("6", "S"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand1 winning with high card", 1, actual);
    }
    public static void testHighCardHand2Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("10", "H"));
        cardList.add(new Card("9", "D"));
        cardList.add(new Card("8", "C"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("6", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("4", "H"));
        hand1.add(new Card("7", "D"));
        hand2.add(new Card("12", "C"));
        hand2.add(new Card("5", "S"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand2 winning with high card", -1, actual);

    }
    public static void testTwoFlushesHand1Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("9", "H"));
        cardList.add(new Card("7", "C"));
        cardList.add(new Card("8", "C"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("3", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("14", "C"));
        hand1.add(new Card("8", "C"));
        hand2.add(new Card("12", "C"));
        hand2.add(new Card("6", "C"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand1 winning if both hands were flushes", 1, actual);
    }
    public static void testTwoFlushesHand2Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("9", "H"));
        cardList.add(new Card("7", "H"));
        cardList.add(new Card("8", "H"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("3", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("4", "H"));
        hand1.add(new Card("7", "H"));
        hand2.add(new Card("12", "H"));
        hand2.add(new Card("6", "H"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand2 winning if both hands were flushes", -1, actual);
    }
    public static void testTwoTwoPairsHand1Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("9", "H"));
        cardList.add(new Card("9", "D"));
        cardList.add(new Card("8", "C"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("3", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("14", "H"));
        hand1.add(new Card("14", "D"));
        hand2.add(new Card("12", "C"));
        hand2.add(new Card("12", "S"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand1 winning if both hands had two pairs", 1, actual);
    }
    public static void testTwoTwoPairsHand2Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("9", "H"));
        cardList.add(new Card("7", "D"));
        cardList.add(new Card("8", "C"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("3", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("7", "H"));
        hand1.add(new Card("9", "D"));
        hand2.add(new Card("11", "S"));
        hand2.add(new Card("9", "S"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand2 winning if both hands had two pairs", -1, actual);
    }
    public static void testTwoPairsHand1Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("9", "H"));
        cardList.add(new Card("7", "D"));
        cardList.add(new Card("8", "C"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("3", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("14", "H"));
        hand1.add(new Card("7", "S"));
        hand2.add(new Card("12", "C"));
        hand2.add(new Card("7", "C"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand1 winning if both hands had a pair", 1, actual);
    }
    public static void testTwoPairsHand2Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("9", "H"));
        cardList.add(new Card("7", "D"));
        cardList.add(new Card("10", "C"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("13", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("14", "H"));
        hand1.add(new Card("7", "D"));
        hand2.add(new Card("12", "C"));
        hand2.add(new Card("9", "S"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand2 winning if both hands had a pair", -1, actual);
    }
    public static void testTwoHighCardsHand1Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("9", "H"));
        cardList.add(new Card("7", "D"));
        cardList.add(new Card("8", "C"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("3", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("14", "H"));
        hand1.add(new Card("5", "D"));
        hand2.add(new Card("12", "C"));
        hand2.add(new Card("6", "S"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand1 winning if both were high card hands", 1, actual);
    }
    public static void testTwoHighCardsHand2Wins() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("1", "H"));
        cardList.add(new Card("2", "D"));
        cardList.add(new Card("3", "C"));
        cardList.add(new Card("4", "C"));
        cardList.add(new Card("5", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("13", "H"));
        hand1.add(new Card("7", "D"));
        hand2.add(new Card("14", "C"));
        hand2.add(new Card("6", "S"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of hand2 winning if both were high card hands", -1, actual);
    }
    public static void testTies() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("9", "H"));
        cardList.add(new Card("7", "D"));
        cardList.add(new Card("8", "C"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("10", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("4", "H"));
        hand1.add(new Card("5", "D"));
        hand2.add(new Card("2", "C"));
        hand2.add(new Card("6", "S"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of tie using all community cards between two hands", 0, actual);
    }
    public static void testTies2() {
        ArrayList<Card> cardList = new ArrayList<Card>();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        cardList.add(new Card("9", "H"));
        cardList.add(new Card("7", "D"));
        cardList.add(new Card("8", "C"));
        cardList.add(new Card("11", "C"));
        cardList.add(new Card("10", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        hand1.add(new Card("14", "H"));
        hand1.add(new Card("5", "D"));
        hand2.add(new Card("14", "C"));
        hand2.add(new Card("5", "S"));
        StudPokerHand studHand1 = new StudPokerHand(cc, hand1);
        StudPokerHand studHand2 = new StudPokerHand(cc, hand2);
        int actual = studHand1.compareTo(studHand2);
        Testing.assertEquals("test of tie when both have same ranks in stud hands and there are no flush hands", 0, actual);
    }

}

