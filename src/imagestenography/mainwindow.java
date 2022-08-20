package imagestenography;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class mainwindow {

	private JFrame frame;
	private JTextField messageField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainwindow window = new mainwindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel buttonspanel = new JPanel();
		frame.getContentPane().add(buttonspanel, BorderLayout.SOUTH);
		buttonspanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton encrpytButton = new JButton("Encrypt");
		encrpytButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonspanel.add(encrpytButton);
		
		JButton decryptButton = new JButton("Decrypt");
		decryptButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonspanel.add(decryptButton);
		
		JPanel messagepanel = new JPanel();
		frame.getContentPane().add(messagepanel, BorderLayout.CENTER);
		messagepanel.setLayout(null);
		
		JLabel messagelabel = new JLabel("Message :");
		messagelabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		messagelabel.setBounds(38, 81, 107, 40);
		messagepanel.add(messagelabel);
		
		messageField = new JTextField();
		messageField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		messageField.setBounds(142, 80, 223, 45);
		messagepanel.add(messageField);
		messageField.setColumns(10);
		
		
		ActionListener encryptListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File imageFile = FileChooser.MakeFileChooser();
				if(imageFile!=null) {
					encryptLSB.Encrypt(imageFile, messageField.getText());
				}
				
			}
			
		};
		decryptButton.addActionListener(encryptListener);
		
		ActionListener decryptListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DecryptLSB.Decrypt();
			}
			
		};
		decryptButton.addActionListener(encryptListener);
	}
}
