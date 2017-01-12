
package cardgame21;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.*;
/** CSIS 1410
 * Team Project
 * @author Andrew Maynez, Michael Bradshaw, Hoa Silim
 * It is CardValues and consists of two enums, a constructor, creates the cards for the deck.
 */
public class CardValues implements Serializable
{
    
	private static final long serialVersionUID = -825101348846919726L;
	public char CLUBS = ('\u2663');
    public char DIAMONDS = ('\u2666');
    public char HEARTS = ('\u2665');
    public char SPADES = ('\u2660');


    /**
     * Values enum with the name of the cards.
     */
    public enum Values { DEUCE, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    /**
     * Creates the suits for the cards.
     */
    public enum Suits {
        CLUBS,
        SPADES,
        DIAMONDS,
        HEARTS;

           }

    private final Values rank;
    private final Suits suit;
    private final char[] pics = {CLUBS, SPADES, DIAMONDS, HEARTS};
    /**
     * Combines the rank and suit in order to make the cards.
     * @param rank -the rank of the card.
     * @param suit -the suit of the card.
     */
    private CardValues(Values rank, Suits suit)
    {
        this.rank = rank;
        this.suit = suit;

    }
    
    /**
     * gets the rank of the card.
     * @return - returns the rank of the card.
     */
    public Values rank() { return rank; }
    
    /**
     * Gets the suits of the card.
     * @return - returns the suit of the card.
     */
    public Suits suit() { return suit; }

    /**
     * formats the toString method for the enums.
     * @return - returns the string of the card.
     */
    @Override
    public String toString() { return rank + " of " + suit.toString(); }

    private static final List<CardValues> protoDeck = new ArrayList<CardValues>();

    /**
     * Initializes the prototype deck.  It combines the cards in a for loop.
     */
    // Initialize prototype deck
    static {
        for (Suits suit : Suits.values())
            for (Values rank : Values.values())
                protoDeck.add(new CardValues(rank, suit));
    }

    /**
     * Creates a list of cardvvalues.
     * @return - returns the list of card values.
     */
    public static ArrayList<CardValues> newDeck() {
        return new ArrayList<CardValues>(protoDeck); // Return copy of prototype deck
    }
}