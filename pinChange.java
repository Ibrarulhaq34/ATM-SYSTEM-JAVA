import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

//import SignInGUI.MyActionListener;

public class pinChange extends JFrame {
	JLabel l1, l2, l3, l4, l33;
	JTextField t1, t2, t3, t4, t33;
	JButton b1, b2;
	JPanel p1, p2, p3;

	public pinChange(Customer c) {
		setSize(400, 400);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p1 = new JPanel();
		add(p1, BorderLayout.NORTH);

		l1 = new JLabel("CHANGE YOUR PIN");
		p1.add(l1);

		p2 = new JPanel();
		add(p2, BorderLayout.CENTER);
		
		l33 = new JLabel("Old PIN");
		t33 = new JTextField(10);
		l3 = new JLabel("New PIN");
		t3 = new JTextField(10);
		l4 = new JLabel("Re-Enter New PIN");
		t4 = new JTextField(10);
		p2.setLayout(new GridLayout(4, 2));

		p2.add(l33);
		p2.add(t33);
		p2.add(l3);
		p2.add(t3);
		p2.add(l4);
		p2.add(t4);

		p3 = new JPanel();
		add(p3, BorderLayout.SOUTH);
		b1 = new JButton("SAVE");
		b2 = new JButton("BACK");
		p3.setLayout(new FlowLayout());
		p3.add(b1);
		p3.add(b2);

		MyActionListener m = new MyActionListener(c);
		b1.addActionListener(m);
		b2.addActionListener(m);
		setVisible(true);
	}

	class MyActionListener implements ActionListener {
		Customer c;

		MyActionListener(Customer c) {
			this.c = c;
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("BACK")) {
				
				dispose();
				SignInGUI d = new SignInGUI(c);
			} else if (e.getActionCommand().equals("SAVE")) {
				if (t33.getText().equals("") || t3.getText().equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "Please fill all text fields");
					dispose();
					pinChange d = new pinChange(c);
				} else {
					String name = c.getCustomerName();
					int oldPin = Integer.parseInt(t33.getText());
					int newPin = Integer.parseInt(t3.getText());
					int Re_Enter_newPin = Integer.parseInt(t4.getText());
					try {
						if (newPin == Re_Enter_newPin) {
							FileData.changePin(name, oldPin, newPin);

							JOptionPane.showMessageDialog(new JFrame(), "PIN Updated successfully");
							dispose();
							SignInGUI d = new SignInGUI(c);
						} else {
							JOptionPane.showMessageDialog(new JFrame(), "New pins are not same");
							SignInGUI d = new SignInGUI(c);
						}

					} catch (IOException e1) {

						e1.printStackTrace();
					}

				}
			}
		}
	}
}
