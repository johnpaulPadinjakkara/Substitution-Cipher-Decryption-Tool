/**
 * 
 */
package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ComparisonAlgorithm_BruteForce.BruteForce;
import ComparisonAlgorithm_BruteForce.BruteForce.Permutation;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*@BruteForceView.java*/
/**
 * @author: Bharathi, Johnpaul
 * @Student_Number: 201595964, 201599234
 * @email: mailto:bs6523@mun.ca, jjpadinjakka@mun.ca
 */

public class BruteForceView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	boolean stop;
	JProgressBar progressBar = new JProgressBar();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */

	public void run1() {
		double x = 0.0;
		while (true) {
			x++;
			System.out.println("Djnojkn");
			progressBar.setValue((int) x);
			progressBar.update(progressBar.getGraphics());
		}

	}

	public BruteForceView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 684, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterKeyFor = new JLabel("Enter Key For Permutation:");
		lblEnterKeyFor.setBounds(87, 47, 181, 16);
		contentPane.add(lblEnterKeyFor);

		textField = new JTextField();
		textField.setBounds(87, 68, 407, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblTimeTakenTo = new JLabel("Time Taken to Gnerate Combinations: ");
		lblTimeTakenTo.setBounds(87, 129, 279, 16);
		contentPane.add(lblTimeTakenTo);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(350, 129, 298, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(350, 157, 61, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNumberOfKey = new JLabel("Number of key generated: ");
		lblNumberOfKey.setBounds(87, 157, 236, 16);
		contentPane.add(lblNumberOfKey);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblNewLabel_1.setText("");
				lblNewLabel.setText("");
				lblNewLabel_1.update(lblNewLabel_1.getGraphics());
				lblNewLabel.update(lblNewLabel.getGraphics());

				// ArrayList<Character> key = new ArrayList<>();
				// String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				int keycount = 0;
				String key = textField.getText();
				key = key.toUpperCase();
				stop = true;

				String str = key;
				int n = str.length();
				// Permutation permutation = new Permutation();

				BruteForce.count = 0;

				if (key.length() > 9) {

					int dialogResult = JOptionPane.showConfirmDialog(null,
							"Key is BIG, it might take long time, do you wish to continue? ");
					if (dialogResult == JOptionPane.NO_OPTION) {
						stop = false;
					} else if (dialogResult == JOptionPane.YES_OPTION) {
						stop = true;
					}

				}

				long progStartTime = System.currentTimeMillis();

				if (stop) {
					keycount = Permutation.permute(str, 0, n - 1);
				}

				lblNewLabel_1.setText("" + keycount);

				// The fitness calculation for each key is not performed as the time required
				// for generating the permutations of
				// keys is a good indication of the performance (and found that keysize of 26 is
				// not practical by brute force method)

				System.out.println("\nFinal Program run time " + ((System.currentTimeMillis() - progStartTime)) / 1000.0
						+ " Seconds");

				lblNewLabel.setText((System.currentTimeMillis() - progStartTime) / 1000.0 + " Seconds");

			}
		});
		btnStart.setBounds(506, 68, 117, 29);
		contentPane.add(btnStart);

		progressBar.setBounds(87, 181, 536, 20);
		contentPane.add(progressBar);

	}

}
