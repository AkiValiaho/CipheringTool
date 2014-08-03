package valiaho.caesarcipherer.com;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class VigernereCipherer extends JFrame{

	private JFrame frmVigernereCipherer;

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
