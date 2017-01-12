<<<<<<< HEAD
package cardgame21;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Properties;
import java.awt.event.ActionEvent;

/** CSIS 1410
 * Team Project
 * @author Andrew Maynez, Michael Bradshaw, Hoa Silim
 * CardGameGUI creates the frame and runs the game using CardGame21.java as a helper to run the game.
 * 
 */
public class CardGameGUI extends JFrame

{
	Icon cardBack = new ImageIcon(getClass().getClassLoader().getResource("cardBack.jpg"));
	Icon basicStrategy = new ImageIcon(getClass().getClassLoader().getResource("basicstrategy.jpg"));
	public static CardGame21 game = new CardGame21();
	private JPanel contentPane;
	public static int holding = 0;
	
	public Icon ldc1=null;
	public Icon ldc2=null;
	public Icon ldc3=null;
	public Icon ldc4=null;
	public Icon lpc1=null;
	public Icon lpc2=null;
	public Icon lpc3=null;
	public Icon lpc4=null;
	public Icon lpc5=null;
	public Icon lpc6=null;
	
	public String cwd=null;
	
	public static Properties prop = null;

	/**
	 * The main creates the frame and starts the game running.
	 * @param args - not used.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardGameGUI frame = new CardGameGUI();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the frame
	 */
	public CardGameGUI() {
		setTitle("Card Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = panelMethod();

	}

	/**
	 * This is the main coding for this gui version of the card game of 21.  It constructs the gui and uses cardgame21.java to do the game.
	 * It can also save and load from a file the start of a hand before any button is pressed.
	 * @return - the frame.
	 */
	private JPanel panelMethod() {
		game.runGame();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblDealerCard1 = new JLabel("");
		lblDealerCard1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDealerCard1.setBounds(125, 11, 99, 143);
		panel.add(lblDealerCard1);
		lblDealerCard1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card2))));

		JLabel lblDealerCard2 = new JLabel("");
		lblDealerCard2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDealerCard2.setBounds(240, 11, 99, 143);
		panel.add(lblDealerCard2);
		lblDealerCard2.setIcon(cardBack);

		JLabel lblDealerCard3 = new JLabel("");
		lblDealerCard3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDealerCard3.setBounds(357, 11, 99, 143);
		panel.add(lblDealerCard3);

		JLabel lblDealerCard4 = new JLabel("");
		lblDealerCard4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDealerCard4.setBounds(469, 11, 99, 143);
		panel.add(lblDealerCard4);

		JLabel lblPlayerCard1 = new JLabel("");
		lblPlayerCard1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerCard1.setBounds(10, 310, 99, 143);
		panel.add(lblPlayerCard1);
		lblPlayerCard1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card1))));

		JLabel lblPlayerCard2 = new JLabel("");
		lblPlayerCard2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerCard2.setBounds(125, 310, 99, 143);
		panel.add(lblPlayerCard2);
		lblPlayerCard2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card3))));

		JLabel lblPlayerCard3 = new JLabel("");
		lblPlayerCard3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerCard3.setBounds(240, 310, 99, 143);
		panel.add(lblPlayerCard3);

		JLabel lblPlayerCard4 = new JLabel("");
		lblPlayerCard4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerCard4.setBounds(357, 310, 99, 143);
		panel.add(lblPlayerCard4);

		JLabel lblPlayerCard5 = new JLabel("");
		lblPlayerCard5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerCard5.setBounds(469, 310, 99, 143);
		panel.add(lblPlayerCard5);

		JLabel lblPlayerCard6 = new JLabel("");
		lblPlayerCard6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerCard6.setBounds(587, 310, 99, 143);
		panel.add(lblPlayerCard6);

		JButton btnHold = new JButton("HOLD");
		btnHold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				holding = 1;
				lblDealerCard2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card4))));
				game.dealerselection();
				if (game.dealercardset == 2) {
					lblDealerCard3.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card9))));
					lblDealerCard4.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card10))));
				} else if (game.dealercardset == 1) {
					lblDealerCard3.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card9))));
				}
				if (game.winlose() == 1) {
					System.out.println("You Win");
					JOptionPane.showMessageDialog(null, "You Win!  Click New Game button to play again.");
				} else if (game.winlose() == 2) {
					System.out.println("You Lost");
					JOptionPane.showMessageDialog(null, "You Lost!  Click New Game button to play again.");
				} else if (game.winlose()==3){
					System.out.println("There is a Draw");
					JOptionPane.showMessageDialog(null, "Tie between you and dealer!  Click New Game button to play again.");
				}
			}
		});
		btnHold.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnHold.setBounds(294, 473, 194, 100);
		panel.add(btnHold);

		JButton btnHitMe = new JButton("Hit Me!");
		btnHitMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (holding == 1) {

				} else {
					if(game.win21()==1){
						JOptionPane.showMessageDialog(null, "You Win!  Click New Game button to play again.");	
						holding=1;
					}
					else{
					game.selection(1);
					if (game.cardset == 1) {
						lblPlayerCard3.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card5))));
					} else if (game.cardset == 2) {
						lblPlayerCard4.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card6))));
					} else if (game.cardset == 3) {
						lblPlayerCard5.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card7))));
					} else if (game.cardset == 4) {
						lblPlayerCard6.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card8))));
					}
					}
					if(game.busted()==2){
						JOptionPane.showMessageDialog(null, "You Lost!  Click New Game button to play again.");	
						holding=1;
					}else if(game.win21()==1){
						JOptionPane.showMessageDialog(null, "You have 21.");	
						holding=1;
					}
				}
			}
		});
		btnHitMe.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnHitMe.setBounds(78, 473, 194, 100);
		panel.add(btnHitMe);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game=null;
				game = new CardGame21();

				game.cardset = 0;
				game.dealercardset = 0;
				game.doitonce = 0;
				game.DealerOnce = 0;
				game.selection = 0;
				game.winlose=0;
				game.playerbust=0;
				game.dealerbust=0;
				game.handValue=0;
				game.dealerValue=0;
				game.runGame();
				lblDealerCard1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card2))));
				lblDealerCard2.setIcon(cardBack);
				lblDealerCard3.setIcon(null);
				lblDealerCard4.setIcon(null);
				lblPlayerCard1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card1))));
				lblPlayerCard2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card3))));
				lblPlayerCard3.setIcon(null);
				lblPlayerCard4.setIcon(null);
				lblPlayerCard5.setIcon(null);
				lblPlayerCard6.setIcon(null);
				holding = 0;

			}
		});
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewGame.setBounds(511, 473, 178, 100);
		panel.add(btnNewGame);

		JLabel lblStrategy = new JLabel("");
		lblStrategy.setBounds(701, 48, 326, 525);
		panel.add(lblStrategy);
		lblStrategy.setIcon(basicStrategy);

//		JLabel lblWinner = new JLabel("WINNER");
//		lblWinner.setBorder(new LineBorder(new Color(0, 0, 0)));
//		lblWinner.setHorizontalAlignment(SwingConstants.CENTER);
//		lblWinner.setBounds(433, 156, 258, 143);
//		panel.add(lblWinner);
		
		JButton btnSaveGame = new JButton("Save Game");
		btnSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Remember that you only save at the start of the game.");
				
		    	File cwdFile = new File ("game.properties");
		    	cwd = cwdFile.getAbsolutePath();
		    	System.out.println("cwd: "+cwd);
		    	
				FileWriter fwfin = null;
				try {
					fwfin = new FileWriter(cwdFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				PrintWriter pwfin = new PrintWriter(fwfin);
		    	String sldc1=lblDealerCard1.getIcon().toString();
		    	if(sldc1.contains("jar:file:/")){
					sldc1.substring(10);
				}else{
		    	sldc1=sldc1.substring(6);
				}
				pwfin.println("DEFAULT_LDC1="+sldc1);
				
				String sldc2=lblDealerCard2.getIcon().toString();
				if(sldc2.contains("jar:file:/")){
					sldc2.substring(10);
				}else{
		    	sldc2=sldc2.substring(6);
				}
				pwfin.println("DEFAULT_LDC2="+sldc2);
				
				String slpc1=lblPlayerCard1.getIcon().toString();
				if(slpc1.contains("jar:file:/")){
					slpc1.substring(10);
				}else{
		    	slpc1=slpc1.substring(6);
				}
				pwfin.println("DEFAULT_LPC1="+slpc1);
				
				String slpc2=lblPlayerCard2.getIcon().toString();
				System.out.println("slpc2= "+slpc2);
				if(slpc2.contains("jar:file:/")){
					slpc2.substring(10);
				}else{
				
		    	slpc2=slpc2.substring(6);
				}
				pwfin.println("DEFAULT_LPC2="+slpc2);
				
				pwfin.println("DEFAULT_CARD1="+game.game1.card1);
				pwfin.println("DEFAULT_CARD2="+game.game1.card2);
				pwfin.println("DEFAULT_CARD3="+game.game1.card3);
				pwfin.println("DEFAULT_CARD4="+game.game1.card4);
				pwfin.println("DEFAULT_CARD5="+game.game1.card5);
				pwfin.println("DEFAULT_CARD6="+game.game1.card6);
				pwfin.println("DEFAULT_CARD7="+game.game1.card7);
				pwfin.println("DEFAULT_CARD8="+game.game1.card8);
				pwfin.println("DEFAULT_CARD9="+game.game1.card9);
				pwfin.println("DEFAULT_CARD10="+game.game1.card10);
				
				pwfin.println("HOLDING="+holding);
				
				
				pwfin.flush();
				pwfin.close();
				
		    	
		       // serialize(game, path+File.separator+"game.ser");
		        ldc1=lblDealerCard1.getIcon();
		        ldc2=lblDealerCard2.getIcon();
		        ldc3=lblDealerCard3.getIcon();
		        ldc4=lblDealerCard4.getIcon();
		        lpc1=lblPlayerCard1.getIcon();
		        lpc2=lblPlayerCard2.getIcon();
		        lpc3=lblPlayerCard3.getIcon();
		        lpc4=lblPlayerCard4.getIcon();
		        lpc5=lblPlayerCard5.getIcon();
		        lpc6=lblPlayerCard6.getIcon();
		        
		        
			}
		});
		btnSaveGame.setBounds(10, 263, 89, 23);
		panel.add(btnSaveGame);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				FileInputStream isp =null;
				try{
		            
					isp = new FileInputStream(cwd);
		            prop = new Properties();
		            prop.load(isp);
		            
		        }catch (IOException e){
		           System.out.println("ERRNO--01" + e.getClass()); return;
		        }
				holding=Integer.parseInt(prop.getProperty("HOLDING"));
				 String strLDC1 = prop.getProperty("DEFAULT_LDC1");
				 String strLDC2 = prop.getProperty("DEFAULT_LDC2");
				 String strLDC3 = prop.getProperty("DEFAULT_LDC3");
				 String strLDC4 = prop.getProperty("DEFAULT_LDC4");
				 
				 String strLPC1 = prop.getProperty("DEFAULT_LPC1");
				 String strLPC2 = prop.getProperty("DEFAULT_LPC2");
				 String strLPC3 = prop.getProperty("DEFAULT_LPC3");
				 String strLPC4 = prop.getProperty("DEFAULT_LPC4");
				 String strLPC5 = prop.getProperty("DEFAULT_LPC5");
				 String strLPC6 = prop.getProperty("DEFAULT_LPC6");
				 System.out.println("strldc1: "+strLDC1);
				
				int[] hits={1,2,3,4,5,6};
				
				String card1=prop.getProperty("DEFAULT_CARD1");
				String card2=prop.getProperty("DEFAULT_CARD2");
				String card3=prop.getProperty("DEFAULT_CARD3");
				String card4=prop.getProperty("DEFAULT_CARD4");
				String card5=prop.getProperty("DEFAULT_CARD5");
				String card6=prop.getProperty("DEFAULT_CARD6");
				String card7=prop.getProperty("DEFAULT_CARD7");
				String card8=prop.getProperty("DEFAULT_CARD8");
				String card9=prop.getProperty("DEFAULT_CARD9");
				String card10=prop.getProperty("DEFAULT_CARD10");
				String[] cards={card1, card2, card3, card4, card5, card6, card7, card8, card9, card10};
				game.newGame2(cards, hits);
				
				lblDealerCard1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card2))));
				lblDealerCard2.setIcon(cardBack);
				lblDealerCard3.setIcon(null);
				lblDealerCard4.setIcon(null);
				lblPlayerCard1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card1))));
				lblPlayerCard2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card3))));
				lblPlayerCard3.setIcon(null);
				lblPlayerCard4.setIcon(null);
				lblPlayerCard5.setIcon(null);
				lblPlayerCard6.setIcon(null);
				
				game.cardset = 0;
				game.dealercardset = 0;
				
				game.selection = 0;
				game.winlose=0;
				game.playerbust=0;
				game.dealerbust=0;
				
				
				
			}
		});
		btnLoadGame.setBounds(125, 263, 89, 23);
		panel.add(btnLoadGame);

		return panel;
	}

	/**
	 * This getCardImage method reads in a string of the card and then finds the card image.
	 * @param card - String name of the card.
	 * @return - returns the name of the card image file.
	 */
	public static String getCardImage(String card) {
		// DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN,
		// KING, ACE
		// lblPlayerCard1.setIcon(new
		// ImageIcon(getClass().getResource("Cards/"+getCardImage("ACE of
		// HEARTS")) ));
		String cardimage = "";
		if (card.contains("HEARTS")) {
			cardimage = "heart";

		} else if (card.contains("DIAMONDS")) {
			cardimage = "diamond";
		} else if (card.contains("CLUBS")) {
			cardimage = "club";
		} else if (card.contains("SPADES")) {
			cardimage = "spade";
		}

		if (card.contains("DEUCE")) {
			cardimage += "Two.jpg";
		} else if (card.contains("THREE")) {
			cardimage += "Three.jpg";
		} else if (card.contains("FOUR")) {
			cardimage += "Four.jpg";
		} else if (card.contains("FIVE")) {
			cardimage += "Five.jpg";
		} else if (card.contains("SIX")) {
			cardimage += "Six.jpg";
		} else if (card.contains("SEVEN")) {
			cardimage += "Seven.jpg";
		} else if (card.contains("EIGHT")) {
			cardimage += "Eight.jpg";
		} else if (card.contains("NINE")) {
			cardimage += "Nine.jpg";
		} else if (card.contains("TEN")) {
			cardimage += "Ten.jpg";
		} else if (card.contains("JACK")) {
			cardimage += "Jack.jpg";
		} else if (card.contains("QUEEN")) {
			cardimage += "Queen.jpg";
		} else if (card.contains("KING")) {
			cardimage += "King.jpg";
		} else if (card.contains("ACE")) {
			cardimage += "Ace.jpg";
		}

		return cardimage;
	}
	
	
}
=======
package cardgame21;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Properties;
import java.awt.event.ActionEvent;

/** CSIS 1410
 * Team Project
 * @author Andrew Maynez, Michael Bradshaw, Hoa Silim
 * CardGameGUI creates the frame and runs the game using CardGame21.java as a helper to run the game.
 * 
 */
public class CardGameGUI extends JFrame

{
	Icon cardBack = new ImageIcon(getClass().getClassLoader().getResource("cardBack.jpg"));
	Icon basicStrategy = new ImageIcon(getClass().getClassLoader().getResource("basicstrategy.jpg"));
	public static CardGame21 game = new CardGame21();
	private JPanel contentPane;
	public static int holding = 0;
	
	public Icon ldc1=null;
	public Icon ldc2=null;
	public Icon ldc3=null;
	public Icon ldc4=null;
	public Icon lpc1=null;
	public Icon lpc2=null;
	public Icon lpc3=null;
	public Icon lpc4=null;
	public Icon lpc5=null;
	public Icon lpc6=null;
	
	public String cwd=null;
	
	public static Properties prop = null;

	/**
	 * The main creates the frame and starts the game running.
	 * @param args - not used.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardGameGUI frame = new CardGameGUI();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the frame
	 */
	public CardGameGUI() {
		setTitle("Card Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = panelMethod();

	}

	/**
	 * This is the main coding for this gui version of the card game of 21.  It constructs the gui and uses cardgame21.java to do the game.
	 * It can also save and load from a file the start of a hand before any button is pressed.
	 * @return - the frame.
	 */
	private JPanel panelMethod() {
		game.runGame();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblDealerCard1 = new JLabel("");
		lblDealerCard1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDealerCard1.setBounds(125, 11, 99, 143);
		panel.add(lblDealerCard1);
		lblDealerCard1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card2))));

		JLabel lblDealerCard2 = new JLabel("");
		lblDealerCard2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDealerCard2.setBounds(240, 11, 99, 143);
		panel.add(lblDealerCard2);
		lblDealerCard2.setIcon(cardBack);

		JLabel lblDealerCard3 = new JLabel("");
		lblDealerCard3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDealerCard3.setBounds(357, 11, 99, 143);
		panel.add(lblDealerCard3);

		JLabel lblDealerCard4 = new JLabel("");
		lblDealerCard4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDealerCard4.setBounds(469, 11, 99, 143);
		panel.add(lblDealerCard4);

		JLabel lblPlayerCard1 = new JLabel("");
		lblPlayerCard1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerCard1.setBounds(10, 310, 99, 143);
		panel.add(lblPlayerCard1);
		lblPlayerCard1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card1))));

		JLabel lblPlayerCard2 = new JLabel("");
		lblPlayerCard2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerCard2.setBounds(125, 310, 99, 143);
		panel.add(lblPlayerCard2);
		lblPlayerCard2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card3))));

		JLabel lblPlayerCard3 = new JLabel("");
		lblPlayerCard3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerCard3.setBounds(240, 310, 99, 143);
		panel.add(lblPlayerCard3);

		JLabel lblPlayerCard4 = new JLabel("");
		lblPlayerCard4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerCard4.setBounds(357, 310, 99, 143);
		panel.add(lblPlayerCard4);

		JLabel lblPlayerCard5 = new JLabel("");
		lblPlayerCard5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerCard5.setBounds(469, 310, 99, 143);
		panel.add(lblPlayerCard5);

		JLabel lblPlayerCard6 = new JLabel("");
		lblPlayerCard6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerCard6.setBounds(587, 310, 99, 143);
		panel.add(lblPlayerCard6);

		JButton btnHold = new JButton("HOLD");
		btnHold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				holding = 1;
				lblDealerCard2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card4))));
				game.dealerselection();
				if (game.dealercardset == 2) {
					lblDealerCard3.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card9))));
					lblDealerCard4.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card10))));
				} else if (game.dealercardset == 1) {
					lblDealerCard3.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card9))));
				}
				if (game.winlose() == 1) {
					System.out.println("You Win");
					JOptionPane.showMessageDialog(null, "You Win!  Click New Game button to play again.");
				} else if (game.winlose() == 2) {
					System.out.println("You Lost");
					JOptionPane.showMessageDialog(null, "You Lost!  Click New Game button to play again.");
				} else if (game.winlose()==3){
					System.out.println("There is a Draw");
					JOptionPane.showMessageDialog(null, "Tie between you and dealer!  Click New Game button to play again.");
				}
			}
		});
		btnHold.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnHold.setBounds(294, 473, 194, 100);
		panel.add(btnHold);

		JButton btnHitMe = new JButton("Hit Me!");
		btnHitMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (holding == 1) {

				} else {
					if(game.win21()==1){
						JOptionPane.showMessageDialog(null, "You Win!  Click New Game button to play again.");	
						holding=1;
					}
					else{
					game.selection(1);
					if (game.cardset == 1) {
						lblPlayerCard3.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card5))));
					} else if (game.cardset == 2) {
						lblPlayerCard4.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card6))));
					} else if (game.cardset == 3) {
						lblPlayerCard5.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card7))));
					} else if (game.cardset == 4) {
						lblPlayerCard6.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card8))));
					}
					}
					if(game.busted()==2){
						JOptionPane.showMessageDialog(null, "You Lost!  Click New Game button to play again.");	
						holding=1;
					}else if(game.win21()==1){
						JOptionPane.showMessageDialog(null, "You have 21.");	
						holding=1;
					}
				}
			}
		});
		btnHitMe.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnHitMe.setBounds(78, 473, 194, 100);
		panel.add(btnHitMe);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game=null;
				game = new CardGame21();

				game.cardset = 0;
				game.dealercardset = 0;
				game.doitonce = 0;
				game.DealerOnce = 0;
				game.selection = 0;
				game.winlose=0;
				game.playerbust=0;
				game.dealerbust=0;
				game.handValue=0;
				game.dealerValue=0;
				game.runGame();
				lblDealerCard1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card2))));
				lblDealerCard2.setIcon(cardBack);
				lblDealerCard3.setIcon(null);
				lblDealerCard4.setIcon(null);
				lblPlayerCard1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card1))));
				lblPlayerCard2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card3))));
				lblPlayerCard3.setIcon(null);
				lblPlayerCard4.setIcon(null);
				lblPlayerCard5.setIcon(null);
				lblPlayerCard6.setIcon(null);
				holding = 0;

			}
		});
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewGame.setBounds(511, 473, 178, 100);
		panel.add(btnNewGame);

		JLabel lblStrategy = new JLabel("");
		lblStrategy.setBounds(701, 48, 326, 525);
		panel.add(lblStrategy);
		lblStrategy.setIcon(basicStrategy);

//		JLabel lblWinner = new JLabel("WINNER");
//		lblWinner.setBorder(new LineBorder(new Color(0, 0, 0)));
//		lblWinner.setHorizontalAlignment(SwingConstants.CENTER);
//		lblWinner.setBounds(433, 156, 258, 143);
//		panel.add(lblWinner);
		
		JButton btnSaveGame = new JButton("Save Game");
		btnSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Remember that you only save at the start of the game.");
				
		    	File cwdFile = new File ("game.properties");
		    	cwd = cwdFile.getAbsolutePath();
		    	System.out.println("cwd: "+cwd);
		    	
				FileWriter fwfin = null;
				try {
					fwfin = new FileWriter(cwdFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				PrintWriter pwfin = new PrintWriter(fwfin);
		    	String sldc1=lblDealerCard1.getIcon().toString();
		    	if(sldc1.contains("jar:file:/")){
					sldc1.substring(10);
				}else{
		    	sldc1=sldc1.substring(6);
				}
				pwfin.println("DEFAULT_LDC1="+sldc1);
				
				String sldc2=lblDealerCard2.getIcon().toString();
				if(sldc2.contains("jar:file:/")){
					sldc2.substring(10);
				}else{
		    	sldc2=sldc2.substring(6);
				}
				pwfin.println("DEFAULT_LDC2="+sldc2);
				
				String slpc1=lblPlayerCard1.getIcon().toString();
				if(slpc1.contains("jar:file:/")){
					slpc1.substring(10);
				}else{
		    	slpc1=slpc1.substring(6);
				}
				pwfin.println("DEFAULT_LPC1="+slpc1);
				
				String slpc2=lblPlayerCard2.getIcon().toString();
				System.out.println("slpc2= "+slpc2);
				if(slpc2.contains("jar:file:/")){
					slpc2.substring(10);
				}else{
				
		    	slpc2=slpc2.substring(6);
				}
				pwfin.println("DEFAULT_LPC2="+slpc2);
				
				pwfin.println("DEFAULT_CARD1="+game.game1.card1);
				pwfin.println("DEFAULT_CARD2="+game.game1.card2);
				pwfin.println("DEFAULT_CARD3="+game.game1.card3);
				pwfin.println("DEFAULT_CARD4="+game.game1.card4);
				pwfin.println("DEFAULT_CARD5="+game.game1.card5);
				pwfin.println("DEFAULT_CARD6="+game.game1.card6);
				pwfin.println("DEFAULT_CARD7="+game.game1.card7);
				pwfin.println("DEFAULT_CARD8="+game.game1.card8);
				pwfin.println("DEFAULT_CARD9="+game.game1.card9);
				pwfin.println("DEFAULT_CARD10="+game.game1.card10);
				
				pwfin.println("HOLDING="+holding);
				
				
				pwfin.flush();
				pwfin.close();
				
		    	
		       // serialize(game, path+File.separator+"game.ser");
		        ldc1=lblDealerCard1.getIcon();
		        ldc2=lblDealerCard2.getIcon();
		        ldc3=lblDealerCard3.getIcon();
		        ldc4=lblDealerCard4.getIcon();
		        lpc1=lblPlayerCard1.getIcon();
		        lpc2=lblPlayerCard2.getIcon();
		        lpc3=lblPlayerCard3.getIcon();
		        lpc4=lblPlayerCard4.getIcon();
		        lpc5=lblPlayerCard5.getIcon();
		        lpc6=lblPlayerCard6.getIcon();
		        
		        
			}
		});
		btnSaveGame.setBounds(10, 263, 89, 23);
		panel.add(btnSaveGame);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				FileInputStream isp =null;
				try{
		            
					isp = new FileInputStream(cwd);
		            prop = new Properties();
		            prop.load(isp);
		            
		        }catch (IOException e){
		           System.out.println("ERRNO--01" + e.getClass()); return;
		        }
				holding=Integer.parseInt(prop.getProperty("HOLDING"));
				 String strLDC1 = prop.getProperty("DEFAULT_LDC1");
				 String strLDC2 = prop.getProperty("DEFAULT_LDC2");
				 String strLDC3 = prop.getProperty("DEFAULT_LDC3");
				 String strLDC4 = prop.getProperty("DEFAULT_LDC4");
				 
				 String strLPC1 = prop.getProperty("DEFAULT_LPC1");
				 String strLPC2 = prop.getProperty("DEFAULT_LPC2");
				 String strLPC3 = prop.getProperty("DEFAULT_LPC3");
				 String strLPC4 = prop.getProperty("DEFAULT_LPC4");
				 String strLPC5 = prop.getProperty("DEFAULT_LPC5");
				 String strLPC6 = prop.getProperty("DEFAULT_LPC6");
				 System.out.println("strldc1: "+strLDC1);
				
				int[] hits={1,2,3,4,5,6};
				
				String card1=prop.getProperty("DEFAULT_CARD1");
				String card2=prop.getProperty("DEFAULT_CARD2");
				String card3=prop.getProperty("DEFAULT_CARD3");
				String card4=prop.getProperty("DEFAULT_CARD4");
				String card5=prop.getProperty("DEFAULT_CARD5");
				String card6=prop.getProperty("DEFAULT_CARD6");
				String card7=prop.getProperty("DEFAULT_CARD7");
				String card8=prop.getProperty("DEFAULT_CARD8");
				String card9=prop.getProperty("DEFAULT_CARD9");
				String card10=prop.getProperty("DEFAULT_CARD10");
				String[] cards={card1, card2, card3, card4, card5, card6, card7, card8, card9, card10};
				game.newGame2(cards, hits);
				
				lblDealerCard1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card2))));
				lblDealerCard2.setIcon(cardBack);
				lblDealerCard3.setIcon(null);
				lblDealerCard4.setIcon(null);
				lblPlayerCard1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card1))));
				lblPlayerCard2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(getCardImage(game.game1.card3))));
				lblPlayerCard3.setIcon(null);
				lblPlayerCard4.setIcon(null);
				lblPlayerCard5.setIcon(null);
				lblPlayerCard6.setIcon(null);
				
				game.cardset = 0;
				game.dealercardset = 0;
				
				game.selection = 0;
				game.winlose=0;
				game.playerbust=0;
				game.dealerbust=0;
				
				
				
			}
		});
		btnLoadGame.setBounds(125, 263, 89, 23);
		panel.add(btnLoadGame);

		return panel;
	}

	/**
	 * This getCardImage method reads in a string of the card and then finds the card image.
	 * @param card - String name of the card.
	 * @return - returns the name of the card image file.
	 */
	public static String getCardImage(String card) {
		// DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN,
		// KING, ACE
		// lblPlayerCard1.setIcon(new
		// ImageIcon(getClass().getResource("Cards/"+getCardImage("ACE of
		// HEARTS")) ));
		String cardimage = "";
		if (card.contains("HEARTS")) {
			cardimage = "heart";

		} else if (card.contains("DIAMONDS")) {
			cardimage = "diamond";
		} else if (card.contains("CLUBS")) {
			cardimage = "club";
		} else if (card.contains("SPADES")) {
			cardimage = "spade";
		}

		if (card.contains("DEUCE")) {
			cardimage += "Two.jpg";
		} else if (card.contains("THREE")) {
			cardimage += "Three.jpg";
		} else if (card.contains("FOUR")) {
			cardimage += "Four.jpg";
		} else if (card.contains("FIVE")) {
			cardimage += "Five.jpg";
		} else if (card.contains("SIX")) {
			cardimage += "Six.jpg";
		} else if (card.contains("SEVEN")) {
			cardimage += "Seven.jpg";
		} else if (card.contains("EIGHT")) {
			cardimage += "Eight.jpg";
		} else if (card.contains("NINE")) {
			cardimage += "Nine.jpg";
		} else if (card.contains("TEN")) {
			cardimage += "Ten.jpg";
		} else if (card.contains("JACK")) {
			cardimage += "Jack.jpg";
		} else if (card.contains("QUEEN")) {
			cardimage += "Queen.jpg";
		} else if (card.contains("KING")) {
			cardimage += "King.jpg";
		} else if (card.contains("ACE")) {
			cardimage += "Ace.jpg";
		}

		return cardimage;
	}
	
	
}
>>>>>>> origin/master
