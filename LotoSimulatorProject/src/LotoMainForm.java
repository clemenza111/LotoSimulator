import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Color;

public class LotoMainForm {
//commit first change
	private final static String newline = "\n";
	private JFrame frmLotoStatistics;
	private JTextArea txtAreaDrawnNumbers;
	private JTextArea txtAreaWinningNumbers;
	private JTextField txtFieldNumberOfDraws;
	private JTextArea txtAreaPickedNumbers;
	private JButton btnDraw;
	private JScrollPane scrollPane;
	private JTextField txtFieldNumberOfTickets;
	private JScrollPane scroll;
	private JTextField textFieldNumbersForDraw;
	private JTextField textFieldAllNumbers;
	private int numbersForDraw;
	private int allNumbers;
	private JLabel lblShowTicketsWith;
	private JTextField textFieldMinimumHits;
	private int minimumHits;
	private int numberOfDraws;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LotoMainForm window = new LotoMainForm();
					window.frmLotoStatistics.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LotoMainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		InitializeForm();
		InitializeButtons();
	}

	private void InitializeForm() {
		// TODO Auto-generated method stub
		
		frmLotoStatistics = new JFrame();
		frmLotoStatistics.setTitle("Lottery Statistics");
		frmLotoStatistics.setBounds(100, 100, 711, 426);
		frmLotoStatistics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLotoStatistics.getContentPane().setLayout(null);

		scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(273, 29, 183, 283);
		frmLotoStatistics.getContentPane().add(scroll);

		txtAreaDrawnNumbers = new JTextArea();
		scroll.setViewportView(txtAreaDrawnNumbers);
		txtAreaDrawnNumbers.setEditable(false);
		txtAreaDrawnNumbers.setLineWrap(true);

		btnDraw = new JButton("PLAY");
		btnDraw.setBackground(Color.YELLOW);
		btnDraw.setFont(new Font("Sylfaen", Font.BOLD, 11));
		btnDraw.setBounds(616, 323, 69, 34);
		frmLotoStatistics.getContentPane().add(btnDraw);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(466, 29, 219, 283);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmLotoStatistics.getContentPane().add(scrollPane);

		txtAreaWinningNumbers = new JTextArea();
		txtAreaWinningNumbers.setToolTipText("(rowPlayed) - (rowDrawn) - (numbeOfHits)");
		scrollPane.setViewportView(txtAreaWinningNumbers);

		JLabel lblBrojIzvlaenja = new JLabel("Rounds of play:");
		lblBrojIzvlaenja.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBrojIzvlaenja.setBounds(273, 343, 81, 14);
		frmLotoStatistics.getContentPane().add(lblBrojIzvlaenja);

		JLabel lblIzvueniBrojevi = new JLabel("Drawn numbers:");
		lblIzvueniBrojevi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblIzvueniBrojevi.setBounds(273, 12, 105, 14);
		frmLotoStatistics.getContentPane().add(lblIzvueniBrojevi);

		JLabel lblPogoeniBrojevi = new JLabel("Winning tickets:");
		lblPogoeniBrojevi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPogoeniBrojevi.setBounds(465, 12, 124, 14);
		frmLotoStatistics.getContentPane().add(lblPogoeniBrojevi);

		txtFieldNumberOfDraws = new JTextField();
		txtFieldNumberOfDraws.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtFieldNumberOfDraws.setText("1");
		txtFieldNumberOfDraws.setToolTipText("Number of draws");
		txtFieldNumberOfDraws.setBounds(350, 344, 27, 14);
		frmLotoStatistics.getContentPane().add(txtFieldNumberOfDraws);
		txtFieldNumberOfDraws.setColumns(10);

		JScrollPane scrollPaneUneseno = new JScrollPane();
		scrollPaneUneseno.setBounds(10, 79, 227, 279);
		scrollPaneUneseno
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmLotoStatistics.getContentPane().add(scrollPaneUneseno);

		txtAreaPickedNumbers = new JTextArea();
		txtAreaPickedNumbers
				.setToolTipText("Example\r\n1,4,6,13,16,19");
		scrollPaneUneseno.setViewportView(txtAreaPickedNumbers);
		
		JLabel lblPickNumbersOf = new JLabel("Generate played tickets:");
		lblPickNumbersOf.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPickNumbersOf.setBounds(10, 40, 110, 14);
		frmLotoStatistics.getContentPane().add(lblPickNumbersOf);
		
		txtFieldNumberOfTickets = new JTextField();
		txtFieldNumberOfTickets.setText("1");
		txtFieldNumberOfTickets.setBounds(123, 37, 35, 20);
		frmLotoStatistics.getContentPane().add(txtFieldNumberOfTickets);
		txtFieldNumberOfTickets.setColumns(10);
		
		JLabel lblLotoType = new JLabel("Loto type:");
		lblLotoType.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblLotoType.setBounds(10, 12, 52, 14);
		frmLotoStatistics.getContentPane().add(lblLotoType);
		
		textFieldNumbersForDraw = new JTextField();
		textFieldNumbersForDraw.setText("6");
		textFieldNumbersForDraw.setBounds(64, 9, 35, 20);
		frmLotoStatistics.getContentPane().add(textFieldNumbersForDraw);
		textFieldNumbersForDraw.setColumns(10);
		
		textFieldAllNumbers = new JTextField();
		textFieldAllNumbers.setText("45");
		textFieldAllNumbers.setColumns(10);
		textFieldAllNumbers.setBounds(123, 9, 35, 20);
		frmLotoStatistics.getContentPane().add(textFieldAllNumbers);
		
		JLabel label = new JLabel("/");
		label.setBounds(109, 12, 4, 14);
		frmLotoStatistics.getContentPane().add(label);
		
		lblShowTicketsWith = new JLabel("Show tickets with minimum hits:");
		lblShowTicketsWith.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblShowTicketsWith.setBounds(273, 318, 150, 14);
		frmLotoStatistics.getContentPane().add(lblShowTicketsWith);
		
		textFieldMinimumHits = new JTextField();
		textFieldMinimumHits.setText("5");
		textFieldMinimumHits.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldMinimumHits.setBounds(422, 318, 27, 14);
		frmLotoStatistics.getContentPane().add(textFieldMinimumHits);
		textFieldMinimumHits.setColumns(10);
		
				JLabel lblUnesiBrojeveOdvojene = new JLabel(
						"Played tickets:");
				lblUnesiBrojeveOdvojene.setBounds(10, 65, 81, 13);
				frmLotoStatistics.getContentPane().add(lblUnesiBrojeveOdvojene);
				lblUnesiBrojeveOdvojene.setFont(new Font("Tahoma", Font.PLAIN, 10));
	}

	private void InitializeButtons() {
		
		JButton btnGenerateTickets = new JButton("Generate");
		btnGenerateTickets.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnGenerateTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numberOfPlays=Integer.parseInt(txtFieldNumberOfTickets.getText());
				numbersForDraw=Integer.parseInt(textFieldNumbersForDraw.getText());
				allNumbers=Integer.parseInt(textFieldAllNumbers.getText());
				LotoGenerator loto = new LotoGenerator();
				ArrayList<Integer> playedTicket;
				String strPlayTickets="";
			
		       for(int i=1;i<=numberOfPlays;i++)
		       {
		    	strPlayTickets+=i+"-";
				playedTicket=new ArrayList<Integer>();
				playedTicket=loto.generateLotoList(numbersForDraw, allNumbers);
				Collections.sort(playedTicket);
				for(int counter:playedTicket){
					strPlayTickets+= counter + ",";
				}
				strPlayTickets = strPlayTickets.substring(0, strPlayTickets.lastIndexOf(","));
				strPlayTickets+=newline;
		       }
		       
		       //insert text into textArea
		       txtAreaPickedNumbers.setText(strPlayTickets);
		       
			}
		});;
		btnGenerateTickets.setBounds(167, 37, 81, 20);
		frmLotoStatistics.getContentPane().add(btnGenerateTickets);
		


		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txtDrawnNumbers = "";
				String txtWinningNumbers = "";
				String tempText = "";
				numberOfDraws = Integer.parseInt(txtFieldNumberOfDraws.getText());
				numbersForDraw=Integer.parseInt(textFieldNumbersForDraw.getText());
				allNumbers=Integer.parseInt(textFieldAllNumbers.getText());
				minimumHits=Integer.parseInt(textFieldMinimumHits.getText());
				LotoGenerator loto = new LotoGenerator();
				ArrayList<Integer> listDrawnNumbers = null;
				ArrayList<Integer> listPlayedNumbers = new ArrayList<Integer>();
				ArrayList<ArrayList<Integer>> listPlayedNumbersAll = new ArrayList<ArrayList<Integer>>();
				String[] playedTicketRow=null;
				String[] playedTicketList=null;
				//list of played Tickets
				playedTicketList = txtAreaPickedNumbers.getText().split("\n");
				for (int i = 0; i < playedTicketList.length; i++) {
					listPlayedNumbers = new ArrayList<Integer>();
					playedTicketRow = playedTicketList[i].split(",");
					for (int j = 0; j < playedTicketRow.length; j++) {
						tempText=playedTicketRow[j];
						tempText=tempText.substring(tempText.indexOf("-")+1,tempText.length());
						listPlayedNumbers.add(Integer.parseInt(tempText));
					}
					listPlayedNumbersAll.add(listPlayedNumbers);
				}
				
				int count = 1;
				int hits = 0;
				int counterPlayedTickets = 1;
				do {
					listDrawnNumbers = loto.generateLotoList(numbersForDraw, allNumbers);
					Collections.sort(listDrawnNumbers);
					txtDrawnNumbers += count;
					txtDrawnNumbers += " - ";
					for (int broj : listDrawnNumbers) {
						tempText = broj + " ";
						txtDrawnNumbers += tempText;
					}
					txtDrawnNumbers += newline;
					
					counterPlayedTickets = 1;
					for (ArrayList<Integer> v_odigrani : listPlayedNumbersAll) {
						hits = loto.returnHits(v_odigrani, listDrawnNumbers);
						tempText = "";
						for (int broj : listDrawnNumbers) {
							tempText = broj + " ";
							if (hits >= minimumHits) {
								txtWinningNumbers += tempText;
							}
						}
						if (hits >= minimumHits) {
							txtWinningNumbers += "- (" + counterPlayedTickets + ") - (" + count + ") - (" + hits + ")";
							txtWinningNumbers += newline;
						}
						counterPlayedTickets++;
					}
					count++;
				} while (count <= numberOfDraws);
				txtAreaDrawnNumbers.setText(txtDrawnNumbers);
				txtAreaWinningNumbers.setText(txtWinningNumbers);
			}
		});
		
	}
}
