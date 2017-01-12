package cardgame21;

import java.io.Serializable;
import java.util.Scanner;

/** CSIS 1410
 * Team Project
 * @author Andrew Maynez, Michael Bradshaw, Hoa Silim
 * Betting is not implemented at this time due to time constrictions.
 * It allows you to bet money before you play the round.
 */
public class Betting implements Serializable {

    
	private static final long serialVersionUID = 8528239203572241656L;
	public static Scanner input2 = new Scanner(System.in);
    public static int money = 0;
    public static int bet = 0;
    public static boolean userWins = true;

    /**
     * Initialized the betting system.
     */
    public void Betting() {

        money = 1000;
        bet = 0;

        System.out.printf("You have %d\n", money);
    }

    /**
     * Allows you to make a bet.
     */
    public void makeABet() {
        //do {
        System.out.print("How many dollars do you want to bet? ");
        bet = input2.nextInt();
        if (bet < 0 || bet > money) {
            System.out.printf("Your must bet between 0 and %d.\n", money);
            makeABet();
            //     }
        }
    }

    /**
     * checks if you win and if so then adds money if you lose you lose money.
     * @param x - a boolean if true or false
     */
    public void winOrLose(boolean x) {
        userWins=x;
        if (userWins) {
            money = money + bet;
        } else {
            money = money - bet;
        }
        System.out.println("Your current balance is: "+getMoney());
        System.out.println();
        if (money == 0) {
            System.out.println();
            System.out.printf("You leave with $%d\n", money);
        }
        userWins=false;

    }

    /**
     * Just gets your current money amount.
     * @return - getMoney int result.
     */
    public int getMoney() {
        return money;
    }
}
