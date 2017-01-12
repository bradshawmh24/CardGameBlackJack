
package cardgame21;
import java.io.Serializable;
import java.util.*;
/** CSIS 1410
 * Team Project
 * @author Andrew Maynez, Michael Bradshaw, Hoa Silim
 * This is the console version of the game, but was changed in order for it to help the GUI work.
 */
public class CardGame21 implements Serializable{

	
	private static final long serialVersionUID = -5380203653255373154L;
	public static Scanner input = new Scanner(System.in);
	public static int selection = 0;
	public static Hand game1;
	public static int handValue;
	public static int dealerValue;
	public static Player newPlayer;
	public static Player dealer;
	public static int newHand = 0;
	public static int newGameYes = 0;
	public static int gameover = 0;
	// Ace fixers...
	public static int doitonce = 0;
	public static int DealerOnce = 0;
	public static int cardset = 0;
	public static int dealercardset = 0;
	// betting stuff
	public static Betting bets;

	public static int playerbust = 0;
	public static int dealerbust = 0;
	public static int winlose = 0;

	/**
	 * empty constructor
	 */
	public CardGame21() {

	}

	/**
	 * This starts the game and sets up everything needed to run.
	 */
	public static void runGame() {
		// System.out.println("What is your name? ");
		newPlayer = new Player();
		// newPlayer.setName(input.nextLine());
		bets = new Betting();

		dealer = new Player();
		

		do {
			newGame();
		} while (newGameYes == 1);

	}

	/**
	 * this continues setting up the game.
	 */
	public static void newGame() {
		game1 = new Hand();
		newPlayer.setHand(game1.card1, game1.card3);
		dealer.setHandDealer(game1.card2, game1.card4);

		// bets.makeABet();

		System.out.println("\nYour Hand: " + newPlayer.getHand() + "");
		// System.out.println(dealer.getDealerHand());
		System.out.println("Dealer's Hand: " + game1.card2 + "-faceDown-\n");
		doitonce = 0;
		DealerOnce = 0;
		// Player's current hand value
		game1.card1num = game1.cardNums(game1.card1);
		game1.card3num = game1.cardNums(game1.card3);
		handValue = game1.card1num + game1.card3num;

		game1.card2num = game1.cardNums(game1.card2);
		game1.card4num = game1.cardNums(game1.card4);
		dealerValue = game1.card2num + game1.card4num;

	}

	/**
	 * This is used in order to load a game and set it up as a new game.
	 * @param args - the card values
	 * @param we - not used.
	 */
	public static void newGame2(String[] args, int[] we) {
		game1 = new Hand();
		game1.card1= args[0];
		game1.card2= args[1];
		game1.card3= args[2];
		game1.card4= args[3];
		game1.card5= args[4];
		game1.card6= args[5];
		game1.card7= args[6];
		game1.card8= args[7];
		game1.card9= args[8];
		game1.card10= args[9];
		
		newPlayer.setHand(game1.card1, game1.card3);
		dealer.setHandDealer(game1.card2, game1.card4);
		
		// bets.makeABet();

		System.out.println("\nYour Hand: " + newPlayer.getHand() + "");
		// System.out.println(dealer.getDealerHand());
		System.out.println("Dealer's Hand: " + game1.card2 + "-faceDown-\n");
		doitonce = 0;
		DealerOnce = 0;
		// Player's current hand value
		game1.card1num = game1.cardNums(game1.card1);
		game1.card3num = game1.cardNums(game1.card3);
		handValue = game1.card1num + game1.card3num;

		game1.card2num = game1.cardNums(game1.card2);
		game1.card4num = game1.cardNums(game1.card4);
		dealerValue = game1.card2num + game1.card4num;

	}
	
	/**
	 * Checks the value of the player's hand to see if they have busted.
	 * @param x - the player.
	 * @param w - the new card name
	 */
	public static void checkHandValue(Player x, String w) {
		handValue += game1.cardNums(w);
		if (handValue == 21) {
			System.out.println("You have 21! You win!");

			selection = 2;
		} else if (handValue > 21) {
			// check for ace
			System.out.println("Your hand is a little high there " + newPlayer.getName() + ".");
			if (doitonce == 0) {
				if (x.getHand().contains("ACE")) {
					handValue -= 10;
					System.out.println("Your current hand value is: " + handValue);
					System.out.println("The ACE's value was changed to 1");
					doitonce = 1;
				} else {
					System.out.println("Your current hand value is: " + handValue);
					System.out.println("Ah You've busted!");
					playerbust = 1;
					selection = 2;
				}
			} else if (w.contains("ACE")) {
				handValue -= 10;
				System.out.println("Your current hand value is: " + handValue);
				System.out.println("The ACE's value was changed to 1");
				if (handValue > 21) {
					System.out.println("Ah You've busted!");
					playerbust = 1;
					selection = 2;
				}
			} else {
				System.out.println("Your current hand value is: " + handValue);
				System.out.println("Ah You've busted!");
				playerbust = 1;
				selection = 2;
			}
			System.out.println();
		} else {
			System.out.println("Your current hand value is: " + handValue);
		}
	}

	/**
	 * gets the current hand value for the player.
	 * @return - returns the current int for the hand.
	 */
	public static int getHandValue() {
		return handValue;
	}

	/**
	 * Checks the value of the Dealer's hand to see if they have busted. 
	 * @param x - the dealer.
	 * @param w - the new card.
	 */
	public static void checkDealerHandValue(Player x, String w) {
		dealerValue += game1.cardNums(w);
		if (dealerValue == 21) {
			System.out.println("Dealer has 21. Dealer wins!");
			// selection = 2;
		} else if (dealerValue > 21) {
			// check for ace once
			if (DealerOnce == 0) {
				if (x.getDealerHand().contains("ACE")) {
					dealerValue -= 10;
					System.out.println("Dealer's current hand value is: " + dealerValue);
					System.out.println("The Dealer's ACE's value was changed to 1");
					DealerOnce = 1;
				} else {
					System.out.println("Dealer's current hand value is: " + dealerValue);
					System.out.println("Ah Dealer's busted!");
					dealerbust = 1;
				}
			} else if (w.contains("ACE")) {
				dealerValue -= 10;
				System.out.println("Dealer's current hand value is: " + dealerValue);
				System.out.println("The Dealer's ACE's value was changed to 1");
				if (dealerValue > 21) {
					System.out.println("Dealer's current hand value is: " + dealerValue);
					System.out.println("Ah Dealer's busted!");
					dealerbust = 1;
				}
			} else {
				System.out.println("Dealer's current hand value is: " + dealerValue);
				System.out.println("Ah Dealer's busted!");
				dealerbust = 1;
				// selection = 2;
			}
			System.out.println();
		}
	}

	/**
	 * This is used by the gui to read in what buttons the user pressed.
	 * @param xs - int of the selected action.
	 */
	public static void selection(int xs) {

		selection = xs;

		switch (selection) {
		case 1:
			if (cardset == 0) {
				newPlayer.setNewCard(game1.card5);
				System.out.println("Your new Hand is: " + newPlayer.getHand());
				checkHandValue(newPlayer, game1.card5);
			} else if (cardset == 1) {
				newPlayer.setNewCard(game1.card6);
				System.out.println("Your new Hand is: " + newPlayer.getHand());
				checkHandValue(newPlayer, game1.card6);
			} else if (cardset == 2) {
				newPlayer.setNewCard(game1.card7);
				System.out.println("Your new Hand is: " + newPlayer.getHand());
				checkHandValue(newPlayer, game1.card7);
			} else if (cardset == 3) {
				newPlayer.setNewCard(game1.card8);
				System.out.println("Your new Hand is: " + newPlayer.getHand());
				checkHandValue(newPlayer, game1.card8);
			}

			cardset += 1;
			break;

		case 2:
			System.out.println("You are holding with: " + newPlayer.getHand());
			System.out.println("Your hand value is: " + getHandValue());
			break;

		default:
			System.out.println("Invalid number please enter 1-2 for the game.");

		}

	}

	/**
	 * Plays the dealer getting cards if needed.
	 */
	public static void dealerselection() {
		if (dealerValue>21){
			if(dealer.getDealerHand().contains("ACE") && DealerOnce==0){
			dealerValue -= 10;
			System.out.println("Dealer's current hand value is: " + dealerValue);
			System.out.println("The Dealer's ACE's value was changed to 1");
			DealerOnce = 1;
			}
		}
		if (dealerValue < 16) {
			// Dealer draws cards
			if (dealercardset == 0) {
				dealer.setNewCardDealer(game1.card9);
				System.out.println("The Dealer's Hand: " + dealer.getDealerHand());
				checkDealerHandValue(dealer, game1.card9);
				System.out.println("Dealer's new hand value is: " + dealerValue + "\n");
				dealercardset += 1;
			}
			// if dealer value is still low like below 17
			if (dealerValue < 17) {
				if (dealercardset == 1) {

					dealer.setNewCardDealer(game1.card10);
					System.out.println("The Dealer's Hand: " + dealer.getDealerHand());
					checkDealerHandValue(dealer, game1.card10);
					System.out.println("Dealer's new hand value is: " + dealerValue + "\n");
					dealercardset += 1;
				}

			}
		}
	}

	/**
	 * Checks if the player has 21.
	 * @return -winlose value.
	 */
	public static int win21() {
		//int winlose = 0;
		if (handValue == 21) {
			System.out.println("You Win!");
			winlose = 1;
		}
		return winlose;
	}

	/**
	 * Checks if player busted.
	 * @return -winlose value.
	 */
	public static int busted() {
		//int winlose = 0;
		if (handValue > 21) {
			System.out.println("You Lost!");
			winlose = 2;
		}
		return winlose;
	}

	/**
	 * This will check who won or lost
	 * @return - return an int value to allow gui to setup a prompt of win or loss.
	 */
	public static int winlose() {
		//int winlose = 0;
		if(winlose!=1 && winlose!=2){
			
		
		if (playerbust == 1) {
			winlose = 2;
			System.out.println("playerbust");
		} else if (dealerbust == 1) {
			winlose = 1;
			System.out.println("dealerbust");
		} else {
			if (handValue <= 21 && dealerbust!=1) {
				if (handValue == 21 && dealerValue !=21) {
					System.out.println("You Win! at ==21");
					winlose = 1;
				} else if (dealerValue > 21) {
					System.out.println("YOU WIN! at dealervalue>21");
					winlose = 1;
				} else if (handValue < dealerValue) {
					System.out.println("You Lost! at handValue<dealerValue");
					winlose = 2;

				} else if (handValue > dealerValue) {
					System.out.println("YOU WIN! at handValue> dealerValue");
					winlose = 1;
				} else if (handValue==dealerValue){
					winlose = 3;
				}

			}
		}
		}
		return winlose;
	}

	/**
	 * it creates a new game.
	 */
	public static void newgameY() {

		runGame();

	}

	/**
	 * gets the dealers current hand value.
	 * @return - int of the current value of the dealer's hand.
	 */
	public static int getDealerHandValue() {
		return dealerValue;
	}

}
