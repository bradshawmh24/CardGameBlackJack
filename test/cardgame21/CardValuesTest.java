/**
 *
 * @author Andrew Maynez, Michael Bradshaw, Hoa Silim
 */

package cardgame21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardValuesTest {
	
    public enum Values { DEUCE, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    public enum Suits {
        CLUBS,
        SPADES,
        DIAMONDS,
        HEARTS;
           }

    private final Values rank = Values.DEUCE;
    private final Suits suit = Suits.CLUBS;

	@Test
	public void testToString() {
		String expected = "DEUCE of CLUBS";
		String actual = (rank + " of " + suit);
		assertEquals(expected, actual);		 
	}

}
