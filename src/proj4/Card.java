package proj4; 
public class Card {
    private int rank;
    private String suit;

    /**
     * card constructor
     * @param rank String: whole cards (2-10) can either be spelled
     * out like "two" or numeric like "2". Case insensitive.
     * @param suit String: "Spades", "Hearts", "Clubs", or "Diamonds"
     */
    public Card(String rank, String suit){
        this.suit = suit;
        this.rank = stringToInteger(rank);
    }

    /**
     * card constructor
     * @param rank integer between 2-14
     * @param suit integer: 0=Spades, 1=Hearts, 2=Clubs, or 3=Diamonds
     */
    public Card(int rank, int suit){
        this.suit = intToString(suit);
        this.rank = rank;
    }

    /**
     * converts all integer suit values into readable string version
     * @param suit if suit input is an integer, fed into her
     * @return String version of suit or null if suit input is none of possible integer values
     */
    private String intToString(int suit){
        if (suit == 0){
            return "Spades";
        }
        else if (suit == 1){
            return "Hearts";
        }
        else if (suit == 2){
            return "Clubs";
        }
        else if (suit == 3){
            return "Diamonds";
        }
        return null;
    }

    /**
     * converts all possible string variations of playing card rank and converts into corresponding integer
     * @param rank if rank is a string, fed into here
     * @return integer indicating rank; returns 2 as default if string does not fit any of possible inputs
     */
    private int stringToInteger(String rank) {
        if ((rank.equalsIgnoreCase("two")) || rank.equalsIgnoreCase("2")){
            return 2;
        }
        else if ((rank.equalsIgnoreCase("three")) || rank.equalsIgnoreCase("3")){
            return 3;
        }
        else if ((rank.equalsIgnoreCase("four")) || rank.equalsIgnoreCase("4")){
            return 4;
        }
        else if ((rank.equalsIgnoreCase("five")) || rank.equalsIgnoreCase("5")){
            return 5;
        }
        else if ((rank.equalsIgnoreCase("six")) || rank.equalsIgnoreCase("6")){
            return 6;
        }

        else if ((rank.equalsIgnoreCase("seven")) || rank.equalsIgnoreCase("7")){
            return 7;
        }
        else if ((rank.equalsIgnoreCase("eight")) || rank.equalsIgnoreCase("8")){
            return 8;
        }
        else if ((rank.equalsIgnoreCase("nine")) || rank.equalsIgnoreCase("9")){
            return 9;
        }
        else if ((rank.equalsIgnoreCase("ten")) || rank.equalsIgnoreCase("10")){
            return 10;
        }
        else if ((rank.equalsIgnoreCase("eleven")) || rank.equalsIgnoreCase("Jack") || rank.equalsIgnoreCase("11")) {
            return 11;
        }
        else if ((rank.equalsIgnoreCase("twelve")) || rank.equalsIgnoreCase("Queen") || rank.equalsIgnoreCase("12")){
            return 12;
        }
        else if ((rank.equalsIgnoreCase("thirteen")) || rank.equalsIgnoreCase("King") || rank.equalsIgnoreCase("13")) {
            return 13;
        }
        else if ((rank.equalsIgnoreCase("fourteen")) || rank.equalsIgnoreCase("Ace") || rank.equalsIgnoreCase("14")) {
            return 14;
        }
        return 2;
    }

    /**
     * returns rank value of card
     * @return
     */
    public Integer getRank(){
        return this.rank;
    }

    /**
     * returns suit value of card
     */
    public String getSuit(){
        return this.suit;
    }

    /**
     * returns rank and suit values in readable string format
     */
    public String toString() {
        String modifiedRank = Integer.toString(this.rank);
        if (this.rank == 14){
            modifiedRank = "Ace";
            return modifiedRank + " of " + this.getSuit();
        }
        else if (this.rank == 13){
            modifiedRank = "King";
            return modifiedRank + " of " + this.getSuit();
        }
        else if (this.rank == 12){
            modifiedRank = "Queen";
            return modifiedRank + " of " + this.getSuit();
        }
        else if (this.rank == 11){
            modifiedRank = "Jack";
            return modifiedRank + " of " + this.getSuit();
        }
        return modifiedRank + " of " + this.getSuit();
    }

}


