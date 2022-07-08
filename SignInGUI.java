import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class SignInGUI extends JFrame {
	JButton b1, b2, b3, b4, b5, b6;
	JLabel l1, l2;
	JPanel p1, p2, p3;

	public SignInGUI(Customer c) {
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p1 = new JPanel();
		add(p1, BorderLayout.NORTH);
		l1 = new JLabel("Welcome dear  :" + c.getCustomerName());
		l2 = new JLabel("..Please Select Your Transaction");
		p1.add(l1);
		p1.add(l2);
		p2 = new JPanel();
		add(p2, BorderLayout.CENTER);

		b1 = new JButton("DEPOSIT");
		b2 = new JButton("CASH WITHDRAW");
		b3 = new JButton("CHANGE PIN");
		b4 = new JButton("DISPLAY YOUR INFORMATION");
		b5 = new JButton("DISPLAY BALANCE");
		b6 = new JButton("BACK");
		p2.setLayout(new FlowLayout());

		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		MyActionListener m = new MyActionListener(c);
		b1.addActionListener(m);
		b2.addActionListener(m);
		b3.addActionListener(m);
		b4.addActionListener(m);
		b5.addActionListener(m);
		b6.addActionListener(m);
		setVisible(true);
	}

	class MyActionListener implements ActionListener {
		Customer c;

		MyActionListener(Customer c) {
			this.c = c;
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("DEPOSIT")) {
				dispose();

				CashDeposit d = new CashDeposit(c);

			} else if (e.getActionCommand().equals("CASH WITHDRAW")) {
				dispose();
				cashWithdraw d = new cashWithdraw(c);
			} else if (e.getActionCommand().equals("CHANGE PIN")) {
				dispose();
				pinChange d = new pinChange(c);
			} else if (e.getActionCommand().equals("DISPLAY YOUR INFORMATION")) {

				String cName = c.getCustomerName();
				String fName = c.getFatherName();
				try {
					dispose();
					FileData.Display(cName, fName);
					SignInGUI d = new SignInGUI(c);

				} catch (IOException e1) {
			
					e1.printStackTrace();
				}
			} else if (e.getActionCommand().equals("DISPLAY BALANCE")) {

				String name = c.getCustomerName();

				long cnic = c.getCNIC();
				try {
					dispose();
					FileData.checkBalance(name, cnic);

					SignInGUI d = new SignInGUI(c);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			} else if (e.getActionCommand().equals("BACK")) {

				dispose();
				Menu m = new Menu();
			}
		}
	}
}
