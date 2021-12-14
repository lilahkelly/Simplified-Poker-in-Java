package proj4;
import java.util.ArrayList;

public class CommunityCardTests {
    private static final int COMMMUNITY_HAND_LENGTH = 5;
    public static void main(String[] args) {
        Testing.startTests();
        testingAddCard();
        testingNoAddCard();
        Testing.finishTests();
    }

    public static void testingAddCard(){
        ArrayList<Card> cardList = new ArrayList<Card>();
        cardList.add(new Card("4", "C"));
        cardList.add(new Card("5", "C"));
        cardList.add(new Card("6", "H"));
        cardList.add(new Card("7", "S"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        Card toAdd = new Card("8", "D");
        cc.addCard(toAdd);
        Card lastCardInCC= cc.getIthCard(COMMMUNITY_HAND_LENGTH-1);
        boolean actual = lastCardInCC.equals(toAdd);
        Testing.assertEquals("Testing if add card function adds card to end of community card hand when only starting with four cards", true, actual);
    }

    public static void testingNoAddCard(){
        ArrayList<Card> cardList = new ArrayList<Card>();
        cardList.add(new Card("4", "C"));
        cardList.add(new Card("5", "C"));
        cardList.add(new Card("6", "H"));
        cardList.add(new Card("7", "S"));
        cardList.add(new Card("9", "C"));
        CommunityCardSet cc = new CommunityCardSet(cardList);
        Card toAdd = new Card("8", "D");
        cc.addCard(toAdd);
        Card lastCardInCC= cc.getIthCard(COMMMUNITY_HAND_LENGTH-1);
        boolean actual = lastCardInCC.equals(toAdd);
        Testing.assertEquals("Testing if add card function stops adding new cards if Community Card Set already has five cards", false, actual);
    }

}
