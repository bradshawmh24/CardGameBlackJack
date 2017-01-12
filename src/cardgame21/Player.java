package cardgame21;

import java.io.Serializable;
/** CSIS 1410
 * Team Project
 * @author Andrew Maynez, Michael Bradshaw, Hoa Silim
 * Player creates the player and hands.
 */
public class Player implements Serializable {
    
	private static final long serialVersionUID = 2550133794936592429L;
	public static String name=null;
    public static String nameDealer=null;
    public static String currentHand=null;
    public static String currentDealerHand=null;
    
    public static int playerhand1=0;
    public static int playerhand2=0;
    public static int playerhand3=0;
    public static int playerhand4=0;
    public static int playerhand5=0;
    public static int playerhand6=0;
    
    public static int dealerhand1=0;
    public static int dealerhand2=0;
    public static int dealerhand3=0;
    public static int dealerhand4=0;
    //public static int dealerhand5=0;
    
    /**
     * empty constructor of player.
     */
    public Player(){
        
        
    }
    
    /**
     * it is used to grab a new card for the player.
     * @param z - grabs a card based on the string.
     */
    public void setNewCard(String z){
        if(playerhand3==0){
            playerhand3=Hand.cardNums(z);
        }else if(playerhand4==0)
        {
        playerhand4=Hand.cardNums(z);
        }else if(playerhand5==0){
        playerhand5=Hand.cardNums(z);
        }else{
        
        playerhand6=Hand.cardNums(z);
        
        }
        currentHand+=" | "+ z;
    }
    
    /**
     * Sets the hand for the player.
     * @param y - their first card int value
     * @param x - their second card int value
     */
    public void setHand(String y, String x){
        playerhand1=Hand.cardNums(y);
        playerhand2=Hand.cardNums(x);
        currentHand= y + " | " + x;
    }
    /**
     * Gets the current hand and prints out the contents of the hand.
     * @return the string currenthand to be printed out.
     */
    public String getHand(){
        return currentHand;
    }
    /**
     * sets the name for the player
     * @param x - the desired name.
     */
    public void setName(String x){
        name=x;
    }
    /**
     * gets the name of the player.
     * @return - name.
     */
    public String getName(){
        return name;
    }
    /**
     * sets the name for the dealer
     * @param x - the desired name.
     */
    public void setDealerName(String x){
        nameDealer=x;
    }
    /**
     * gets the name of the dealer.
     * @return - name.
     */
    public String getDealerName(){
        return nameDealer;
    }
    
    //dealer
    /**
     * Sets the new cards for the dealer.
     * @param z - the new card
     */
    public void setNewCardDealer(String z){
        if(dealerhand3==0){
            dealerhand3=Hand.cardNums(z);
        }else if(dealerhand4==0)
        {
        dealerhand4=Hand.cardNums(z);
        }
        currentDealerHand+=" | "+z;
    }
    /**
     * set the hand for the dealer.
     * @param y - first card
     * @param x - second card
     */
    public void setHandDealer(String y, String x){
        dealerhand1=Hand.cardNums(y);
        dealerhand2=Hand.cardNums(x);
        currentDealerHand=y+" | "+x;
    }
    /**
     * gets the dealer's current hand.
     * @return the dealers current hand.
     */
    public String getDealerHand(){
        return currentDealerHand;
    }
    
    
    
    
}
