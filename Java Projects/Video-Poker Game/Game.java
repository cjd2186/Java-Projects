/**
 * This class represents a game of Video Poker.
 * 
//******************************************
// Game.java 
// Written by Christopher Demirjian
// cjd2186
//*******************************************
 *
 * The Game class is used to represent a game of Video Poker.
 */

//import needed Java packages.
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Game {

/* Declare instance variables as follows:
 *   p: an object of type Player representing the Player of video poker.
 *   cards: an object of type Deck representing the deck of 52 cards.
 *   hand: an arrayList of type Card representing the player's hand of 5 cards.
 *   input: an object of type Scanner used to take in and store user input.
 *   odds: an int used to calculate the payout for a winning hand.
 *   rank: a String used to store the Enlish name for each hand ranking.
 *   again: stores boolean value regarding if user wants to play another round.
 *   rankZeroOne: boolean equals true if cards at indeces 0 and 1 in hand
 *     have the same rank. This variable is used when checking ranks.
 *   rankOneTwo: boolean equals true if cards at indeces 1 and 2 in hand
 *     have the same rank. This variable is used when checking ranks.
 *   rankTwoThree: boolean equals true if cards at indeces 2 and 3 in hand
 *     have the same rank. This variable is used when checking ranks.
 *   rankThreeFour: boolean equals true if cards at indeces 3 and 4 in hand
 *     have the same rank. This variable is used when checking ranks.
 */         
    private Player p;
    private Deck cards;
    private ArrayList<Card> hand;
    private Scanner input;
    private int odds;
    private String rank;
    private boolean again;
  	private boolean rankZeroOne;
    private boolean rankOneTwo;
    private boolean rankTwoThree;
    private boolean rankThreeFour;


/* CONSTRUCTOR PURPOSE:   
 * This is one constructor that instantiates a hand of Video Poker.
 * This constructor is used to purely test the rank of a hand as passed through
 *   a command line argument, not to play a game of Video Poker (ie, no bets).
 * This constructor takes in an array of Strings testHand, as 
 *   passed from the commandline argument array "args", from PokerTest.java.
 * 
 * The constructor instantiates instance variables as follows:
     p is initialized to an object of the Player class.
     hand is initialized to an empty arrayList.
     rank is initialized to "High Card".
       (the lowest rank of a hand is High Card)
     testHandArray is declared as an array of String,
       and is initialized to testHand.
     rankZeroOne is set to false
     rankOneTwo is set to false
     rankTwoThree is set to false
     rankThreeFour is set to false
 * The createTestHand(String[] testHand) is then called to
 *   populate the hand arrayList.
 */    
    // This constructor is to help test your code.
    // use the contents of testHand to
    // make a hand for the player
    // you must use the following encoding for cards
    // c = clubs
    // d = diamonds
    // h = hearts
    // s = spades
    // 1-13 correspond to ace-king
    // example: s1 = ace of spades
    // example: testhand = {s1, s13, s12, s11, s10} = royal flush    
    public Game(String[] testHand){
        p = new Player();
        hand= new ArrayList<>();
        rank="High Card";
        rankZeroOne=false;
        rankOneTwo=false;
        rankTwoThree=false;
        rankThreeFour=false;

        //create the test Hand
        //iterate through each card in the test hand
        String [] testHandArray= testHand;
        createTestHand(testHandArray);
    }

/* CONSTRUCTOR PURPOSE:   
 * This is one constructor that instantiates an interactive game of Video Poker.
 * This constructors takes in no arguments.
 * 
 * The constructor instantiates instance variables as follows:
     p is initialized to an object of the Player class.
     cards is initialized to an object of the Deck class.
     hand is initialized to an empty arrayList.
     input is initialized to an object of Scanner that reads from System.in.
     odds is initialized to zero.
     rank is initialized to "High Card".
       (the lowest rank of a hand is High Card).
     again is initialized to true (user will be asked to play again).
     rankZeroOne is set to false.
     rankOneTwo is set to false.
     rankTwoThree is set to false.
     rankThreeFour is set to false.
*/   	
    public Game(){
        p = new Player();
        //create a deck of cards
        cards= new Deck();
        hand= new ArrayList<>();
        input= new Scanner(System.in);
        odds=0;
        rank="High Card";
        again=true;
        rankZeroOne=false;
        rankOneTwo=false;
        rankTwoThree=false;
        rankThreeFour=false;
        // This no-argument constructor is to actually play a normal game
    }

/* METHOD PURPOSE:   
 * This method is used to play an interactive game of Video Poker.
 * This method does not take in any arguments and has no return.
 * 
 * This method starts by greeting the user.
 * userBets is then called to deduct the User's bet from their bankroll
 * The shuffle() method is called on "cards" deck to shuffle the Deck of cards.
 * Five cards from the "cards" Deck are dealt to the Player's hand using
 *   a for-loop and the cards.deal() method.
 * The Player's hand is then sorted using the sort() helper method.
 * Call sortHigh() properly place Ace High at end of hand  if hand highStraight.
 * Call showHand() to print the player's hand to the user.
 * exchangeCards() is then called to prompt the user to exchange unwanted
 *   cards from their hand for new cards from the Deck.
 * The Player's hand is sorted once again.
 * The checkHand() method is called to evaluate the Player's hand, outputting
 *   the odds of the hand's rank, which is stored into the int "odds".
 *     checkHand() also changes the value of "rank", allowing the rank of the
 *       user's hand to be printed to the console.
 * Call sortHigh() properly place Ace High at end of hand if hand highStraight.
 * Call showHand() to print the player's hand to the user
 * userWins() is then called to add the User's winnings to their bankroll.
 * call resetVars() to create a new hand, a new deck, and to reset rank to 
 *   "High Card" and reset odds to 0.
 * playAgain() is called to ask user if they want to play again.
 * After the greeting is printed, the proceeding methods are put into a while-
    -loop to allow for multiple games to be played in succession.
 */    
    public void play(){
        System.out.println("Welcome to Video Poker!");
        
        while (again==true){
            userBets(); 
            cards.shuffle();
            //deal cards to the user's Hand
            for (int cardInput=0; cardInput<5; cardInput++){
                hand.add(cards.deal());
            }
            System.out.println("Cards have been dealt");
            sort();
            //call sortHigh properly place Ace High at end of hand
            sortHigh();
            showHand(); 
            exchangeCards();
            sort();
            //call checkHand to evaluate the rank of the User's hand and return odds
            odds=checkHand();
            sortHigh();
            System.out.println("Your new hand is:");
            showHand();
            System.out.println("Your hand is rank: " + rank);
            userWins();
            //reset the variables to play another hand
            resetVars();
            playAgain();
        }
        // this method should play the game	
    }
    
    
/* METHOD PURPOSE:   
 * This helper method evaluates is used to populate the player hand using the
 *   cards as submitted in the commandline arguments.
 * This method takes in the array of Strings "testHand" as an argument
 *  and has no returns.
 * Each element in the testHand array is iterated using a for loop.
 * The first character of each element is a letter representing the card's
 *   suit, therefore it can be checked against the character 'c','d','h','s'
 *     in order to assign the value of s accordingly.
 * The second (or third) character of each element is a number representing
 *   the card's rank, therefore it can be used to assign the value of rank.
 * The values of suit and rank are passed to create a new Card(s,r) object,
 *   which is added to the arrayList "hand".
 */     
    private void createTestHand(String[] testHand){
        int s=0, r=0;
        for (int cardInput=0; cardInput<5; cardInput++){
            //check the suit of each card in the testHand array
            //check each character in input and assign to its int suit
            if (testHand[cardInput].charAt(0)=='c'){
                s=1;
            }
            if (testHand[cardInput].charAt(0)=='d'){
                s=2;
            }
            if (testHand[cardInput].charAt(0)=='h'){
                s=3;
            }
            if (testHand[cardInput].charAt(0)=='s'){
                s=4;
            }
            //check the rank of each card in the testHand array
            r=Integer.parseInt(
                testHand[cardInput].substring(1, testHand[cardInput].length()));
            
            //add each card in testHand to the hand arrayList
            hand.add(new Card (s,r));
        }
    }

    
/* METHOD PURPOSE:   
 * This method evaluates is used to check the rank of the player's hand,
 *   as submitted in the commandline arguments.
 * This method takes in no arguments and has no returns.
 * The player's hand is first sorted using the sort() method.
 * The checkHand() method is called to evaluate the Player's hand, outputting
 *   the odds of the hand's rank, which is stored into the int "odds".
 *     checkHand() also changes the value of "rank", allowing the rank of the
 *       user's hand to be printed to the console.
 * Call sortHigh() properly place Ace High at end of hand if hand highStraight.
 * Call showHand() to print the player's hand to the user.
 */    
    public void testPlay(){
        // this method is used for testing the checkHand method
        // it should evaluate the hand that was passed
        // as a command-line argument and print the result
        sort();
        
        //call checkHand to evaluate the rank of the User's hand and mutate rank
        checkHand();
        //move ace to back if hand is highStraight
        sortHigh();
        showHand();
        System.out.println("Your hand is rank: " + rank);
        System.out.println("End Test Hand. Goodbye.");
    }
    
    
/* METHOD PURPOSE:   
 * This helper method prints the player's hand to the User.
 * This method takes in no arguments and no return.
 * The Player's hand is then printed to them using a for-loop to print
 *   each element in the "hand" arrayList.
 */
    private void showHand(){
        for (int cardInput=0; cardInput<5; cardInput++){
            System.out.println("Card " + (cardInput+1)+ ": "+
                               hand.get(cardInput));
        } 
    }
    
    
/* METHOD PURPOSE:   
 * This helper method resets variables to allow for consecutive games to be 
 *   played.
 * This method takes in no arguments and no return.
 */
    private void resetVars(){
        //empty the user's hand by making a new hand
        hand= new ArrayList<>();
        //create a new deck
        cards= new Deck();
        //reset rank to "High Card"
        rank="High Card";
        //reset odds to zero
        odds=0;
    }
    
    
/* METHOD PURPOSE:   
 * This method evaluates the rank of the player's hand.
 * This method takes in no arguments, changes the value of "rank"
 *   and returns the int value of "odds".
 * 
 * Nine helper methods are called, each of which output a boolean. 
 * If the boolean is true, the hand is the rank of the method which was called
 *   and the rank and odds variables are changed accordingly.
 * 
 * The helper methods for the nine ranks are as follows:
 *   royalFlush()_____odds:250
 *   straightFlush()__odds:50
 *   fourKind()_______odds:25
 *   fullHouse()______odds:6
 *   flush()__________odds:5
 *   straight()_______odds:4
 *   threeKind()______odds:3
 *   twoPair()________odds:2
 *   pair()___________odds:1
 * If a hand is none of these ranks, it is of rank "High Card", with odds of 0,
 *   which is initialized in the constructors.
 */  	
	public int checkHand(){
		// evaluate the hand
		// print the result to the console so the user can see it. 
        // return the multiplier that the bet should be multiplied by
        // you'll want to break this up into a bunch of helper methods  
        if (royalFlush()==true){
            rank="Royal Flush";
            odds=250;
            return odds;
        }
        if (straightFlush()==true){
            rank="Straight Flush";
            odds=50;
            return odds;
        }
        if (fourKind()==true){
            rank="Four of a Kind";
            odds=25;
            return odds;
        }
        if (fullHouse()==true){
            rank="Full House";
            odds=6;
            return odds;
        }
        if (flush()==true){
            rank="Flush";
            odds=5;
            return odds;
        }
        if (straight()==true){
            rank="Straight";
            odds=4;
            return odds;
        }
        if (threeKind()==true){
            rank="Three of a Kind";
            odds=3;
            return odds;
        }
        if (twoPair()==true){
            rank="Two Pair";
            odds=2;
            return odds;
        }
        if (pair()==true){
            rank="Pair";
            odds=1;
            return odds;
        }
        //odds is already set to 0, so no need for else statement
		return odds;
    }
    
    
/* METHOD PURPOSE:   
 * This helper method deduct the amount of tokens bet by player from their 
 *   bankroll.
 * This method takes in no arguments and has no return.
 * The player's bankroll is displayed to the console using 
 *   the p.getBankroll() method.
 * The User is then prompted to input a bet between 1 and 5 tokens.
 * This user input (bet) is stored into the variable userBets.
 * If the user's bet is less than 1 or greater than 5, 
 *   the user will be prompted to re-input their bet.
 * userBets is then passed into the method p.bet(int amt) to deduct the 
 *   user's bet from their bankroll.
 * The player's bankroll is once again displayed to the console using 
 *   the p.getBankroll() method.
 */      
    private void userBets(){
        int userBets=0;
        //notify the user of their current bankroll
        System.out.println("Your current bankroll is: " + p.getBankroll());
                
        //Prompt User to bet (“Bet 1 to 5 tokens”)
        System.out.println("Input a bet of 1-5 tokens (inclusive):");
        
        //store user's bet input into userBets
        userBets=input.nextInt();
        
        //if user does not input an int between 1-5 (inclusive)
        //  have user put in another input
        while(userBets>5 || userBets<1){
            System.out.println("Please input a value of 1-5 (inclusive):");
            userBets=input.nextInt();
        }
        //pass user bet into Player p's bets(int amt)
        //p.bets(int amt) deducts User's bet from p's bankroll
        p.bets(userBets);
        
        //notify the user of their current bankroll
        System.out.println("Your current bankroll is: " + p.getBankroll());
    }

    
/* METHOD PURPOSE:   
 * This helper method adds the amount of tokens won by the player to their 
 *   bankroll.
 * This method takes in no arguments and has no return.
 * The checkHand() method is called to return the value "odds", which is stored
 *   into the variable odds.
 * The variable odds is passed into the winnings(int odds) method in the Player
 *   class, which adds the product of odds and bet to the player's bankroll.
 * The player's winning is retried using p.getWinnings(odds), and is stored into
 *   the variable winnings.
 * The player's winnings and bankroll are displayed to the console using the 
 *   variable winnings and the p.getBankroll() method.
 */          
    private void userWins(){
        int winnings;
        //call checkHand() method to get odds
        odds=checkHand();
        
        //pass odds into Player p's winnings(odds)
        //p.winnings(odds) adds the product of odds and bet to the bankroll
        p.winnings(odds);
        
        //retrieve the user's winnings, print to user
        winnings=p.getWinnings(odds);
        System.out.println("You won: "+ winnings+ " tokens!");
        
        //notify the user of their current bankroll
        System.out.println("Your new bankroll is: " + p.getBankroll());
    }
    
    
/* METHOD PURPOSE:   
 * This helper method exchanges the cards in the player's hand based on user 
 *   input.
 * This method takes in no arguments and has no return.
 * The User is prompted to input "Y/N" 5 times, if they want to keep any of 
 *   the 5 cards in their hand.
 * If the User inputs "N" or "n", a new card is dealt in place of the card they
 *   wish to exchange in their hand.
 */      
    private void exchangeCards(){
        String exInput="null";

        System.out.println("Do you want to keep card 1? (Y/N)");
        exInput=input.next();
        if(exInput.toUpperCase().equals("N")){
            hand.set(0, cards.deal());
        }
        System.out.println("Do you want to keep card 2? (Y/N)");
        exInput=input.next();
        if(exInput.toUpperCase().equals("N")){
            hand.set(1, cards.deal());
        }
        System.out.println("Do you want to keep card 3? (Y/N)");
        exInput=input.next();
        if(exInput.toUpperCase().equals("N")){
            hand.set(2, cards.deal());
        }
        System.out.println("Do you want to keep card 4? (Y/N)");
        exInput=input.next();
        if(exInput.toUpperCase().equals("N")){
            hand.set(3, cards.deal());
        }
        System.out.println("Do you want to keep card 5? (Y/N)");
        exInput=input.next();
        if(exInput.toUpperCase().equals("N")){
            hand.set(4, cards.deal());
        }
    }


/* METHOD PURPOSE:   
 * This helper method is used to sort the player's hand arrayList.
 * This method takes in no arguments and has no return.
 * The sort() method of the Collection package is used to sort the hand.
 */     
    private void sort()
    {	
	    Collections.sort(hand);
    }
    
    
/* METHOD PURPOSE:   
 * This helper method is used to sort the player's hand arrayList if their hand
 *   is a highStraight.
 * This method takes in no arguments and has no return.
 * If the hand has the cards of a highStraight, the first card(the Ace)
 *   is taken out of the hand and placed at the end of it.
 */     
    private void sortHigh(){
        if(highStraight()==true){
            Card aceHolder;
            aceHolder=hand.get(0);
            hand.remove(0);
            hand.add(aceHolder);
        }
    }
    
/* METHOD PURPOSE:   
 * This helper method asks the user if they would like to play again. Input of 
 *   user is lowercased and compared to the strings "yes" and "no" to determine
 *     whether the user wants to play another game.
 * If the user inputs "no", again is set to false, a goodbye statement is
 *   printed and the game ends.
 * rematch: scanner to take in input from user
     -initalize rematch as new instance of Scanner class
 * play_more: String used to store user input "yes" or "no";
     -initalize play_more as "null" (user has not decided to play more yet)
 */    
    private void playAgain(){
        String play_more="null";
        Scanner rematch = new Scanner(System.in);
        //print to ask the user if they would like to play again
        System.out.println("Do you want to play again? Enter yes or no");
        play_more=rematch.nextLine();
        play_more=play_more.toLowerCase();
        if (play_more.equals("no")){
            again=false;
            //print goodbye statement
            System.out.println("Good Game, Goodbye!");
        }
    }


/* METHOD PURPOSE:   
 * This helper method is used to check if player's hand is rank "royalFlush".
 * This method takes in no arguments and returns boolean value of royalFlush.
 * royalFlush is initialized as false and is changed to true if the hand is 
 *   of rank royalFlush. 
 * If the hand is a flush (flush is true) and if each card in the hand equals
 *   rank 1, rank 10, rank 11, rank 12 and rank 13, royalFlush is set to true.
 */     
    private boolean royalFlush(){
        boolean royalFlush=false;
  
        if (flush()==true){
            if(highStraight()==true){
                royalFlush=true;
            }
        }
        return royalFlush;
    }

/* METHOD PURPOSE:   
 * This helper method is used to check if player's hand is rank "highStraight"
 * This method takes in no arguments and returns boolean value of highStraight.
 * highStraight is initialized as false and is changed to true if the hand is 
 *   of rank highStraight. 
 * If each card in the hand equals rank 1, rank 10, rank 11, rank 12 and rank 13
 *   highStraight is set to true.
 * This method is used to handle the special case when an Ace
 *   is valued at Ace high, as if it has a value of "14" (one above a king).
 */          
    private boolean highStraight(){
        boolean highStraight=false;
        
        if(hand.get(0).getRank()==1){
            if(hand.get(1).getRank()==10){
                if(hand.get(2).getRank()==11){
                    if(hand.get(3).getRank()==12){
                        if(hand.get(4).getRank()==13){
                            highStraight=true;
                        }
                    }
                }
            }
        }
        return highStraight;
    }
    
        
/* METHOD PURPOSE:   
 * This helper method is used to check if player's hand is rank "straightFlush".
 * This method takes in no arguments and returns boolean value of straightFlush.
 * straightFlush is initialized as false and is changed to true if the hand is 
 *   of rank straightFlush. 
 * If the hand is a flush (flush is true) and if each card subsequent to card[0]
 *  is one greater in rank than the last, straight is set to true.
 */     
    private boolean straightFlush(){
        boolean straightFlush=false;
        if (flush()==true){
            if(straight()==true){
                straightFlush=true;
            }
        }
        return straightFlush;
    }
    
    
/* METHOD PURPOSE:   
 * This helper method is used to check if the player's hand is rank "fourKind".
 * This method takes in no arguments and returns the boolean value of fourKind.
 * threeKind is initialized as false and is changed to true if the hand is 
 *   of rank fourKind. 
 * To check if hand is threeKind, the ranks of each card (index 0-4)are checked
 *   for equivalence. If there are four cards have the same rank, fourKind
 *     is set to true.
 */      
    private boolean fourKind(){
        boolean fourKind=false;
        //updates values of rank pairings booleans
        checkRanks();
        
        if(rankZeroOne && rankOneTwo && rankTwoThree){
            fourKind=true;
        }
        if(rankOneTwo && rankTwoThree && rankThreeFour){
            fourKind=true;
        }
        return fourKind;
    }

    
/* METHOD PURPOSE:   
 * This helper method is used to check if the player's hand is rank "fullHouse".
 * This method takes in no arguments and returns the boolean value of fullHouse.
 * fullHouse is initialized as false and is changed to true if the hand is 
 *   of rank fullHouse. 
 * To check if the hand is a fullHouse, the ranks of each card (index 0-4)are
 *   checked for equivalence. If there are three cards of the same rank, 
 *     and the other two cards are the same rank, fullHouse is set to true.
 */     
    private boolean fullHouse(){
        boolean fullHouse=false;
        //updates values of rank pairings booleans
        checkRanks();
        
        if(rankZeroOne && rankOneTwo){
            if (rankThreeFour){
                fullHouse=true;
            }
        }        
        if(rankTwoThree && rankThreeFour){
            if (rankZeroOne){
                fullHouse=true;
            }
        }
        return fullHouse;
    }

    
/* METHOD PURPOSE:   
 * This helper method is used to check if the player's hand is rank "flush".
 * This method takes in no arguments and returns the boolean value of flush.
 * flush is initialized as false and is changed to true if the hand is 
 *   of rank flush. 
 * To check if the hand is flush, the suits of each card (index 0-4)are checked
 *   for equivalence. If each card has the same suit, flush is set to true.
 */           
    private boolean flush(){
        boolean flush=false;
        
        // rankZeroOne true if cards[0] and cards[1] have the same suit.
        boolean suitZeroOne=hand.get(0).getSuit()==hand.get(1).getSuit();
        boolean suitOneTwo=hand.get(1).getSuit()==hand.get(2).getSuit();
        boolean suitTwoThree=hand.get(2).getSuit()==hand.get(3).getSuit();
        boolean suitThreeFour=hand.get(3).getSuit()==hand.get(4).getSuit();
       
        if(suitZeroOne && suitOneTwo && suitTwoThree && suitThreeFour){
            flush=true;
        }
        return flush;
    }
    
    
/* METHOD PURPOSE:   
 * This helper method is used to check if the player's hand is rank "straight".
 * This method takes in no arguments and returns the boolean value of straight.
 * straight is initialized as false and is changed to true if the hand is 
 *   of rank straight. 
 * If each card subsequent to card[0] is one greater in rank than the last, 
 *   straight is set to true.
 */              
    private boolean straight(){
        boolean straight=false;
        //********************************************FIX ACEE***********************
        if(hand.get(1).getRank()==hand.get(0).getRank()+1){
            if(hand.get(2).getRank()==hand.get(1).getRank()+1){
                if(hand.get(3).getRank()==hand.get(2).getRank()+1){
                    if(hand.get(4).getRank()==hand.get(3).getRank()+1){
                        straight=true;
                    }
                }
            }
        }
        if(highStraight()==true){
            straight=true;
        }
        return straight;
    }
    
    
/* METHOD PURPOSE:   
 * This helper method is used to check if the player's hand is rank "threeKind".
 * This method takes in no arguments and returns the boolean value of threeKind.
 * threeKind is initialized as false and is changed to true if the hand is 
 *   of rank threeKind. 
 * To check if hand is threeKind, the ranks of each card (index 0-4)are checked
 *   for equivalence. If there are three cards have the same rank, threeKind
 *     is set to true.
 */            
    private boolean threeKind(){
        boolean threeKind=false;
        //updates values of rank pairings booleans
        checkRanks();
        
        if(rankZeroOne && rankOneTwo){
            threeKind=true;
        }        
        if(rankOneTwo && rankTwoThree){
            threeKind=true;
        }
        if(rankTwoThree && rankThreeFour){
            threeKind=true;
        }
        return threeKind;
    }
    
    
/* METHOD PURPOSE:   
 * This helper method is used to check if the player's hand is rank "twoPair".
 * This method takes in no arguments and returns the boolean value of twoPair.
 * twoPair is initialized as false and is changed to true if the hand is 
 *   of rank twoPair. 
 * To check if hand is twoPair, the ranks of each card (index 0-4)are checked
 *   for equivalence. If there are two sets of card with the same rank, twoPair
 *     is set to true.
 */        
    private boolean twoPair(){
        boolean twoPair=false;
        //updates values of rank pairings booleans
        checkRanks();
        
        if(rankZeroOne && rankTwoThree){
            twoPair=true;
        }        
        if(rankOneTwo && rankThreeFour){
            twoPair=true;
        }
        if(rankZeroOne && rankThreeFour){
            twoPair=true;
        }
        return twoPair;
    }

    
/* METHOD PURPOSE:   
 * This helper method is used to check if the player's hand is rank "pair".
 * This method takes in no arguments and returns the boolean value of pair.
 * pair is initialized as false and is changed to true if the hand is 
 *   of rank pair. 
 * To check if the hand is a pair, the ranks of each card (index 0-4)are checked
 *   for equivalence.
 */    
    private boolean pair(){
        boolean pair=false;
        //updates values of rank pairings booleans
        checkRanks();
        
        if(rankZeroOne){
            pair=true;
        }        
        if(rankOneTwo){
            pair=true;
        }
        if(rankTwoThree){
            pair=true;
        }
        if(rankThreeFour){
            pair=true;
        }
        return pair;
    }
    
    
/* METHOD PURPOSE:   
 * This helper method is used to compare the ranks of adjacent cards within the 
 *   hand.
 * This method takes in no arguments and has no return.
 * The values of rankZeroOne, rankOneTwo, rankTwoThree and rankThreeFour are
 *   changed to true if adjacent cards at their respective indeces have the 
 *      same rank within the hand.
 */      
    private void checkRanks(){
        // rankZeroOne true if cards[0] and cards[1] have the same rank
        rankZeroOne=hand.get(0).getRank()==hand.get(1).getRank();
        rankOneTwo=hand.get(1).getRank()==hand.get(2).getRank();
        rankTwoThree=hand.get(2).getRank()==hand.get(3).getRank();
        rankThreeFour=hand.get(3).getRank()==hand.get(4).getRank();
    }
    
}
