import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import CashDeposit.MyActionListener;

public class cashWithdraw extends JFrame {
	JLabel l1, l2, l3;
	JTextField t1, t2;
	JButton b1, b2, b3;
	JPanel p1, p2, p3;

	public cashWithdraw(Customer c) {
		setSize(400, 400);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p1 = new JPanel();
		add(p1, BorderLayout.NORTH);
		l1 = new JLabel(" WITHDRAW AMOUNT");
		p1.add(l1);

		p2 = new JPanel();
		add(p2, BorderLayout.CENTER);

		t2 = new JTextField(10);

		l3 = new JLabel("Enter Amount");
		b1 = new JButton("WITHDRAW");
		b2 = new JButton("BACK");

		p2.add(l3);
		p2.add(t2);
		p2.add(b1);
		p2.add(b2);
		p2.setLayout(new GridLayout(3, 1));

		p3 = new JPanel();
		add(p3, BorderLayout.SOUTH);
		b3 = new JButton("Exit");
		p3.add(b3);

		MyActionListener m = new MyActionListener(c);
		b1.addActionListener(m);
		b2.addActionListener(m);
		b3.addActionListener(m);
		setVisible(true);
	}

	class MyActionListener implements ActionListener {
		Customer c;

		MyActionListener(Customer c) {
			this.c = c;
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("BACK")) {
				setVisible(false);
				SignInGUI d = new SignInGUI(c);

			} else if (e.getActionCommand().equals("Exit")) {
				dispose();
			} else if (e.getActionCommand().equals("WITHDRAW")) {

				if (t2.getText().equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "Please enter amount");
					dispose();
					cashWithdraw d = new cashWithdraw(c);
				} else {
					String name = c.getCustomerName();
					int cash = Integer.parseInt(t2.getText());

					try {

						if (c.getDepositBalance() - cash >= 0 && cash < 5000) {
							FileData.cashWithdraw(name, cash);
							JOptionPane.showMessageDialog(new JFrame(), "Cash WithDraw");
							dispose();
							SignInGUI d = new SignInGUI(c);
						} else {
							JOptionPane.showMessageDialog(new JFrame(), "You have no enough balanve");
							JOptionPane.showMessageDialog(new JFrame(), "Or you enter amount more than 5000");
						}

					} catch (IOException e1) {

						e1.printStackTrace();
					}

				}
			}
		}
	}
}
