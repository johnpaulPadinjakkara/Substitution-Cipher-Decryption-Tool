/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.messaging.saaj.util.TeeInputStream;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import java.awt.Color;

/*@UserGuideView.java*/
/**
 * @author: Bharathi
 * @Student_Number: 201595964
 * @email: bs6523@mun.ca
 */
public class UserGuideView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public UserGuideView() {
		setBounds(100, 100, 519, 503);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 507, 417);
		contentPanel.add(scrollPane);

		JTextPane txtpnMainFlow = new JTextPane();
		txtpnMainFlow.setBackground(new Color(230, 230, 250));
		txtpnMainFlow.setEditable(false);
		txtpnMainFlow.setText(
				"Main Flow: \n1. Enter the Cipher Text,  Encrypted using Substitution Cipher in the Panel 1\n\ta. if you don’t have the Cipher Text you can generated from “Generate Cipher Text” Panel\n2. Upload training file from “Training Module” and Click “Train” to train the system, a sample Training file is provided, N-Grams also can be selected before training, (its must to train the system before use)\n3. Select the Parameters for the Decryption algorithm, \n4. The system will show a progress bar depending on the generation size, when its done it will popup with Decrypted text, Key, and other related informations, \n\nExtra Functions:\n1. Generate Cipher Text\na. using this module you can encrypts any English text into Cipher text, \nb. Copy and past Plane text and click Encrypt\nc. you can also upload Text file to encrypt \nd. the encrypted key will be displayed in the “Encrypted key” section, \n\n2. Quick Check for Fitness \na. user can check the fitness of any key using this module, \n\n3. To Compare (bruteForce)\na. in this the user can check the time complexity of the bruteForce method, \n");
		scrollPane.setViewportView(txtpnMainFlow);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						setVisible(false);
						
					
						System.out.println("This goes to out.txt");
						

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
