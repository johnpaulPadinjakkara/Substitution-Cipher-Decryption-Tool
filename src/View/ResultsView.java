/**
 * 
 */
package View;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

/*@ResultsView.java*/
/**
 * @author: Bharathi, Johnpaul
 * @Student_Number: 201595964, 201599234
 * @email: mailto:bs6523@mun.ca, jjpadinjakka@mun.ca
 */
public class ResultsView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */

	//converting ms to HH:MM:SS
	public static String msToString(long ms) {
		long totalSecs = ms / 1000;
		long hours = (totalSecs / 3600);
		long mins = (totalSecs / 60) % 60;
		long secs = totalSecs % 60;
		String minsString = (mins == 0) ? "00" : ((mins < 10) ? "0" + mins : "" + mins);
		String secsString = (secs == 0) ? "00" : ((secs < 10) ? "0" + secs : "" + secs);
		if (hours > 0)
			return hours + " Hours: " + minsString + " Minute: " + secsString + " Seconds ";
		else if (mins > 0)
			return hours + " Hours: " + minsString + " Minute: " + secsString + " Seconds ";
		else
			return hours + " Hours: " + minsString + " Minute: " + secsString + " Seconds ";
	}

	public ResultsView(String DecMessage, String popSize, String CrxRate, String MutRate, String TournSize,
			String maxCrossoverpoint, String GenCount, String Ngramsize, String AvgFit, String Fitness,
			ArrayList<Character> FinalKey, long Endtime, String WorstFit) {
		setResizable(false);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 100, 740, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane textPaneBestInd = new JTextPane();
		textPaneBestInd.setBounds(68, 58, 590, 38);
		contentPane.add(textPaneBestInd);

		JLabel lblFitness = new JLabel("Fitness : ");
		lblFitness.setBounds(68, 98, 61, 16);
		contentPane.add(lblFitness);

		JLabel lblNewLabelFitnessValue = new JLabel("New label");
		lblNewLabelFitnessValue.setBounds(127, 98, 141, 16);
		contentPane.add(lblNewLabelFitnessValue);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 144, 590, 187);
		contentPane.add(scrollPane);

		JTextPane textPaneDeText = new JTextPane();
		scrollPane.setViewportView(textPaneDeText);

		JLabel lblPopulationSze = new JLabel("Population Sze: ");
		lblPopulationSze.setBounds(68, 350, 141, 16);
		contentPane.add(lblPopulationSze);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(360, 390, 225, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabelPopsize = new JLabel("New label");
		lblNewLabelPopsize.setBounds(186, 350, 114, 16);
		contentPane.add(lblNewLabelPopsize);

		JLabel lblNewLabel = new JLabel("Tournment Size:");
		lblNewLabel.setBounds(68, 370, 123, 16);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("New label");
		label.setBounds(186, 370, 114, 16);
		contentPane.add(label);

		JLabel lblCrossoverRate = new JLabel("Crossover Rate:");
		lblCrossoverRate.setBounds(68, 390, 123, 16);
		contentPane.add(lblCrossoverRate);

		JLabel lblMutationRate = new JLabel("Mutation Rate:");
		lblMutationRate.setBounds(68, 410, 123, 16);
		contentPane.add(lblMutationRate);

		JLabel lblMaxCrossoverPoints = new JLabel("Max Crossover points:");
		lblMaxCrossoverPoints.setBounds(68, 430, 153, 16);
		contentPane.add(lblMaxCrossoverPoints);

		JLabel lblGenerations = new JLabel("Generations: ");
		lblGenerations.setBounds(68, 452, 97, 16);
		contentPane.add(lblGenerations);

		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(186, 390, 114, 16);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(186, 410, 114, 16);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(219, 430, 79, 16);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(156, 452, 107, 16);
		contentPane.add(label_4);

		JLabel lblAverageFitnessOf = new JLabel("Average Fitness of Final Population: ");
		lblAverageFitnessOf.setBounds(360, 350, 243, 16);
		contentPane.add(lblAverageFitnessOf);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(353, 343, 1, 130);
		contentPane.add(verticalStrut);

		JLabel lblNgramSize = new JLabel("N-Gram Size:");
		lblNgramSize.setBounds(68, 470, 97, 16);
		contentPane.add(lblNgramSize);

		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(160, 470, 97, 16);
		contentPane.add(label_5);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(615, 350, 119, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(483, 410, 141, 16);
		contentPane.add(lblNewLabel_4);

		textPaneBestInd.setText(FinalKey.toString());
		lblNewLabelFitnessValue.setText(Fitness);
		lblNewLabelPopsize.setText(popSize);
		label.setText(TournSize);
		label_1.setText(CrxRate);
		label_2.setText(MutRate);
		textPaneDeText.setText(DecMessage);
		label_3.setText(maxCrossoverpoint);
		label_4.setText(GenCount);
		label_5.setText(Ngramsize);
		lblNewLabel_1.setText(AvgFit);
		lblNewLabel_3.setText(msToString(Endtime));
		lblNewLabel_4.setText(WorstFit);

		JLabel lblNewLabel_2 = new JLabel(
				"[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]");
		lblNewLabel_2.setBounds(68, 40, 463, 16);
		contentPane.add(lblNewLabel_2);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox
				.setBorder(new TitledBorder(null, "Final Key", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		horizontalBox.setBounds(52, 22, 622, 100);
		contentPane.add(horizontalBox);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Decrypted Message", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		horizontalBox_1.setBounds(52, 126, 622, 215);
		contentPane.add(horizontalBox_1);

		JLabel lblTotalR = new JLabel("Total runtime of the algorithm:");
		lblTotalR.setBounds(360, 370, 225, 16);
		contentPane.add(lblTotalR);

		JLabel lblWorstFitness = new JLabel("Worst Fitness : ");
		lblWorstFitness.setBounds(360, 410, 123, 16);
		contentPane.add(lblWorstFitness);

		Component verticalGlue = Box.createVerticalGlue();
		verticalGlue.setBounds(353, 343, 1, 1);
		contentPane.add(verticalGlue);

		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalGlue_1.setBounds(336, 343, 7, 138);
		contentPane.add(verticalGlue_1);

	}
}
