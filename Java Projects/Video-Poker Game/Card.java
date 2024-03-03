/**
 * This class represents a French-suit Playing Card.
 * 
//******************************************
// Card.java 
// Written by Christopher Demirjian
// cjd2186
//*******************************************
 *
 * The Card class is used to represent a card in Video Poker.
 */

//use Comparable interface to compare and sort cards.

public class Card implements Comparable<Card>{
/* Declare instance variables as follows:
 *   suit: int from 1-4 representing the suit of card.
 *   rank: int from 1-13 representing the rank of card.
 *   suit_string: English string of card's suit.
 *   rank_string: English string of card's rank.
 */    
    private int suit; //use integers 1-4 to encode the suit
    private int rank; //use integers 1-13 to encode the rank
    private String suit_string;
    private String rank_string;

    
/* CONSTRUCTOR PURPOSE:   
 * The Constructor takes in the ints s and r as arguments
 *   and instantiates instance variables as follows:
      suit is initialized to int value of s as passed in constructor argument.
      rank is initialized to int value of r as passed in constructor argument.
      suit_string is initialized to "null".
      rank_string is initialized to "null".
*/    
    public Card(int s, int r){
        //make a card with suit s and rank r
        suit=s;
        rank=r;
        suit_string="null";
        rank_string="null";
    }
	

/* METHOD PURPOSE:   
 * This method is used to compare the ranks and suits of two cards.
 * The cards being compared are the card created in the constructor and
 *   the card passed in the method argument (Card c).
 * This method works with the Comparable interface to allow for easy sorting 
 *   when used in conjunction with the sort() method.
 * If the this card (from the current class) is greater in rank than Card c,
 *   1 is returned.
 * If the this card (from the current class) is lesser in rank than Card c,
 *   -1 is returned.
 * If the this card (from the current class) is equal in rank to Card c,
 *   the suit of each card is compared.
 * If the this card (from the current class) is greater in suit than Card c,
 *   1 is returned.
 * If the this card (from the current class) is lesser in suit than Card c,
 *   -1 is returned.
 * If the this card (from the current class) is equal in suit to Card c,
 *   0 is returned. (cards are the same card if they have equal rank and suit)
 */    
    public int compareTo(Card c){
        //use this method to compare cards so they 
        //may be easily sorted
        if (this.rank>c.rank){
            return 1;
        }
        if (this.rank<c.rank){
            return -1;
        }
        else{
            if (this.suit>c.suit){
                return 1;
            }
            if (this.suit<c.suit){
                return -1;
            }
            return 0;
            }
        }

    
/* METHOD PURPOSE:   
 * This method returns an English String of the rank and suit of a card,
 *   which is printed to user(as opposed to "s1", "Ace of Spades" is printed).
 * This is done by calling the suitString() and rankString() mutator methods,
 *   and then returning the String of "rank_string" + "suit_string".
 */    
    public String toString(){
        //call suitString to mutate 
        suitString();
        rankString();

        return rank_string + " of " + suit_string;
    }
    
    
/* METHOD PURPOSE:   
 * This method assigns a new suit name to the String "suit_string" (which was 
 *   initialized as "null"). 
 * The suit name is determined based on the value of suit (ranking from 1 to 4).
 */        
    private void suitString(){
        //create English/String names for each suit
        if (suit==1){
            suit_string= "Clubs";
        }
        if (suit==2){
            suit_string= "Diamonds";
        }
        if (suit==3){
            suit_string= "Hearts";
        }
        if (suit==4){
            suit_string= "Spades";
        }
    }

    
/* METHOD PURPOSE:   
 * This method assigns a new rank name to the String "rank_string" (which was 
 *   initialized as "null"). 
 * The rank name is determined based on the value of rank (ranking from 1 to 13).
 */           
    private void rankString(){
        //create English/String names for each rank
        if (rank>10 || rank==1){
            if (rank==1){
                rank_string= "Ace";
            }
            if (rank==11){
                rank_string= "Jack";
            }
            if (rank==12){
                rank_string= "Queen";
            }
            if (rank==13){
                rank_string= "King";
            }
        }
        //if rank is not 1 (ace), or greater than 10, it must be [2,10]
        else{
            rank_string= "" + rank;
        }
    }

    
/* METHOD PURPOSE:   
 * This method returns the integer value of suit.
 */       
    public int getSuit(){
        return suit;
    }

    
/* METHOD PURPOSE:   
 * This method returns the integer value of rank.
 */       
    public int getRank(){
        return rank;
    }
}
