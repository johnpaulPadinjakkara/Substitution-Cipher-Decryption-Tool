/**
 * 
 */
package View;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

/*@NgramView.java*/
/**
 * @author: Bharathi, Johnpaul
 * @Student_Number: 201595964, 201599234
 * @email: mailto:bs6523@mun.ca, jjpadinjakka@mun.ca
 */
public class NgramView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblSizeOfn;
	private JLabel lblNewLabelSizeofn;

	/**
	 * Create the frame.
	 */
	public NgramView(String text, int ngrm) {
		setResizable(false);
		setTitle("Ngram View");

		HashMap<String, Integer> result_ngram = new HashMap<>();
		result_ngram = Model.Ngrams.Ngram(text, ngrm);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(600, 100, 220, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		scrollPane_1.setBounds(6, 40, 208, 414);
		contentPane.add(scrollPane_1);

		table = new JTable(new DefaultTableModel(null, new Object[] { "n-Gram", "Count" }));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setForeground(Color.BLACK);

		// adding Ngrams to table
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (HashMap.Entry<String, Integer> entry : result_ngram.entrySet()) {
			model.addRow(new Object[] { entry.getKey(), entry.getValue() });
		}

		scrollPane_1.setViewportView(table);

		lblSizeOfn = new JLabel("Size of 'n' =");
		lblSizeOfn.setBounds(6, 12, 83, 16);
		contentPane.add(lblSizeOfn);

		lblNewLabelSizeofn = new JLabel();
		lblNewLabelSizeofn.setBounds(90, 12, 61, 16);
		contentPane.add(lblNewLabelSizeofn);
		lblNewLabelSizeofn.setText(ngrm + "");

	}
}
