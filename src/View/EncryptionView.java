/**
 * 
 */
package View;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import java.awt.datatransfer.*;
import java.awt.Toolkit;
import Model.Encryption;
import Model.FileInputOutput;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.datatransfer.StringSelection;

/*@EncryptionView.java*/
/**
 * @author: Bharathi, Johnpaul
 * @Student_Number: 201595964, 201599234
 * @email: mailto:bs6523@mun.ca, jjpadinjakka@mun.ca
 */
public class EncryptionView {

	JFrame frmEncryption;
	static String filePath = "";

	/**
	 * Create the application.
	 */
	public EncryptionView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEncryption = new JFrame();
		frmEncryption.setResizable(false);
		frmEncryption.setTitle("Encryption");
		frmEncryption.setBounds(100, 100, 1100, 650);
		frmEncryption.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmEncryption.getContentPane().setLayout(null);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new TitledBorder(null, "Plane Text", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		verticalBox.setBounds(27, 104, 431, 356);
		frmEncryption.getContentPane().add(verticalBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		verticalBox.add(scrollPane);

		JTextPane txtpnYourPlainText = new JTextPane();

		txtpnYourPlainText.setText("Your plain text here");
		scrollPane.setViewportView(txtpnYourPlainText);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Encryped Text",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		verticalBox_1.setBounds(611, 104, 431, 356);
		frmEncryption.getContentPane().add(verticalBox_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("");
		verticalBox_1.add(scrollPane_1);

		JTextPane textPaneEncryped = new JTextPane();
		textPaneEncryped.setEditable(false);
		scrollPane_1.setViewportView(textPaneEncryped);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(
				new TitledBorder(null, "Encryption Key", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		horizontalBox.setBounds(611, 494, 431, 77);
		frmEncryption.getContentPane().add(horizontalBox);

		JScrollPane scrollPane_2 = new JScrollPane();
		horizontalBox.add(scrollPane_2);

		JTextPane textPaneKey = new JTextPane();
		textPaneKey.setBackground(SystemColor.textHighlight);
		scrollPane_2.setViewportView(textPaneKey);

		JButton btnEncrypt = new JButton("Encrypt ->>");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Encryption.encrypt(textPane_PlaneText.getText())
				textPaneEncryped.setText(Encryption.encrypt(txtpnYourPlainText.getText()));
				textPaneKey.setText(Encryption.key.replace(",", "").replace("[", "").replace("]", ""));
				// textPaneEncryped.setText(textPane_PlaneText.getText());
			}
		});
		btnEncrypt.setBounds(470, 262, 117, 56);
		frmEncryption.getContentPane().add(btnEncrypt);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1100, 82);
		frmEncryption.getContentPane().add(panel);

		JLabel lblS = new JLabel("Encryption:");
		lblS.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblS.setBounds(24, 18, 140, 16);
		panel.add(lblS);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(411, 0, 89, 86);
		panel.add(label_1);

		JLabel lblEncryptionUsingSub = new JLabel("Encryption using Substitution Cipher");
		lblEncryptionUsingSub.setBounds(24, 34, 265, 16);
		panel.add(lblEncryptionUsingSub);

		JLabel lblUploadTextFile_1 = new JLabel("Upload Text File:");
		lblUploadTextFile_1.setBounds(211, 477, 126, 16);
		frmEncryption.getContentPane().add(lblUploadTextFile_1);

		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(frmEncryption);
				if (result == JFileChooser.APPROVE_OPTION) {

					File selectedFile = fileChooser.getSelectedFile();

					filePath = selectedFile.getPath();

					System.out.println(filePath);

					try {
						txtpnYourPlainText.setText(FileInputOutput.readFile(filePath));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnUpload.setBounds(341, 472, 117, 29);
		frmEncryption.getContentPane().add(btnUpload);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showSaveDialog(frmEncryption);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					FileOutputStream stream = null;
					PrintStream out = null;
					try {
						File file = chooser.getSelectedFile();
						stream = new FileOutputStream(file);
						String text = textPaneEncryped.getText();
						out = new PrintStream(stream);
						out.print(text); // This will overwrite existing contents

					} catch (Exception ex) {

					} finally {
						try {
							if (stream != null)
								stream.close();
							if (out != null)
								out.close();
						} catch (Exception ex) {

						}
					}
				}

			}
		});
		btnSave.setBounds(925, 464, 117, 29);
		frmEncryption.getContentPane().add(btnSave);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneEncryped.setText("");
			}
		});
		btnClear.setBounds(810, 464, 117, 29);
		frmEncryption.getContentPane().add(btnClear);

		JButton btnCopy = new JButton("Copy");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String myString = textPaneEncryped.getText();
				StringSelection stringSelection = new StringSelection(myString);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		});
		btnCopy.setBounds(695, 464, 117, 29);
		frmEncryption.getContentPane().add(btnCopy);

		JButton button = new JButton("Clear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtpnYourPlainText.setText("");

			}
		});
		button.setBounds(27, 472, 117, 29);
		frmEncryption.getContentPane().add(button);

		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 99, 71));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEncryption.setVisible(false);
			}
		});
		btnBack.setBounds(27, 561, 117, 29);
		frmEncryption.getContentPane().add(btnBack);

	}
}
