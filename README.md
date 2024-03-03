
Interactive Game of Video Poker

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
