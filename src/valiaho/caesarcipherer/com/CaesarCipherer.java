package valiaho.caesarcipherer.com;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;

public class CaesarCipherer extends JFrame{

	private JFrame frmCaesarsCipher;
	private JTextArea txtrEnterYourCipher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaesarCipherer window = new CaesarCipherer();
					window.frmCaesarsCipher.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CaesarCipherer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ICiphererRelated DeciphererCase = new CaesarDecipheringActionObject();
		ICiphererRelated CiphererCase = new CaesarCipherActionObject();
		frmCaesarsCipher = new JFrame();
		frmCaesarsCipher.setTitle("Caesar Cipherer");
		frmCaesarsCipher.setBounds(100, 100, 972, 581);
		frmCaesarsCipher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCaesarsCipher.getContentPane().setLayout(new MigLayout("", "[67.00,grow][][][][][][][161.00][147.00][145.00,grow]", "[46.00][][grow][][][44.00,grow][][][][]"));
		
		JTextArea txtrEnterYourPlain = new JTextArea();
		txtrEnterYourPlain.setText("Enter your plain text here");
		frmCaesarsCipher.getContentPane().add(txtrEnterYourPlain, "cell 0 0 9 5,grow");
		
		JLabel lblNumberOfShifts = new JLabel("Number of shifts");
		frmCaesarsCipher.getContentPane().add(lblNumberOfShifts, "flowx,cell 9 0,aligny top");
		JLabel lblNewLabel = new JLabel("0");
		JSlider slider = new JSlider();
		slider.setMaximum(25);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblNewLabel.setText(Integer.toString(slider.getValue()));
			}
		});
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setValue(0);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		frmCaesarsCipher.getContentPane().add(slider, "flowy,cell 9 1,growx");	
		JButton btnNewButton = new JButton("Cipher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CiphererCase.setNumberOfShifts(slider.getValue() % 26);
				CiphererCase.setPlainText(txtrEnterYourPlain.getText());
				CiphererCase.cipher(txtrEnterYourCipher);
			}
		});
		frmCaesarsCipher.getContentPane().add(btnNewButton, "flowx,cell 9 2,growx,aligny center");
		txtrEnterYourCipher = new JTextArea();
		txtrEnterYourCipher.setText("Enter your cipher text here");
		frmCaesarsCipher.getContentPane().add(txtrEnterYourCipher, "cell 0 5 9 5,grow");
		JButton btnNewButton_1 = new JButton("Decipher");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DeciphererCase.setNumberOfShifts(slider.getValue() % 26);
				DeciphererCase.setPlainText(txtrEnterYourCipher.getText());
				DeciphererCase.decipher(txtrEnterYourCipher,txtrEnterYourPlain);
				
			}
		});
		frmCaesarsCipher.getContentPane().add(btnNewButton_1, "cell 9 2,growx,aligny center");
		frmCaesarsCipher.getContentPane().add(lblNewLabel, "cell 9 0,aligny top");
		
		JMenuBar menuBar = new JMenuBar();
		frmCaesarsCipher.setJMenuBar(menuBar);
		
		JButton btnNewButton_3 = new JButton("Vigernere");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCaesarsCipher.dispose();
				VigernereCipherer vigernereFrame = new VigernereCipherer();
			}
		});
		menuBar.add(btnNewButton_3);
		frmCaesarsCipher.setVisible(true);
	}

}
