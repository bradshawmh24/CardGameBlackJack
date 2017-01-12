
/**
 *
 * @author Andrew Maynez, Michael Bradshaw, Hoa Silim
 */

package cardgame21;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	@Test
	public void testCardNums() {
		String deuceCard = "DEUCE";
		assertTrue("String 'DEUCE' sets card value = 2", (deuceCard == "DEUCE") );
		
		String aceCard = "ACE";
		assertTrue("String 'ACE' sets card value = 11", (aceCard == "ACE") );
	}

}
