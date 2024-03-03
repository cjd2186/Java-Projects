/**
 * This class represents the player in Video Poker.
 * 
//******************************************
// Player.java 
// Written by Christopher Demirjian
// cjd2186
//*******************************************
 *
 * The Player class is used to represent the player in Video Poker.
 */

public class Player {
/* Declare instance variables as follows:
 *   bankroll: int representing the amt of tokens the player has
 *   bet: int representing the amt of tokens the player bets each round
 *   winnings: the int amount of tokens won by the player each round (bet*odds)
 */  
    private int bankroll;
    private int bet;
    private int winnings;
/* CONSTRUCTOR PURPOSE:   
 * The Constructor takes no arguments and
     instantiates instance variables as follows:
       bankroll is initialized to 0.
         (bankroll will be negative if player loses tokens and bankroll is 0)
       bet is initialized to 0.
       winnings is initialized to 0.
*/    
    public Player(){		
        //create a player here
        bankroll=0;
        bet=0;
        winnings=0;
    }

    
/* METHOD PURPOSE:   
 * This method takes in int amt, and changes the value of bankroll.
 * bet is set to amt, and bet is deducted from the bankroll.
 */    
    public void bets(int amt){
        //player makes a bet
        bet=amt;
        bankroll-=bet;
    }

    
/* METHOD PURPOSE:   
 * This method takes in int odds, and changes the value of bankroll.
 * bet is multiplied by odds and is stored into winnings.
 * Winnings is added to the bankroll.
 */     
    public void winnings(int odds){
        //adjust bankroll if player wins
        winnings=bet*odds;
        bankroll+= winnings;
    }

    
/* METHOD PURPOSE:   
 * This method returns the integer value of bankroll.
 */       
    public int getBankroll(){
        //return current balance of bankroll
        return bankroll;
    }

    
/* METHOD PURPOSE:   
 * This method returns the integer value of winnings.
 */       
    public int getWinnings(){
        //return amount of tokens player won
        return winnings;
    }
}
