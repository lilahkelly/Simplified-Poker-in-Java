package proj4;

public class CardTests {
    public static void main(String[] args) {
        Testing.startTests();
        testingIntConstructor();
        testingIntConstructorFaceCard();
        testingStringConstructorCase1();
        testingStringConstructorCase2();
        testingStringConstructorCase3();
        testingStringConstructorFaceCard();
        testingGetSuit();
        testingGetRank();
        Testing.finishTests();
    }

    public static void testingIntConstructor(){
        Card card = new Card(4, 1);
        String expectedCard = "4 of Hearts";
        boolean actual = card.toString().equals(expectedCard);
        Testing.assertEquals("Tests integer card constructor", true, actual);
    }

    public static void testingIntConstructorFaceCard(){
        Card card = new Card(13, 3);
        String expectedCard = "King of Diamonds";
        boolean actual = card.toString().equals(expectedCard);
        Testing.assertEquals("Tests integer card constructor", true, actual);

    }

    public static void testingStringConstructorCase1() {
        Card card = new Card("4", "Hearts");
        String expectedCard = "4 of Hearts";
        boolean actual = card.toString().equals(expectedCard);
        Testing.assertEquals("Tests string card constructor with numerical rank input", true, actual);
    }

    public static void testingStringConstructorCase2() {
        Card card = new Card("four", "Hearts");
        String expectedCard = "4 of Hearts";
        boolean actual = card.toString().equals(expectedCard);
        Testing.assertEquals("Tests string card constructor with rank spelled out input", true, actual);
    }

    public static void testingStringConstructorCase3() {
        Card card = new Card("Four", "Hearts");
        String expectedCard = "4 of Hearts";
        boolean actual = card.toString().equals(expectedCard);
        Testing.assertEquals("Tests string card constructor case insensitivity", true, actual);
    }

    public static void testingStringConstructorFaceCard(){
        Card card = new Card("13", "Diamonds");
        String expectedCard = "King of Diamonds";
        boolean actual = card.toString().equals(expectedCard);
        Testing.assertEquals("Tests string card constructor with face card", true, actual);

    }

    public static void testingGetSuit(){
        Card card = new Card("13", "Diamonds");
        String suit = "Diamonds";
        boolean actual = card.getSuit().equals(suit);
        Testing.assertEquals("Tests string card constructor with face card", true, actual);

    }

    public static void testingGetRank(){
        Card card = new Card("Four", "Hearts");
        int rank = 4;
        boolean actual = card.getRank() == (rank);
        Testing.assertEquals("Tests string card constructor with face card", true, actual);

    }



}
