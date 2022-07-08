import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//import addStudent.MyActionListener;

public class Menu extends JFrame {
	JLabel l1, l2;
	
	JPasswordField pass;
	JButton b1, b2, b3;
	JPanel p1, p2, p3;
	

	public Menu() {
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		setLocationRelativeTo(null);
		p1 = new JPanel();
		add(p1, BorderLayout.NORTH);
		l1 = new JLabel("***** WELCOME TO ATM *****");

		p1.setLayout(new FlowLayout());
		p1.setPreferredSize(new Dimension(100, 25));
		p1.add(l1);
		p1.setBackground(Color.GRAY);
		p2 = new JPanel();
		add(p2, BorderLayout.CENTER);
		l2 = new JLabel("Enter PIN:");
		
		pass = new JPasswordField(20);

		p2.add(l2);
		// p2.add(t1);
		p2.add(pass);

		p3 = new JPanel();
		add(p3, BorderLayout.SOUTH);
		b1 = new JButton("SIGN UP");
		b2 = new JButton("SIGN IN");
		b3 = new JButton("Close");
		// p3.setLayout(new FlowLayout());
		p3.setLayout(new GridLayout(3, 1));
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);

		MyActionListener m = new MyActionListener();
		b1.addActionListener(m);
		b2.addActionListener(m);
		b3.addActionListener(m);

		setVisible(true);
	}

	class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Close")) {
				dispose();
			} else if (e.getActionCommand().equals("SIGN UP")) {
				dispose();
				SignUp s = new SignUp();

				// Menu a = new Menu();
			} else if (e.getActionCommand().equals("SIGN IN")) {
				dispose();
				ArrayList<Customer> students = null;
				if ((pass.getText().equals(""))) {
					JOptionPane.showMessageDialog(new JFrame(), "Please Enter your pin code");
					dispose();
					Menu d = new Menu();
				} else {
					int pin = Integer.parseInt(pass.getText());

					try {
						students = FileData.readData();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (students.size() != 0) {

						for (int i = 0; i < students.size(); i++) {
							if (students.get(i).getPinCode() == pin) {
								JOptionPane.showMessageDialog(new JFrame(), "SUCCESSFULL SIGN IN");
								SignInGUI s = new SignInGUI(students.get(i));
								break;
							} else if (i == students.size() - 1) {
								JOptionPane.showMessageDialog(new JFrame(), "INCORRECT PINCODE 	\n        TRY AGAIN");
								dispose();
								Menu a = new Menu();
							}

						}

					} else {
						JOptionPane.showMessageDialog(new JFrame(), "NO CUSTOMER PRESENT");
					}
				}

			}
		}
	}
}
