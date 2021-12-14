package proj4;
import java.util.Scanner;

public class Main {
    private static final int TWO_HOLE_CARD_HANDS = 4;
    public static void main(String[] args){
        Deck gameDeck = new Deck();
        gameDeck.shuffle();
        int points = 0;
        CommunityCardSet cc = new CommunityCardSet(gameDeck);
        while (gameDeck.size() > TWO_HOLE_CARD_HANDS){
            StudPokerHand studHand1 = new StudPokerHand(cc, gameDeck);
            StudPokerHand studHand2 = new StudPokerHand(cc, gameDeck);
            System.out.println("Community Cards: " + cc);
            System.out.println("Stud Hand 1: " + studHand1);
            System.out.println("Stud Hand 2: " + studHand2);
            int comparison = studHand1.compareTo(studHand2);
            Scanner scannerObj = new Scanner(System.in);
            System.out.println("Which hand is worth more in a game of poker? Type 1 for Hand1, -1 for Hand2, and 0 for a tie.");
            String playersInput = scannerObj.nextLine();
            if (Integer.toString(comparison).equals(playersInput)) {
                points++;
                System.out.println("Correct!");
            }
            if (!Integer.toString(comparison).equals(playersInput)) {
                System.out.println("Incorrect");
            }
        }
        System.out.println("Game over! Not enough cards left in deck. Your score is: " + points);
    }
}

