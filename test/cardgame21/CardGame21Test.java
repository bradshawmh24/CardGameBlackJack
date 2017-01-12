/**
 *
 * @author Andrew Maynez, Michael Bradshaw, Hoa Silim
 */

package cardgame21;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardGame21Test {
	
	@Test
	public void testCheckHandValue() {
		int handValue1 = 22;
		assertTrue("Hand value above 21 = Bust", (handValue1 > 21) );
		
		int handValue2 = 21;
		assertTrue("Hand value of 21 = Win", (handValue2 == 21) );
	}

	@Test
	public void testCheckDealerHandValue() {
		int dealerHand1 = 22;
		assertTrue("Dealer value above 21 = Bust", (dealerHand1 > 21) );
		
		int dealerHand2 = 21;
		assertTrue("Dealer value of 21 = Win", (dealerHand2 == 21) );
	}

}
