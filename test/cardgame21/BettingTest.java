/**
 *
 * @author Andrew Maynez, Michael Bradshaw, Hoa Silim
 */

package cardgame21;

import static org.junit.Assert.*;

import org.junit.Test;

public class BettingTest {

	@Test
	public void testMakeABet() {
		int bet = 500;
		assertTrue("Bet must be between 1-1000", (bet >= 1 && bet <= 1000) );
        }
	
	}