/**
 * 
 */
package View;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import Model.CrossoverMutation;
import Model.FileInputOutput;
import Model.Fitness;
import Model.Initialize;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/*@DecryptionView.java*/
/**
 * @author: Bharathi, Johnpaul
 * @Student_Number: 201595964, 201599234
 * @email: mailto:bs6523@mun.ca, jjpadinjakka@mun.ca
 */
public class DecryptionView {

	public static ArrayList<ArrayList<Character>> initPop = new ArrayList<>();
	public static ArrayList<Integer> selectedFortournament = new ArrayList<>();
	public static ArrayList<Double> fitnessOfSelected = new ArrayList<>();

	// to hold the results
	public static ArrayList<Double> bestFitness = new ArrayList<>();
	public static ArrayList<Double> worstFitness = new ArrayList<>();
	public static ArrayList<Double> averageFitness = new ArrayList<>();
	public static ArrayList<Double> fitnessReults = new ArrayList<>();

	private JFrame frmDecryption;
	static String filePath = "";
	static String TrainingText = "";
	HashMap<String, Integer> Training_ngram = new HashMap<>();
	HashMap<String, Integer> Dect_ngram = new HashMap<>();

	boolean isTrained;
	boolean isParameterCorrect = true;
	private JTextField textFieldEnteredKey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// TO RECORD ALL THE TERMINAL OUTPUTS INTO A FILE
//		File file = new File("TerminalLog.txt"); //Your file
//		FileOutputStream fos = null;
//		try {
//			fos = new FileOutputStream(file);
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		
//		PrintStream ps = new PrintStream(fos);
//		System.setOut(ps);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecryptionView window = new DecryptionView();
					System.out.println("Test hit");
					window.frmDecryption.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DecryptionView() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDecryption = new JFrame();
		frmDecryption.setResizable(false);
		frmDecryption.setTitle("Decryption");
		frmDecryption.setBounds(100, 100, 1210, 740);
		frmDecryption.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDecryption.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1210, 82);
		frmDecryption.getContentPane().add(panel);

		JLabel lblDecryption = new JLabel("Decryption:");
		lblDecryption.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDecryption.setBounds(24, 18, 140, 16);
		panel.add(lblDecryption);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(411, 0, 89, 86);
		panel.add(label_1);

		JLabel label_2 = new JLabel("SUBSTITUTION CIPHER");
		label_2.setBounds(24, 34, 265, 16);
		panel.add(label_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DecryptionView.class.getResource("/Image/ezgif-1-9e901cf21a.gif")));
		lblNewLabel.setBounds(1100, 0, 109, 76);
		panel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 112, 312, 231);
		frmDecryption.getContentPane().add(scrollPane);

		JTextPane txtPnCipherText = new JTextPane();
		scrollPane.setViewportView(txtPnCipherText);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"1. Enter Cipher Text Below", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		verticalBox.setBounds(15, 94, 329, 257);
		frmDecryption.getContentPane().add(verticalBox);

		JComboBox<Integer> comboBoxCrossoverType = new JComboBox<Integer>();
		comboBoxCrossoverType.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 10, 15, 20 }));
		comboBoxCrossoverType.setBounds(506, 115, 85, 27);
		frmDecryption.getContentPane().add(comboBoxCrossoverType);
		comboBoxCrossoverType.setSelectedIndex(1);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "3. Parameters",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		verticalBox_1.setBounds(352, 94, 290, 398);
		frmDecryption.getContentPane().add(verticalBox_1);

		JLabel lblMutationRate = new JLabel("Mutation Rate:");
		lblMutationRate.setBounds(366, 165, 103, 16);
		frmDecryption.getContentPane().add(lblMutationRate);

		JLabel lblCrossoverType = new JLabel("Max Crossover Points: ");
		lblCrossoverType.setBounds(366, 115, 225, 16);
		frmDecryption.getContentPane().add(lblCrossoverType);

		JLabel lblCrossoverRate = new JLabel("Crossover Rate:");
		lblCrossoverRate.setBounds(366, 215, 130, 16);
		frmDecryption.getContentPane().add(lblCrossoverRate);

		JLabel lblTournamentSize = new JLabel("Tournament Size:");
		lblTournamentSize.setBounds(366, 315, 118, 16);
		frmDecryption.getContentPane().add(lblTournamentSize);

		JComboBox<Integer> comboBoxPopulationSize = new JComboBox<Integer>();

		comboBoxPopulationSize
				.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 10, 20, 50, 100, 150, 250, 500, 1000 }));
		comboBoxPopulationSize.setBounds(506, 265, 85, 27);
		frmDecryption.getContentPane().add(comboBoxPopulationSize);
		comboBoxPopulationSize.setSelectedIndex(3);

		JLabel lblPopulationSize = new JLabel("Population Size:");
		lblPopulationSize.setBounds(366, 265, 103, 16);
		frmDecryption.getContentPane().add(lblPopulationSize);

		JLabel lblGenerationSize = new JLabel("Generations:");
		lblGenerationSize.setBounds(366, 365, 103, 16);
		frmDecryption.getContentPane().add(lblGenerationSize);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(658, 124, 520, 278);
		frmDecryption.getContentPane().add(scrollPane_1);

		JTextPane txtpnHhhh = new JTextPane();
		txtpnHhhh.setText("");
		scrollPane_1.setViewportView(txtpnHhhh);
		JComboBox<Integer> comboBoxSizeNgram = new JComboBox<Integer>();
		comboBoxSizeNgram.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 2, 3, 4, 5, 6 }));
		comboBoxSizeNgram.setBounds(139, 425, 85, 27);
		frmDecryption.getContentPane().add(comboBoxSizeNgram);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(0);
		progressBar.setBounds(654, 405, 519, 29);
		frmDecryption.getContentPane().add(progressBar);

		JLabel lblNewLabelwait = new JLabel("");
		lblNewLabelwait.setBounds(647, 645, 225, 16);
		frmDecryption.getContentPane().add(lblNewLabelwait);

		JSpinner spinnerGenerations = new JSpinner();
		spinnerGenerations.setBounds(500, 365, 91, 26);
		frmDecryption.getContentPane().add(spinnerGenerations);
		spinnerGenerations.setValue(1000);

		JLabel lblNewLabelpro = new JLabel("[i]");
		lblNewLabelpro.setToolTipText("overall Progress of the Decryption");
		lblNewLabelpro.setBounds(1176, 405, 18, 16);
		frmDecryption.getContentPane().add(lblNewLabelpro);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(884, 670, 310, 16);
		frmDecryption.getContentPane().add(lblNewLabel_2);

		JComboBox<Double> comboBoxMutationRate = new JComboBox<Double>();
		comboBoxMutationRate.setModel(new DefaultComboBoxModel<Double>(new Double[] { 0.0, 0.2, 0.4, 0.6, 0.8, 1.0 }));
		comboBoxMutationRate.setBounds(506, 165, 85, 27);
		frmDecryption.getContentPane().add(comboBoxMutationRate);
		comboBoxMutationRate.setSelectedIndex(5);

		JComboBox<Double> comboBoxCrossoverRate = new JComboBox<Double>();
		comboBoxCrossoverRate.setModel(new DefaultComboBoxModel<Double>(new Double[] { 0.0, 0.2, 0.4, 0.6, 0.8, 1.0 }));
		comboBoxCrossoverRate.setBounds(506, 215, 85, 27);
		frmDecryption.getContentPane().add(comboBoxCrossoverRate);
		comboBoxCrossoverRate.setSelectedIndex(5);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(658, 460, 520, 173);
		frmDecryption.getContentPane().add(scrollPane_2);

		JTextPane textPaneTournmentSelected = new JTextPane();
		textPaneTournmentSelected.setText("");
		scrollPane_2.setViewportView(textPaneTournmentSelected);

		JComboBox<Integer> comboBoxTournamentSize = new JComboBox<Integer>();

		comboBoxTournamentSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((int) comboBoxTournamentSize.getSelectedItem() > (int) comboBoxPopulationSize.getSelectedItem()) {
					JOptionPane.showMessageDialog(null, "TournamentSize canot be more than PopulationSize !!");
					isParameterCorrect = false;
				} else {
					isParameterCorrect = true;
				}

			}
		});
		comboBoxTournamentSize.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 5, 10, 15, 20, 30, 50, 75 }));
		comboBoxTournamentSize.setBounds(506, 315, 85, 27);
		frmDecryption.getContentPane().add(comboBoxTournamentSize);
		comboBoxTournamentSize.setSelectedIndex(5);

		
		comboBoxPopulationSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((int) comboBoxTournamentSize.getSelectedItem() > (int) comboBoxPopulationSize.getSelectedItem()) {
					JOptionPane.showMessageDialog(null, "TournamentSize canot be more than PopulationSize !!");
					isParameterCorrect = false;
				} else {
					isParameterCorrect = true;
				}
			}
		});

		JButton btnStartDecryption = new JButton("Start Decryption");
		btnStartDecryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String displayInitPop = "";

				int CrossoverSize = (int) comboBoxCrossoverType.getSelectedItem();
				int PopulationSize = (int) comboBoxPopulationSize.getSelectedItem();
				int TournamentSize = (int) comboBoxTournamentSize.getSelectedItem();
				double GenerationSize = (int) spinnerGenerations.getValue();
				double mutrate = (double) comboBoxMutationRate.getSelectedItem();
				double Cxrrate = (double) comboBoxCrossoverRate.getSelectedItem();
				int NgramSize = (int) comboBoxSizeNgram.getSelectedItem();
				bestFitness.clear();
				worstFitness.clear();
				averageFitness.clear();
				String cipherTxt = txtPnCipherText.getText().toUpperCase();

				ArrayList<Integer> MutationRateList = new ArrayList<>();
				ArrayList<Integer> CxrRateList = new ArrayList<>();

				// Mutation Rate

				Random R = new Random();
				int b = 0;
				while (MutationRateList.size() < (GenerationSize * mutrate)) {
					b = R.nextInt((int) GenerationSize);
					if (!MutationRateList.contains(b)) {
						MutationRateList.add(b);
					}

				}

				// int c = 0;
				while (CxrRateList.size() < (GenerationSize * Cxrrate)) {
					b = R.nextInt((int) GenerationSize);
					if (!CxrRateList.contains(b)) {
						CxrRateList.add(b);
					}

				}

				if (GenerationSize < 100) {
					JOptionPane.showMessageDialog(null, "Please Select Generation Size Morethan 100");
					isParameterCorrect = false;
				}

				if (!isParameterCorrect) {
					JOptionPane.showMessageDialog(null, "Please makesure Parameter valus are correct!!");
				}

				if (isTrained && isParameterCorrect) {

					// .........main loop
					initPop = Initialize.initializePopulation(PopulationSize);
					for (int i = 0; i < initPop.size(); i++) {
						displayInitPop += initPop.get(i).toString() + "\n";
					}
					txtpnHhhh.setText(displayInitPop);

					lblNewLabelwait.setForeground(Color.RED);
					lblNewLabelwait.setText("Please Wait.....");
					lblNewLabelwait.update(lblNewLabelwait.getGraphics());
					int count = 0;

					long progStartTime = System.currentTimeMillis();
					lblNewLabel_2.setText("");

					while (count < (int) GenerationSize) {

						textPaneTournmentSelected.setText("");
						double pro = (count / GenerationSize) * 100.0;
						progressBar.setValue((int) pro);
						progressBar.update(progressBar.getGraphics());

						// ....Tournament selection
						Random r = new Random();
						selectedFortournament.clear();
						while (selectedFortournament.size() < TournamentSize) {
							int x = r.nextInt(initPop.size());
							if (!(selectedFortournament.contains(x)))
								selectedFortournament.add(x);
						}
						// ........................

						// .....Fitness Calculation
						fitnessOfSelected.clear();
						for (int i = 0; i < selectedFortournament.size(); i++) {

							fitnessOfSelected.add(Fitness.fitness(initPop.get(selectedFortournament.get(i)), cipherTxt,
									Training_ngram, (int) comboBoxSizeNgram.getSelectedItem()));

						}

						ArrayList<Double> sortedFitness = new ArrayList<>(fitnessOfSelected);
						Collections.sort(sortedFitness);

						System.out.println(fitnessOfSelected);

						System.out.println(sortedFitness);

						ArrayList<Character> parent1 = new ArrayList<>();
						ArrayList<Character> parent2 = new ArrayList<>();
						parent1 = initPop.get(selectedFortournament
								.get(fitnessOfSelected.indexOf(sortedFitness.get(sortedFitness.size() - 1))));
						parent2 = initPop.get(selectedFortournament
								.get(fitnessOfSelected.indexOf(sortedFitness.get(sortedFitness.size() - 2))));
						int indexOfworstFitInInitPop = initPop.indexOf(initPop
								.get((selectedFortournament.get(fitnessOfSelected.indexOf(sortedFitness.get(0))))));

						System.out.println("selected for tour\n");

						for (int i = 0; i < selectedFortournament.size(); i++) {
							System.out.println(
									initPop.get(selectedFortournament.get(i)) + " fitness " + fitnessOfSelected.get(i));
							// textPaneTournmentSelected.setText(textPaneTournmentSelected.getText()+"/n"+initPop.get(selectedFortournament.get(i))
							// + " fitness " + fitnessOfSelected.get(i));
							// textPaneTournmentSelected.update(textPaneTournmentSelected.getGraphics());
						}

						System.out.println("p1 " + parent1);
						System.out.println("p2 " + parent2 + "\n index of worse " + indexOfworstFitInInitPop);

						ArrayList<Character> offspring = new ArrayList<>();

						offspring = parent1;

						// Crossover
						if (CxrRateList.contains(count)) {
							offspring = CrossoverMutation.Crossover(parent1, parent2, CrossoverSize);
							System.out.println("o1 " + offspring);
						}

						// Mutation
						if (MutationRateList.contains(count)) {
							offspring = CrossoverMutation.mutate(offspring);
							System.out.println("mu1 " + offspring);
						}

						// replacement
						initPop.set(indexOfworstFitInInitPop, offspring);
						String temp = "";
						for (int i = 0; i < initPop.size(); i++) {
							temp += initPop.get(i).toString() + "\n";
						}
						txtpnHhhh.setText(temp);

						// ........................

						// Record result-------------------------------------------------
						Double sum = 0.0;
						fitnessReults.clear();
						if (count % 100 == 0) {
							System.out.println("-------------------------------------------------------");

							for (int i = 0; i < initPop.size(); i++) {

								fitnessReults.add(Fitness.fitness(initPop.get(i), cipherTxt, Training_ngram,
										(int) comboBoxSizeNgram.getSelectedItem()));

							}

							Collections.sort(fitnessReults);
							bestFitness.add(fitnessReults.get(fitnessReults.size() - 1));
							worstFitness.add(fitnessReults.get(0));
							for (int i = 0; i < fitnessReults.size(); i++) {
								sum += fitnessReults.get(i);
							}
							averageFitness.add((sum / fitnessReults.size()));

						}

						// ..................................................

						count++;
						// ......main while loop ends
					}

					long endtime = (System.currentTimeMillis() - progStartTime);
					String Endtime = (System.currentTimeMillis() - progStartTime) / 1000.0 + " Seconds";
					lblNewLabel_2.setText(Endtime);

					lblNewLabelwait.setText("Done!");

					for (int i = 0; i < initPop.size(); i++) {
						System.out.println(initPop.get(i).toString() + "Fitness " + Fitness.fitness(initPop.get(i),
								cipherTxt, Training_ngram, (int) comboBoxSizeNgram.getSelectedItem()));
					}

					ArrayList<Double> final_fitness = new ArrayList<>();

					for (int i = 0; i < initPop.size(); i++) {

						final_fitness.add(Fitness.fitness(initPop.get(i), cipherTxt, Training_ngram,
								(int) comboBoxSizeNgram.getSelectedItem()));

					}

					ArrayList<Double> sortedFinalFitness = new ArrayList<>(final_fitness);
					Collections.sort(sortedFinalFitness);
					ArrayList<Character> bestIndividual = new ArrayList<Character>();
					bestIndividual = initPop
							.get((final_fitness.indexOf(sortedFinalFitness.get(sortedFinalFitness.size() - 1))));

					Double fitness = Fitness.fitness(bestIndividual, cipherTxt, Training_ngram,
							(int) comboBoxSizeNgram.getSelectedItem());

					System.out.println("best individual is \n" + bestIndividual + "Fitness " + fitness);

					System.out.println("Decrypted \n");
					textPaneTournmentSelected.setText(Fitness.Decryption(bestIndividual, cipherTxt));
					System.out.println(Fitness.Decryption(bestIndividual, cipherTxt));

					System.out.println("best " + bestFitness);
					System.out.println("worst " + worstFitness);
					System.out.println("average " + averageFitness);

					ResultsView frame = new ResultsView(Fitness.Decryption(bestIndividual, cipherTxt).toString(),
							"" + PopulationSize, "" + Cxrrate, "" + mutrate, "" + TournamentSize, "" + CrossoverSize,
							"" + GenerationSize, "" + NgramSize, "" + averageFitness.get(averageFitness.size() - 1),
							"" + fitness, bestIndividual, endtime, "" + worstFitness.get(worstFitness.size() - 1));

					frame.setVisible(true);
					frame.requestFocus();

				} else {

					JOptionPane.showMessageDialog(null, "Please Train the system before Decryption");

				}

			}
		});

		btnStartDecryption.setBounds(366, 408, 251, 29);
		frmDecryption.getContentPane().add(btnStartDecryption);

		// comboBoxCrossoverRate.addItem(item);

		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox_2.setBorder(
				new TitledBorder(null, "Generate Cipher Text", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		verticalBox_2.setBounds(15, 516, 329, 125);
		frmDecryption.getContentPane().add(verticalBox_2);

		JButton btnClickHereTo = new JButton("Click here");
		btnClickHereTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EncryptionView window = new EncryptionView();
				window.frmEncryption.setVisible(true);
			}
		});
		btnClickHereTo.setBounds(48, 597, 265, 29);
		frmDecryption.getContentPane().add(btnClickHereTo);

		JLabel lblSizeOfNgrame = new JLabel("Size of N-Gram:");
		lblSizeOfNgrame.setBounds(28, 425, 111, 16);
		frmDecryption.getContentPane().add(lblSizeOfNgrame);

		JButton btnViewNgrams = new JButton("View N-Grams");
		btnViewNgrams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (isTrained) {
					int N_Ngram = (int) comboBoxSizeNgram.getSelectedItem();

					NgramView ob = new NgramView(TrainingText, N_Ngram);
					ob.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Trin the system to view Ngrams");
				}

			}
		});
		btnViewNgrams.setBounds(196, 470, 117, 29);
		frmDecryption.getContentPane().add(btnViewNgrams);

		Box verticalBox_4 = Box.createVerticalBox();
		verticalBox_4.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
				"Final Population", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		verticalBox_4.setBounds(647, 94, 547, 340);
		frmDecryption.getContentPane().add(verticalBox_4);

		JLabel lblFilePath = new JLabel("Path : ");
		lblFilePath.setBounds(32, 400, 302, 16);
		frmDecryption.getContentPane().add(lblFilePath);

		JButton btnUpload = new JButton("Upload Training file");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(frmDecryption);
				if (result == JFileChooser.APPROVE_OPTION) {

					File selectedFile = fileChooser.getSelectedFile();

					filePath = selectedFile.getPath();

					System.out.println(filePath);
					lblFilePath.setText(filePath);
					// fileData = FileInputOutput.readFile(filePath);

				}

			}
		});
		btnUpload.setBounds(22, 375, 168, 29);
		frmDecryption.getContentPane().add(btnUpload);

		JButton btnTrain = new JButton("Train");
		btnTrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					TrainingText = FileInputOutput.readFile(filePath);
					System.out.println(TrainingText);

				} catch (IOException e1) {

					JOptionPane.showMessageDialog(null, "Please Select Training File and click Train Button");
					// TODO Auto-generated catch block
					// e1.printStackTrace();
				}

				Training_ngram = Model.Ngrams.Ngram(TrainingText, (int) comboBoxSizeNgram.getSelectedItem());

				System.out.println("Start");
				for (HashMap.Entry<String, Integer> entry : Training_ngram.entrySet()) {
					System.out.println(entry.getKey() + "   --  " + entry.getValue());
					// model.addRow(new Object[]{entry.getKey(), entry.getValue()});
				}

				isTrained = true;
				lblFilePath.setForeground(Color.GREEN);
				lblFilePath.setText("Training Finished Successfully");

			}
		});
		btnTrain.setBounds(22, 470, 117, 29);
		frmDecryption.getContentPane().add(btnTrain);

		JLabel label_fitnessOfKey = new JLabel("0000");
		label_fitnessOfKey.setDisplayedMnemonic('-');
		label_fitnessOfKey.setBounds(427, 617, 201, 16);
		frmDecryption.getContentPane().add(label_fitnessOfKey);

		textFieldEnteredKey = new JTextField();
		textFieldEnteredKey.setText("Enter a Key to check Fitness");
		textFieldEnteredKey.setBounds(366, 538, 258, 26);
		frmDecryption.getContentPane().add(textFieldEnteredKey);
		textFieldEnteredKey.setColumns(10);

		JLabel lblFitness = new JLabel("Fitness : ");
		lblFitness.setBounds(366, 617, 61, 16);
		frmDecryption.getContentPane().add(lblFitness);

		JButton btnCalculateFitness = new JButton("Calculate");
		btnCalculateFitness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (isTrained) {
					ArrayList<Character> enteredKey = new ArrayList<>();
					String extractedKey = "";
					extractedKey = textFieldEnteredKey.getText();
					if (extractedKey.contains(",")) {
						extractedKey = extractedKey.replaceAll(",", "");
					}
					if (extractedKey.contains("[")) {
						extractedKey = extractedKey.replaceAll("[", "");
					}
					if (extractedKey.contains("]")) {
						extractedKey = extractedKey.replaceAll("]", "");
					}
					if (extractedKey.contains(" ")) {
						extractedKey = extractedKey.replaceAll(" ", "");
					}
					System.out.println("after removel  key  " + extractedKey);

					for (int i = 0; i < extractedKey.length(); i++) {
						enteredKey.add(extractedKey.toCharArray()[i]);
					}
					System.out.println("Entered key  " + enteredKey);
					label_fitnessOfKey.setText("" + Fitness.fitness(enteredKey, txtPnCipherText.getText().toUpperCase(),
							Training_ngram, (int) comboBoxSizeNgram.getSelectedItem()));

				} else {
					JOptionPane.showMessageDialog(null, "Please Select Training File and click Train Button");
				}
			}
		});
		btnCalculateFitness.setBounds(511, 576, 117, 29);
		frmDecryption.getContentPane().add(btnCalculateFitness);

		JLabel label = new JLabel("[i]");
		label.setToolTipText("Number of Generation, ");
		label.setBounds(600, 370, 18, 16);
		frmDecryption.getContentPane().add(label);

		JLabel label_3 = new JLabel("[i]");
		label_3.setToolTipText("Tournament Size");
		label_3.setBounds(600, 315, 18, 16);
		frmDecryption.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("[i]");
		label_4.setToolTipText("Population Size");
		label_4.setBounds(600, 265, 18, 16);
		frmDecryption.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("[i]");
		label_5.setToolTipText("Crossover Rate");
		label_5.setBounds(600, 215, 18, 16);
		frmDecryption.getContentPane().add(label_5);

		JLabel label_6 = new JLabel("[i]");
		label_6.setToolTipText("Mutation Rate");
		label_6.setBounds(600, 165, 18, 16);
		frmDecryption.getContentPane().add(label_6);

		JLabel label_7 = new JLabel("[i]");
		label_7.setToolTipText("overall Progress of the Decryption");
		label_7.setBounds(600, 115, 18, 16);
		frmDecryption.getContentPane().add(label_7);

		Box verticalBox_5 = Box.createVerticalBox();
		verticalBox_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Quick Check for Fitness", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		verticalBox_5.setBounds(352, 492, 290, 149);
		frmDecryption.getContentPane().add(verticalBox_5);

		Box verticalBox_6 = Box.createVerticalBox();
		verticalBox_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"2. Training Module", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		verticalBox_6.setBounds(15, 355, 329, 156);
		frmDecryption.getContentPane().add(verticalBox_6);

		JTextPane txtpnIfYouWant = new JTextPane();
		txtpnIfYouWant.setForeground(Color.BLUE);
		txtpnIfYouWant.setBackground(new Color(230, 230, 250));
		txtpnIfYouWant.setEditable(false);
		txtpnIfYouWant.setEnabled(false);
		txtpnIfYouWant.setText("Click here to encrypt text with a random key,. This will open a new Window");
		txtpnIfYouWant.setBounds(22, 538, 311, 53);
		frmDecryption.getContentPane().add(txtpnIfYouWant);

		Box verticalBox_3 = Box.createVerticalBox();
		verticalBox_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Final Decrypted Text", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		verticalBox_3.setBounds(647, 440, 547, 202);
		frmDecryption.getContentPane().add(verticalBox_3);

		JButton btnBruteforce = new JButton("BruteForce");
		btnBruteforce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BruteForceView b = new BruteForceView();
				b.setVisible(true);
			}
		});
		btnBruteforce.setBounds(118, 669, 117, 29);
		frmDecryption.getContentPane().add(btnBruteforce);

		JLabel lblNewLabel_1 = new JLabel("Total runtime of the algorithm: ");
		lblNewLabel_1.setBounds(647, 670, 214, 16);
		frmDecryption.getContentPane().add(lblNewLabel_1);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox
				.setBorder(new TitledBorder(null, "To Compare", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		horizontalBox.setBounds(15, 645, 329, 67);
		frmDecryption.getContentPane().add(horizontalBox);

		JButton btnUserGuide = new JButton("USER GUIDE!");
		btnUserGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserGuideView ob = new UserGuideView();
				ob.setVisible(true);
			}
		});
		btnUserGuide.setForeground(UIManager.getColor("CheckBox.select"));
		btnUserGuide.setBounds(1036, 683, 168, 29);
		frmDecryption.getContentPane().add(btnUserGuide);

	}
}
