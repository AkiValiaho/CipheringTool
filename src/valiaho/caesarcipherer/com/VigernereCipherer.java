package valiaho.caesarcipherer.com;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class VigernereCipherer extends JFrame{

	private JFrame frmVigernereCipherer;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VigernereCipherer window = new VigernereCipherer();
					window.frmVigernereCipherer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VigernereCipherer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVigernereCipherer = new JFrame();
		frmVigernereCipherer.setTitle("Vigernere Cipherer");
		frmVigernereCipherer.setBounds(100, 100, 972, 581);
		frmVigernereCipherer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		frmVigernereCipherer.setJMenuBar(menuBar);
		
		JButton btnNewButton_2 = new JButton("Caesar Cipher");
		menuBar.add(btnNewButton_2);
		frmVigernereCipherer.getContentPane().setLayout(new MigLayout("", "[189.00,grow][grow]", "[][][][:80.00:180,grow][-113.00][grow]"));
		
		JLabel lblNewLabel = new JLabel("Enter your cipherkey");
		frmVigernereCipherer.getContentPane().add(lblNewLabel, "cell 0 0");
		
		textField = new JTextField();
		frmVigernereCipherer.getContentPane().add(textField, "cell 0 1,growx");
		textField.setColumns(10);
		
		JLabel lblEnterYourPlaintext = new JLabel("Enter your plaintext");
		frmVigernereCipherer.getContentPane().add(lblEnterYourPlaintext, "cell 0 2");
		
		JTextArea textAreaPlainText = new JTextArea();
		frmVigernereCipherer.getContentPane().add(textAreaPlainText, "cell 0 3,grow");
		JLabel lblEnterYourCiphertext = new JLabel("Enter your ciphertext");
		JButton btnNewButton = new JButton("Cipher");
		JTextArea textArea_1 = new JTextArea();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ICiphererRelated vigenereCase = new VigernereCipherActionObject();
				 vigenereCase.setPossibleKeyword(textField.getText());
				 vigenereCase.setPlainText(textAreaPlainText.getText());
				 vigenereCase.cipher(textArea_1);
			}
		});
		frmVigernereCipherer.getContentPane().add(btnNewButton, "flowx,cell 1 3,aligny bottom");
		
		
		frmVigernereCipherer.getContentPane().add(lblEnterYourCiphertext, "cell 0 4");
		
		
		frmVigernereCipherer.getContentPane().add(textArea_1, "cell 0 5,grow");
		
		JButton btnNewButton_1 = new JButton("Decipher");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		frmVigernereCipherer.getContentPane().add(btnNewButton_1, "cell 1 3,aligny bottom");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame newCaesarFrame = new CaesarCipherer();
				frmVigernereCipherer.dispose();
			}
		});
		frmVigernereCipherer.setVisible(true);
	}
	

}
