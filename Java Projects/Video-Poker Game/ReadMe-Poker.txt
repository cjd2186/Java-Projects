Name: Christopher Demirjian
UNI: cjd2186

===============================================================================
Interactive Game of Video Poker
===============================================================================
_______________________________________________________________________________
To play one interactive game of "Video Poker" the following classes are used:
	Card.java
	Player.java
	Deck.java
	Game.java
	PokerTester.java
_______________________________________________________________________________
PokerTest.java

BACKGROUND:
This class contains the main method that invokes and executes the Game class.
This version of "Video Poker" is played between the user and the computer through
  the terminal using the "Game.java" file.
In order to play the game, the "Game" class invokes:
 -the "Player" class to manage the player's bankroll
 -the "Deck" class to create, shuffle and deal cards from a 52 card deck
 -the "Card" class to create and compare {in order to sort} cards to be in deck

There are two ways to play the game:
  -interactive game between computer and player.
  -game purely meant to test hand as inputted in commandline arguments.
If commandline arguments are inputted in the main file invocation, the rank-
  testHand game will be executed. 
  Otherwise, a traditional, interactive game of Video Poker will be played.
_______________________________________________________________________________
Game.java
-------------------------------------------------------------------------------
BACKGROUND:
The Game class is used to play an interactive game of "Video Poker" 
This class also serves to play the solely check the rank of a poker hand when
 a hand of 5 cards is inputed using command line arguments.eg: s1 s1 s2 d10 h13
-------------------------------------------------------------------------------
INSTANCE VARIABLES:	
This class has 11 instance variables that are used have a global scope,
  accessible to the entire class.

Declare instance variables as follows:
  p: an object of type Player representing the Player of video poker.
  cards: an object of type Deck representing the deck of 52 cards.
  hand: an arrayList of type Card representing the player's hand of 5 cards.
  input: an object of type Scanner used to take in and store user input.
  odds: an int used to calculate the payout for a winning hand.
  rank: a String used to store the Enlish name for each hand ranking.
  again: stores boolean value regarding if user wants to play another round.
  rankZeroOne: boolean equals true if cards at indeces 0 and 1 in hand
     have the same rank. This variable is used when checking ranks.
   rankOneTwo: boolean equals true if cards at indeces 1 and 2 in hand
     have the same rank. This variable is used when checking ranks.
   rankTwoThree: boolean equals true if cards at indeces 2 and 3 in hand
     have the same rank. This variable is used when checking ranks.
   rankThreeFour: boolean equals true if cards at indeces 3 and 4 in hand
     have the same rank. This variable is used when checking ranks.         
-------------------------------------------------------------------------------
CONSTRUCTOR: Game()

CONSTRUCTOR PURPOSE:   
This is one constructor that instantiates an interactive game of Video Poker.
This constructors takes in no arguments.
 
The constructor instantiates instance variables as follows:
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
-------------------------------------------------------------------------------
MUTATOR METHODS:

METHOD: play()

METHOD PURPOSE:   
 This method is used to play an interactive game of Video Poker.
 This method does not take in any arguments and has no return.
 
 This method starts by greeting the user.
 userBets is then called to deduct the User's bet from their bankroll
 The shuffle() method is called on "cards" deck to shuffle the Deck of cards.
 Five cards from the "cards" Deck are dealt to the Player's hand using
   a for-loop and the cards.deal() method.
 The Player's hand is then sorted using the sort() helper method.
 Call sortHigh() properly place Ace High at end of hand  if hand highStraight.
 Call showHand() to print the player's hand to the user.
 exchangeCards() is then called to prompt the user to exchange unwanted
   cards from their hand for new cards from the Deck.
 The Player's hand is sorted once again.
 The checkHand() method is called to evaluate the Player's hand, outputting
   the odds of the hand's rank, which is stored into the int "odds".
     checkHand() also changes the value of "rank", allowing the rank of the
       user's hand to be printed to the console.
 Call sortHigh() properly place Ace High at end of hand if hand highStraight.
 Call showHand() to print the player's hand to the user
 userWins() is then called to add the User's winnings to their bankroll.
 call resetVars() to create a new hand, a new deck, and to reset rank to 
   "High Card" and reset odds to 0.
 playAgain() is called to ask user if they want to play again.
 After the greeting is printed, the proceeding methods are put into a while-
  -loop to allow for multiple games to be played in succession. 

LOGIC:
To make the class more organized, each chunk of code is divided into specific
  methods, making the class concised and organized.
Each method is invoked in the play() method, as the play() method is called in
  the main method of the PokerTest.java file.
-------------------------------------------------------------------------------
ACCESSOR METHODS

METHOD: checkHand()

METHOD PURPOSE:   
This method evaluates the rank of the player's hand.
This method takes in no arguments, changes the value of "rank"
  and returns the int value of "odds".

Nine helper methods are called, each of which output a boolean. 
If the boolean is true, the hand is the rank of the method which was called
  and the rank and odds variables are changed accordingly.
 
The helper methods for the nine ranks are as follows:
  royalFlush()_____odds:250
  straightFlush()__odds:50
  fourKind()_______odds:25
  fullHouse()______odds:6
  flush()__________odds:5
  straight()_______odds:4
  threeKind()______odds:3
  twoPair()________odds:2
  pair()___________odds:1
If a hand is none of these ranks, it is of rank "High Card", with odds of 0,
  which is initialized in the constructors.

LOGIC:
This method checks if the hand arrayList is any of the 9 ranks, checking the
  highest ranking hands first.
Therefore, when each rank is checked, it is known that it cannot be a higher
  rank than what it is being checked.
When a hand's rank is identified, the value of "rank" is changed as is the 
  value of "odds" to reflect the rank and odds of that hand. 
Additionally, the hand is already sorted, making it easier to evaluate a hand.
-------------------------------------------------------------------------------
HELPER METHODS

METHOD: showHand()

METHOD PURPOSE:   
This helper method prints the player's hand to the User.
This method takes in no arguments and no return.
The Player's hand is then printed to them using a for-loop to print
  each element in the "hand" arrayList.

LOGIC:
This helper method is used to print the hand to the user. 
The hand is printed multiple times, warranting a helper method to be used. 
...............................................................................
METHOD: resetVars()

METHOD PURPOSE:   
 This helper method resets variables to allow for consecutive games to be 
   played.
 This method takes in no arguments and no return.

LOGIC:
In order to play multiple hands/rounds of Video Poker, a new hand and a new 
  deck must be created each round. The rank and odds must be reset to what
    they were instantiated to as well.
...............................................................................
METHOD: userBets()

METHOD PURPOSE:   
This helper method deduct the amount of tokens bet by player from their 
  bankroll.
This method takes in no arguments and has no return.
The player's bankroll is displayed to the console using 
  the p.getBankroll() method.
The User is then prompted to input a bet between 1 and 5 tokens.
This user input (bet) is stored into the variable userBets.
If the user's bet is less than 1 or greater than 5, 
  the user will be prompted to re-input their bet.
userBets is then passed into the method p.bet(int amt) to deduct the 
  user's bet from their bankroll.
The player's bankroll is once again displayed to the console using 
  the p.getBankroll() method.

LOGIC:
In order to make the program more clear and organized, every method and action
  associated with betting is managed within this helper method.
userBets serves to deduct bet inputted by the User from their Player bankroll.
...............................................................................
METHOD: userWins()

METHOD PURPOSE:   
This helper method adds the amount of tokens won by the player to their 
  bankroll.
This method takes in no arguments and has no return.
The checkHand() method is called to return the value "odds", which is stored
  into the variable odds.
The variable odds is passed into the winnings(int odds) method in the Player
 class, which adds the product of odds and bet to the player's bankroll.
The player's winning is retried using p.getWinnings(odds), and is stored into
  the variable winnings.
The player's winnings and bankroll are displayed to the console using the 
  variable winnings and the p.getBankroll() method.

LOGIC:
In order to make the program more clear and organized, every method and action
  associated with winning tokens is managed within this helper method.
userWins serves to add the bet*odds to the Player Bankroll.
...............................................................................
METHOD: exchangeCards()

METHOD PURPOSE:   
This helper method exchanges the cards in the player's hand based on user 
  input.
This method takes in no arguments and has no return.
The User is prompted to input "Y/N" 5 times, if they want to keep any of 
  the 5 cards in their hand.
If the User inputs "N" or "n", a new card is dealt in place of the card they
  wish to exchange in their hand.

LOGIC:
This method serves to exchange cards from the user's hand for new cards dealt
  from the card at index "top" from the "cards" deck.
...............................................................................
METHOD: sort()

METHOD PURPOSE:   
This helper method is used to sort the player's hand arrayList.
This method takes in no arguments and has no return.
The sort() method of the Collection package is used to sort the hand.

LOGIC:
This method is to be used in conjunction with the compareTo() method of the
  Card class, which uses the comparable interface.
This combination of methods [sort() and compareTo()] allows for the cards in
  hand to be sorted based on ascending rank and suit from left to right/
    top to bottom. 
...............................................................................
METHOD: sortHigh()

METHOD PURPOSE:   
This helper method is used to sort the player's hand arrayList if their hand
   is a highStraight.
This method takes in no arguments and has no return.
If the hand has the cards of a highStraight, the first card(the Ace)
 is taken out of the hand and placed at the end of it.

LOGIC:
When the hand is a highStraight, the Ace will appear as the lowest ranking card
  using the sort() method. In, and only in, a highStraight, the Ace will become
    the highest ranking card, therefore it must be moved to the end of the hand.
To move the Ace to the end of the hand, it is removed from the arrayList, and 
  then added back onto the end of the list.
...............................................................................
METHOD: checkRanks()

METHOD PURPOSE:   
This helper method is used to compare the ranks of adjacent cards within the 
  hand.
This method takes in no arguments and has no return.
The values of rankZeroOne, rankOneTwo, rankTwoThree and rankThreeFour are
  changed to true if adjacent cards at their respective indeces have the 
     same rank within the hand.

LOGIC:
In order to make it easier to compare cards within the hand by rank, four 
  boolean variables are used to check if 4 sets of two adjacent cards have the
   same rank, respectively.
If two adjacent cards have the same rank, they are a pair, and the rank
  variable is set to true.
To make these variables easier to read, they are named after their index 
  in hand.
...............................................................................
METHOD: playAgain()

METHOD PURPOSE:   
This helper method asks the user if they would like to play again. The input of 
 the user is lowercased and compared to the strings "yes" and "no" to determine
   whether the user wants to play another game.
If the user inputs "no", again is set to false, a goodbye statement is
 printed and the game ends.
 
rematch: scanner to take in input from user
 -initalize rematch as new instance of Scanner class
play_more: String used to store user input "yes" or "no";
 -initalize play_more as "null" (user has not decided to play more yet)

LOGIC:
The user is prompted to input if they would like to play again, inputting
  "yes" or "no" into the terminal.
The user input is then converted into lowercase letters and compared with
  "no" for equality. 
The variable "again" was initialized to true in the constructor, assuming
 (the user would always want to play again), therefore the value of "again"
 is only mutated if the user wants to stop playing, in which case a Goodbye
 statement is printed as well.
Otherwise, the user inputs "yes" and plays the game again, inputting their 
 move for the next round. 
...............................................................................
METHOD: royalFlush()

METHOD PURPOSE:   
This helper method is used to check if player's hand is rank "royalFlush".
This method takes in no arguments and returns boolean value of royalFlush.
 royalFlush is initialized as false and is changed to true if the hand is 
   of rank royalFlush. 
If the hand is a flush (flush is true) and if each card in the hand equals
  rank 1, rank 10, rank 11, rank 12 and rank 13, royalFlush is set to true.

LOGIC:   
If a hand is both a flush and a highStraight, it is a royalFlush.
...............................................................................
METHOD: highStraight()

METHOD PURPOSE:   
This helper method is used to check if player's hand is rank "highStraight"
This method takes in no arguments and returns boolean value of highStraight.
 highStraight is initialized as false and is changed to true if the hand is 
   of rank highStraight. 
If each card in the hand equals rank 1, rank 10, rank 11, rank 12 and rank 13
  highStraight is set to true.
This method is used to handle the special case when an Ace
  is valued at Ace high, as if it has a value of "14" (one above a king).

LOGIC:
A highStraight is only a straight of Ace, ten, jack, queen, king. Therefore,
  if a hand has these five cards, it is a highStraight.
...............................................................................
METHOD: straightFlush()

METHOD PURPOSE:   
This helper method is used to check if player's hand is rank "straightFlush".
This method takes in no arguments and returns boolean value of straightFlush.
 straightFlush is initialized as false and is changed to true if the hand is 
  of rank straightFlush. 
If the hand is a flush (flush is true) and if each card subsequent to card[0]
 is one greater in rank than the last, straight is set to true.

Logic:               
If hand is a flush, and a straight, the hand is a straighFlush.
..................................................................................
METHOD: fourKind()

METHOD PURPOSE:   
This helper method is used to check if the player's hand is rank "fourKind".
This method takes in no arguments and returns the boolean value of fourKind.
 threeKind is initialized as false and is changed to true if the hand is 
   of rank fourKind. 
To check if hand is threeKind, the ranks of each card (index 0-4)are checked
  for equivalence. If there are four cards have the same rank, fourKind
    is set to true.

LOGIC:
If four cards have the same rank, the hand is fourKind. 
If the following pairs of cards have the same rank, respectively (A and B), 
  (B and C), (C and D), then A B C D must all be the same rank.     
...............................................................................
METHOD: fullHouse()

METHOD PURPOSE:   
This helper method is used to check if the player's hand is rank "fullHouse".
This method takes in no arguments and returns the boolean value of fullHouse.
 fullHouse is initialized as false and is changed to true if the hand is 
  of rank fullHouse. 
To check if the hand is a fullHouse, the ranks of each card (index 0-4)are
  checked for equivalence. If there are three cards of the same rank, 
    and the other two cards are the same rank, fullHouse is set to true.

LOGIC:
A fullHouse must have threeKind and a pair. 
If the following pairs of cards have the same rank, respectively (A and B),
 (B and C) then A B C must all be the same rank. 
If another pair of cards of the same rank is a pair, the hand is a fullHouse.
...............................................................................
METHOD: flush()

METHOD PURPOSE:   
This helper method is used to check if the player's hand is rank "flush".
This method takes in no arguments and returns the boolean value of flush.
 flush is initialized as false and is changed to true if the hand is 
  of rank flush. 
To check if the hand is flush, the suits of each card (index 0-4)are checked
  for equivalence. If each card has the same suit, flush is set to true.      

LOGIC:
If five cards have the same suit, the hand is a flush. 
If the following pairs of cards have the same suit, respectively (A and B), 
  (B and C), (C and D), (D and E) then A B C D E must all be the same suit.    
...............................................................................
METHOD: straight()

METHOD PURPOSE:   
This helper method is used to check if the player's hand is rank "straight".
This method takes in no arguments and returns the boolean value of straight.
 straight is initialized as false and is changed to true if the hand is 
  of rank straight. 
If each card subsequent to card[0] is one greater in rank than the last, 
 straight is set to true.

LOGIC:
If each card in the hand is one greater than its previous card, the cards are
  in sequence, therefore the hand is a straight.
A highStraight is a special case that must be checked, as an Ace high is sorted
  as a value of 1, not 14, so it would not be recognized as one greater than a
    king. The highStraight() method is called to address this case.           
...............................................................................
METHOD: threeKind()

METHOD PURPOSE:   
This helper method is used to check if the player's hand is rank "threeKind".
This method takes in no arguments and returns the boolean value of threeKind.
 threeKind is initialized as false and is changed to true if the hand is 
   of rank threeKind. 
To check if hand is threeKind, the ranks of each card (index 0-4)are checked
 for equivalence. If there are three cards have the same rank, threeKind
  is set to true.

LOGIC:
If three cards have the same rank, the hand is threeKind. 
If the following pairs of cards have the same rank, respectively (A and B), 
  (B and C), then A B C must all be the same rank.
...............................................................................
METHOD: twoPair()

METHOD PURPOSE:   
This helper method is used to check if the player's hand is rank "twoPair".
This method takes in no arguments and returns the boolean value of twoPair.
 twoPair is initialized as false and is changed to true if the hand is 
   of rank twoPair. 
To check if hand is twoPair, the ranks of each card (index 0-4)are checked
  for equivalence. If there are two sets of card with the same rank, twoPair
    is set to true.

LOGIC:
If two pairs of cards have the same rank, respectively, the hand is twoPair.
If two of the rank boolean variables are true, the hand has two pairs.
...............................................................................
METHOD: pair()

METHOD PURPOSE:   
This helper method is used to check if the player's hand is rank "pair".
This method takes in no arguments and returns the boolean value of pair.
 pair is initialized as false and is changed to true if the hand is 
   of rank pair. 
To check if the hand is a pair, the ranks of each card (index 0-4)are checked
 for equivalence.

LOGIC:
If two cards have the same rank, the hand is a pair.
If any of the rank boolean variables are true, the hand has a pair.    
_______________________________________________________________________________
===============================================================================
Rank tester for testHand in Video Poker
===============================================================================
BACKGROUND:
Within the Game class, there is another, overloaded constructor, which calls
  an alternate "testPlay()" method to purely evaluate the rank of a testHand
    as inputted by through commandline argumetents. 
eg {s1, s13, s12, s11, s10} = royal flush
_______________________________________________________________________________
CONSTRUCTOR: Game(String[] testHand)
  The array of Strings "args" is passed into the constructor from PokerTest.
    This array contains the String commandLine arguments.

CONSTRUCTOR PURPOSE:   
This is one constructor that instantiates a hand of Video Poker.
This constructor is used to purely test the rank of a hand as passed through
  a command line argument, not to play a game of Video Poker (ie, no bets).
This constructor takes in an array of Strings testHand, as 
  passed from the commandline argument array "args", from PokerTest.java.

The constructor instantiates instance variables as follows:
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
The createTestHand(String[] testHand) is then called to
  populate the hand arrayList.
-------------------------------------------------------------------------------
MUTATOR METHODS:

METHOD: testPlay()

METHOD PURPOSE:   
This method evaluates is used to check the rank of the player's hand,
 as submitted in the commandline arguments.
This method takes in no arguments and has no returns.
The player's hand is first sorted using the sort() method.
The checkHand() method is called to evaluate the Player's hand, outputting
  the odds of the hand's rank, which is stored into the int "odds".
    checkHand() also changes the value of "rank", allowing the rank of the
      user's hand to be printed to the console.
Call sortHigh() properly place Ace High at end of hand if hand highStraight.
Call showHand() to print the player's hand to the user.

LOGIC:
To make the class more organized, each chunk of code is divided into specific
  methods, making the class concised and organized.
Each method is invoked in the testplay() method, as the testplay() method 
  is called in the main method of the PokerTest.java file.
No betting or winning related methods are called, as there is no betting in a 
  testHand game to check a hand's rank.
Furthermore, no cards are dealt or shuffled, as the hand is already created,
 therefore no Deck object is necessary.
-------------------------------------------------------------------------------
HELPER METHODS:

METHOD: createTestHand(String[] testHand)
  This method takes in an array of Strings.

METHOD PURPOSE:   
This helper method evaluates is used to populate the player hand using the
  cards as submitted in the commandline arguments.
This method takes in the array of Strings "testHand" as an argument
 and has no returns.
Each element in the testHand array is iterated using a for loop.
The first character of each element is a letter representing the card's
  suit, therefore it can be checked against the character 'c','d','h','s'
    in order to assign the value of s accordingly.
The second (or third) character of each element is a number representing
  the card's rank, therefore it can be used to assign the value of rank.
The values of suit and rank are passed to create a new Card(s,r) object,
  which is added to the arrayList "hand".

LOGIC:
The testHand array from "args" is passed into the overloaded Game constructor,
  which is then passed into this method as "testHand". 
Each element of "testHand" is checked for its suit and rank, in order to 
  construct the proper Card (s, r) object, which is added into the hand 
     arrayList.     
_______________________________________________________________________________
Player.java
-------------------------------------------------------------------------------
BACKGROUND:
The Player.java class is used to represent the player in Video Poker. This
  class primarily handles the bankroll of the player.
In order to play the game, the "Game" class invokes the Player class to
execute the methods associated with the Player.
-------------------------------------------------------------------------------
INSTANCE VARIABLES:
Declare instance variables as follows:
  bankroll: int representing the amt of tokens the player has
  bet: int representing the amt of tokens the player bets each round
  winnings: the int amount of tokens won by the player each round (bet*odds) 
-------------------------------------------------------------------------------
CONSTRUCTOR: Player()

CONSTRUCTOR PURPOSE:   
The Constructor takes no arguments and
  instantiates instance variables as follows:
    bankroll is initialized to 0.
      (bankroll will be negative if player loses tokens and bankroll is 0)
    bet is initialized to 0.
    winnings is initialized to 0.
-------------------------------------------------------------------------------
MUTATOR METHODS:

METHOD: bets(int amt)
  This method takes in an integer as an argument.

METHOD PURPOSE:   
This method takes in int amt, and changes the value of bankroll.
 bet is set to amt, and bet is deducted from the bankroll.
   
LOGIC:
The amount bet by the user is stored in the Game class, which is passed into
  the Player class through this method input.
The amount bet stored into the "bet" variable, and is deducted from bankroll.
...............................................................................
METHOD: winnings(int odds)
 This method takes in an integer as an argument.

METHOD PURPOSE:   
This method takes in int odds, and changes the value of bankroll.
 bet is multiplied by odds and is stored into winnings.
Winnings is added to the bankroll.

LOGIC:
The odds of the player's hand is found using Game's checkHand() and is 
  stored in the Game class, which is passed into the Player class through 
    this method input.
Odds is then multiplied by bet, and product (winnings) is added to bankroll, 
  increasing the bankroll by the amount of tokens the player won.
-------------------------------------------------------------------------------
ACCESSOR METHODS:

METHOD: getBankroll()

METHOD PURPOSE:   
This method returns the integer value of bankroll.
...............................................................................
METHOD: getWinnings()

METHOD PURPOSE:   
This method takes returns the integer value of winnings.
_______________________________________________________________________________
Deck.java
-------------------------------------------------------------------------------
BACKGROUND:
The Deck class is used to represent the deck of cards in Video Poker.
This class also contains methods used to manipulate the deck of cards.
-------------------------------------------------------------------------------
INSTANCE VARIABLES:

Declare instance variables as follows:
 cards: array of Card objects, representing a deck of cards.
 top: int representing the index of the top of the deck.
-------------------------------------------------------------------------------
CONSTRUCTOR: Deck()

CONSTRUCTOR PURPOSE:   
The Constructor takes no arguments and
 instantiates instance variables as follows:
  cards is initialized to array of 52 Card objects using a nested for-loop
   (every card in a 52 French-suit playing card deck).
  top is initialized to 0.
-------------------------------------------------------------------------------
MUTATOR METHODS:

METHOD: shuffle()

METHOD PURPOSE:   
This method takes no arguments and changes the Cards array,
 randomly changing the order of the each card within the Cards array.
 how to shuffle deck:
     -iterate through deck of cards (index 0-51)
     -make currentCard being iterated placeholder card (which will be moved)
     -find a random card in deck at a random index between 0 and 51
     -place the random card at the index of currentCard and place the
        current card at the index of the random card
     -by completing this process throughout the 52 cards, the deck will be
          shuffled
After the deck is shuffled, set top to 0,
  this will ensure top is reset during consecutive hands/rounds.

LOGIC:
 How to shuffle deck:
     -iterate through deck of cards (index 0-51)
     -make currentCard being iterated placeholder card (which will be moved)
     -find a random card in deck at a random index between 0 and 51
     -place the random card at the index of currentCard and place the
        current card at the index of the random card
     -by completing this process throughout the 52 cards, the deck will be
          shuffled
-------------------------------------------------------------------------------
ACCESSOR METHODS:

METHOD: deal()

METHOD PURPOSE:   
This method is uses to deal one card from the "cards" array.
This method takes in no arguments and returns a Card object.
The returned Card object is the card at index [top] from array "cards".
The index "top" will be incremented each time deal() is called.
  
LOGIC:
As each card in the deck is dealt, the "top" index counter will advance to
  the next card in the cards array, as top is incremented after each deal.
_______________________________________________________________________________
Card.java
-------------------------------------------------------------------------------

BACKGROUND:
The Card class is used to represent a card in Video Poker.
This class is created using the Comparable <Card> interface, to allow for cards
 to easily be compared using the compareTO method, then sorted in the Game 
   class using the sort method.
-------------------------------------------------------------------------------
INSTANCE VARIABLES:

Declare instance variables as follows:
  suit: int from 1-4 representing the suit of card.
  rank: int from 1-13 representing the rank of card.
  suit_string: English string of card's suit.
  rank_string: English string of card's rank.
-------------------------------------------------------------------------------
CONSTRUCTOR: Card(int s, int r)
  Two ints are passed into this constructor (r and s), representing the int
    values for the card being created.

CONSTRUCTOR PURPOSE:   
The Constructor takes in the ints s and r as arguments
  and instantiates instance variables as follows:
    suit is initialized to int value of s as passed in constructor argument.
    rank is initialized to int value of r as passed in constructor argument.
    suit_string is initialized to "null".
    rank_string is initialized to "null".
-------------------------------------------------------------------------------
MUTATOR METHODS:

METHOD: suitString()

METHOD PURPOSE:   
This method assigns a new suit name to the String "suit_string" (which was 
  initialized as "null"). 
The suit name is determined based on the value of suit (ranking from 1 to 4).

LOGIC:
Using the bridge hierarchy of cards, suits valued from 1 to 4 are assigned 
  their English suit names accordingly.     
...............................................................................
METHOD: rankString()

METHOD PURPOSE:   
This method assigns a new rank name to the String "rank_string" (which was 
  initialized as "null"). 
The rank name is determined based on the value of rank (ranking from 1 to 13).
           
LOGIC:
Face cards and the Ace are valued 1, 11, 12, 13 and are assigned 
  their English rank names accordingly.
Non-face or Ace cards are just assigned their numerical name as a String.
-------------------------------------------------------------------------------
ACCESSOR METHODS:

METHOD: compareTo(Card c)
  This method takes in a Card object, which is compared with the Card 
    constructed in this class. 
METHOD PURPOSE:   
This method is used to compare the ranks and suits of two cards.
The cards being compared are the card created in the constructor and
  the card passed in the method argument (Card c).
This method works with the Comparable interface to allow for easy sorting 
  when used in conjunction with the sort() method.
If the this card (from the current class) is greater in rank than Card c,
  1 is returned.
If the this card (from the current class) is lesser in rank than Card c,
  -1 is returned.
If the this card (from the current class) is equal in rank to Card c,
  the suit of each card is compared.
If the this card (from the current class) is greater in suit than Card c,
  1 is returned.
If the this card (from the current class) is lesser in suit than Card c,
  -1 is returned.
If the this card (from the current class) is equal in suit to Card c,
  0 is returned. (cards are the same card if they have equal rank and suit)

LOGIC:
The compareTo method is used to compare two Card objects, returning 1, -1 or 
 0.
This method is then used with the Compararable interface and the sort method
  to sort a hand of Card objects in the Game class.
...............................................................................
METHOD: toString()

METHOD PURPOSE:   
This method returns an English String of the rank and suit of a card,
  which is printed to user(as opposed to "s1", "Ace of Spades" is printed).
This is done by calling the suitString() and rankString() mutator methods,
  and then returning the String of "rank_string" + "suit_string".

LOGIC:
The toString method is executed when printing objects from the Card class to
  the console.
This method allows for a clear, English expression of each Card to be displayed
  to the console when cards are shown.
...............................................................................
METHOD: getSuit()

METHOD PURPOSE:   
This method returns the integer value of suit.
...............................................................................      
METHOD: getRank()

METHOD PURPOSE:
This method returns the integer value of rank.
===============================================================================
ENCODING ACE HIGH:

LOGIC:
Rather than adding another card of rank 14, the ace acts low (rank of 1)
  in the code in every hand EXCEPT one in which the hand is a highStraight.
If the hand is of an ace, ten, jack, queen, king, it is a highStraight.
This is a special case, the only time when an Ace acting as high in this 
  version of poker would affect the user's winnings.
Therefore, this case is addressed in its own helper method "highStraight()"
  the checks a hand for those 5 specific cards.
Additionally, due to the sorting scheme used in this code, another helper
  method "sortHigh()" is used to properly sort a hand of highStraight,
   in which the ace is placed as the highest ranking card at the end 
      of the hand.  
===============================================================================
SOURCES REFERENCED:
The following method was found from geeksforgeeks.com:
	*arrayList.remove(index)
	*arrayList.add(index)
	*arrayList.set(index, object)
===============================================================================
