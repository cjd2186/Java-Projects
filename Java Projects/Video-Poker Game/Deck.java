/**
 * This class represents a 52 card deck of French-suit playing cards.
 * 
//******************************************
// Deck.java 
// Written by Christopher Demirjian
// cjd2186
//*******************************************
 *
 * The Deck class is used to represent the deck of cards in Video Poker.
 */

public class Deck {

/* Declare instance variables as follows:
 *   cards: array of Card objects, representing a deck of cards.
 *   top: int representing the index of the top of the deck.
 */      
    private Card[] cards;
    private int top; //the index of the top of the deck
  
/* CONSTRUCTOR PURPOSE:   
 * The Constructor takes no arguments and
 * instantiates instance variables as follows:
     cards is initialized to array of 52 Card objects using a nested for-loop
       (every card in a 52 French-suit playing card deck).
     top is initialized to 0.
*/   
    public Deck(){
        //make a 52 card deck here
        cards = new Card[52];
        int cardCounter = 0;
        for(int suitCounter = 1; suitCounter < 5; suitCounter++){
            for(int rankCounter = 1; rankCounter < 14; rankCounter++){
                
                Card c = new Card(suitCounter, rankCounter);
                cards[cardCounter] = c;
                cardCounter++;
            }
        }
        top=0;
    }


/* METHOD PURPOSE:   
 * This method takes no arguments and changes the Cards array,
 *   randomly changing the order of the each card within the Cards array.
 * how to shuffle deck:
        -iterate through deck of cards (index 0-51)
        -make currentCard being iterated placeholder card (which will be moved)
        -find a random card in deck at a random index between 0 and 51
        -place the random card at the index of currentCard and place the
           current card at the index of the random card
        -by completing this process throughout the 52 cards, the deck will be
            shuffled
 * After the deck is shuffled, set top to 0,
 *   this will ensure top is reset during consecutive hands/rounds.
 */
    public void shuffle(){
        //shuffle the deck here
        Card placeholder;
        for (int currentCard=0; currentCard<52; currentCard++){
            int random= (int) (Math.random()*cards.length);
            placeholder=cards[currentCard];
            cards[currentCard]=cards[random];
            cards[random]=placeholder;   
        }
        top=0;
    }
    
    
/* METHOD PURPOSE:   
 * This method is uses to deal one card from the "cards" array.
 * This method takes in no arguments and returns a Card object.
 * The returned Card object is the card at index [top] from array "cards".
 * The index "top" will be incremented each time deal() is called.
 */    
    public Card deal(){
        // deal a single cared here
        //the top card of the deck will be the subsequent card index,
           // going from 0 to 52.
        return cards[top++];
    }
}
