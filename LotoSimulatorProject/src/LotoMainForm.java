import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Font;

public class LotoMainForm {

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
	//comment1

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
		frmLotoStatistics.setBounds(100, 100, 711, 408);
		frmLotoStatistics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLotoStatistics.getContentPane().setLayout(null);

		scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(273, 29, 183, 254);
		frmLotoStatistics.getContentPane().add(scroll);

		txtAreaDrawnNumbers = new JTextArea();
		scroll.setViewportView(txtAreaDrawnNumbers);
		txtAreaDrawnNumbers.setEditable(false);
		txtAreaDrawnNumbers.setLineWrap(true);

		btnDraw = new JButton("PLAY");
		btnDraw.setFont(new Font("Sylfaen", Font.BOLD, 11));
		btnDraw.setBounds(351, 319, 70, 39);
		frmLotoStatistics.getContentPane().add(btnDraw);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(466, 29, 173, 254);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmLotoStatistics.getContentPane().add(scrollPane);

		txtAreaWinningNumbers = new JTextArea();
		scrollPane.setViewportView(txtAreaWinningNumbers);

		JLabel lblBrojIzvlaenja = new JLabel("Rounds of play:");
		lblBrojIzvlaenja.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBrojIzvlaenja.setBounds(273, 294, 81, 14);
		frmLotoStatistics.getContentPane().add(lblBrojIzvlaenja);

		JLabel lblIzvueniBrojevi = new JLabel("Drawns numbers:");
		lblIzvueniBrojevi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblIzvueniBrojevi.setBounds(273, 12, 105, 14);
		frmLotoStatistics.getContentPane().add(lblIzvueniBrojevi);

		JLabel lblPogoeniBrojevi = new JLabel("Winning tickets:");
		lblPogoeniBrojevi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPogoeniBrojevi.setBounds(465, 12, 124, 14);
		frmLotoStatistics.getContentPane().add(lblPogoeniBrojevi);

		txtFieldNumberOfDraws = new JTextField();
		txtFieldNumberOfDraws.setText("1");
		txtFieldNumberOfDraws.setToolTipText("Number of draws");
		txtFieldNumberOfDraws.setBounds(351, 289, 45, 22);
		frmLotoStatistics.getContentPane().add(txtFieldNumberOfDraws);
		txtFieldNumberOfDraws.setColumns(10);

		JLabel lblUnesiBrojeveOdvojene = new JLabel(
				"Played tickets:");
		lblUnesiBrojeveOdvojene.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblUnesiBrojeveOdvojene.setBounds(10, 56, 105, 14);
		frmLotoStatistics.getContentPane().add(lblUnesiBrojeveOdvojene);

		JScrollPane scrollPaneUneseno = new JScrollPane();
		scrollPaneUneseno.setBounds(10, 70, 227, 271);
		scrollPaneUneseno
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmLotoStatistics.getContentPane().add(scrollPaneUneseno);

		txtAreaPickedNumbers = new JTextArea();
		txtAreaPickedNumbers
				.setToolTipText("Example\r\n1,4,6,13,16,19");
		scrollPaneUneseno.setViewportView(txtAreaPickedNumbers);
		
		JLabel lblPickNumbersOf = new JLabel("Generate played tickets:");
		lblPickNumbersOf.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPickNumbersOf.setBounds(10, 12, 143, 14);
		frmLotoStatistics.getContentPane().add(lblPickNumbersOf);
		
		txtFieldNumberOfTickets = new JTextField();
		txtFieldNumberOfTickets.setText("1");
		txtFieldNumberOfTickets.setBounds(130, 9, 45, 20);
		frmLotoStatistics.getContentPane().add(txtFieldNumberOfTickets);
		txtFieldNumberOfTickets.setColumns(10);
		
	}

	private void InitializeButtons() {
		
		JButton btnGenerateTickets = new JButton("Generate");
		btnGenerateTickets.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnGenerateTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numberOfPlays=Integer.parseInt(txtFieldNumberOfTickets.getText());
				LotoGenerator loto = new LotoGenerator();
				ArrayList<Integer> playedTicket;
				String strPlayTickets="";
			
		       for(int i=1;i<=numberOfPlays;i++)
		       {
				playedTicket=new ArrayList<Integer>();
				playedTicket=loto.generateLotoList(6, 45);
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
		btnGenerateTickets.setBounds(129, 36, 89, 23);
		frmLotoStatistics.getContentPane().add(btnGenerateTickets);

		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numberOfDraws = Integer.parseInt(txtFieldNumberOfDraws.getText());
				String txtDrawnNumbers = "";
				String txtWinningNumbers = "";
				String tempText = "";
				LotoGenerator loto = new LotoGenerator();
				ArrayList<Integer> listDrawnNumbers = null;
				ArrayList<Integer> listPlayedNumbers = new ArrayList<Integer>();
				ArrayList<ArrayList<Integer>> listPlayedNumbersAll = new ArrayList<ArrayList<Integer>>();
				String[] playedTicketRow;
				String[] playedTicketList = txtAreaPickedNumbers.getText().split("\n");
				for (int i = 0; i < playedTicketList.length; i++) {
					listPlayedNumbers = new ArrayList<Integer>();
					playedTicketRow = playedTicketList[i].split(",");
					for (int j = 0; j < playedTicketRow.length; j++) {
						listPlayedNumbers.add(Integer.parseInt(playedTicketRow[j]));
					}
					listPlayedNumbersAll.add(listPlayedNumbers);
				}
				
				int count = 1;
				int hits = 0;
				do {
					listDrawnNumbers = loto.generateLotoList(6, 45);
					Collections.sort(listDrawnNumbers);
					txtDrawnNumbers += count;
					txtDrawnNumbers += " - ";
					for (int broj : listDrawnNumbers) {
						tempText = broj + " ";
						txtDrawnNumbers += tempText;
					}
					txtDrawnNumbers += newline;

					for (ArrayList<Integer> v_odigrani : listPlayedNumbersAll) {
						hits = loto.returnHits(v_odigrani, listDrawnNumbers);
						tempText = "";
						for (int broj : listDrawnNumbers) {
							tempText = broj + " ";
							if (hits >= 5) {
								txtWinningNumbers += tempText;
							}
						}
						if (hits >= 5) {
							txtWinningNumbers += "(" + hits + ")-(" + count + ")";
							txtWinningNumbers += newline;
						}
					}
					count++;
				} while (count <= numberOfDraws);
				txtAreaDrawnNumbers.setText(txtDrawnNumbers);
				txtAreaWinningNumbers.setText(txtWinningNumbers);
			}
		});
		
	}
}
