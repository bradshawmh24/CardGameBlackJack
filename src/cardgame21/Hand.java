
package cardgame21;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** CSIS 1410
 * Team Project
 * @author Andrew Maynez, Michael Bradshaw, Hoa Silim
 * Hand grabs cards from the cardvalues.java to make a deck and assign the cards to the dealer and player.
 */
public class Hand implements Serializable {
    
	private static final long serialVersionUID = 1620699314848611513L;
	public static String Phand = null;
    public static Object Ohand = null;
    
    public static String card1=null;
    public static String card2=null;
    public static String card3=null;
    public static String card4=null;
    public static String card5=null;
    public static String card6=null;
    public static String card7=null;
    public static String card8=null;
    public static String card9=null;
    public static String card10=null;
    
    public static int card1num=0;
    public static int card2num=0;
    public static int card3num=0;
    public static int card4num=0;
    public static int card5num=0;
    public static int card6num=0;
    public static int card7num=0;
    public static int card8num=0;
    public static int card9num=0;
    public static int card10num=0;
    
    /**
     * This is the constructor that creates the hand and uses it to make deck.
     */
    public Hand(){
       // int numHands = Integer.parseInt("1");//args[0]);
        int cardsPerHand = Integer.parseInt("10");//args[1]);
        List<CardValues> theDeck  = CardValues.newDeck();
        Collections.shuffle(theDeck);
        String Phand = null;
        Object Ohand = null;
        //for (int i=0; i < numHands; i++)
        ArrayList<Object> gameDeal = new ArrayList<Object>((deal(theDeck, cardsPerHand)));
            //Ohand =(deal(theDeck, cardsPerHand));
            //System.out.println(gameDeal);
             card1 = gameDeal.get(0).toString();
             card2 = gameDeal.get(1).toString();
             card3 = gameDeal.get(2).toString();
             card4 = gameDeal.get(3).toString();
             card5 = gameDeal.get(4).toString();
             card6 = gameDeal.get(5).toString();
             card7 = gameDeal.get(6).toString();
             card8 = gameDeal.get(7).toString();
             card9 = gameDeal.get(8).toString();
             card10 = gameDeal.get(9).toString();
            System.out.println("card1: "+card1);
            
            
            //Phand=Ohand.toString();
            //System.out.println(Phand);
        
    }
    
    
    /**
     * converts the card's names into integer values
     * @param x - the card's name.
     * @return -the card's value.
     */
    public static int cardNums(String x){
        int value=0;
        //DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
        if(x.contains("DEUCE")){
            value=2;
        }
        if(x.contains("THREE")){
            value=3;
        }
        if(x.contains("FOUR")){
            value=4;
        }
        if(x.contains("FIVE")){
            value=5;
        }
        if(x.contains("SIX")){
            value=6;
        }
        if(x.contains("SEVEN")){
            value=7;
        }
        if(x.contains("EIGHT")){
            value=8;
        }
        if(x.contains("NINE")){
            value=9;
        }
        if(x.contains("TEN")){
            value=10;
        }
        if(x.contains("JACK")){
            value=10;
        }
        if(x.contains("QUEEN")){
            value=10;
        }
        if(x.contains("KING")){
            value=10;
        }
        if(x.contains("ACE")){
            value=11;
        }
        
        return value;
    }
    

    /**
     * This creates the Arraylist and takes in the deck to get how much to deal out.
     * @param deck - the randomly shuffled cards.
     * @param n - how many cards to draw.
     * @return - return the hand or the first 10 cards to be played with.
     */
    public static ArrayList<CardValues> deal(List<CardValues> deck, int n) {
         int deckSize = deck.size();
         List<CardValues> handView = deck.subList(deckSize-n, deckSize);
         ArrayList<CardValues> hand = new ArrayList<CardValues>(handView);
         handView.clear();
         return hand;
     }
    /**
     * gets the hand of the player.
     * @return - the hand.
     */
    public String getHand(){
        return Phand;
    }
    /**
     * sets the hand for the player.
     * @param d -put in the string for the cards.
     */
    public void setHand(String d){
        Phand=d;
    }
    /**
     * grabs the next card and adds it to the hand.
     * @param c - the next card.
     */
    public void drawCard(String c){
        Phand+=c;
    }
    
    
    
}
