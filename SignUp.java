import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class SignUp extends JFrame {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l22, l23, lcnic;
	JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t22, t23, tcnic;
	JButton b1, b2;

	public SignUp() {
		setSize(400, 400);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		l1 = new JLabel("Enter Name: ");
		l2 = new JLabel("Enter Father Name: ");
		lcnic = new JLabel("Enter CNIC number ");
		l3 = new JLabel("Phone Number: ");
		l22 = new JLabel("Gender: ");
		l4 = new JLabel("PIN");
		l5 = new JLabel("E-Mail");
		l6 = new JLabel("Enter Date of Birth: Day");
		l7 = new JLabel("Month");
		l8 = new JLabel("Year");
		l9 = new JLabel("Enter Religion");
		l10 = new JLabel("Enter Income");
		l11 = new JLabel("Occuption");
		l12 = new JLabel("Enter Address: H.No");
		l13 = new JLabel("s#no");
		l14 = new JLabel("City Name");
		l23 = new JLabel("Deposit Amount");

		t1 = new JTextField(10);
		t2 = new JTextField(10);
		tcnic = new JTextField(10);

		t3 = new JTextField(10);
		t22 = new JTextField(10);
		t4 = new JTextField(10);
		t5 = new JTextField(10);
		t6 = new JTextField(10);
		t7 = new JTextField(10);
		t8 = new JTextField(10);
		t9 = new JTextField(10);
		t10 = new JTextField(10);
		t11 = new JTextField(10);
		t12 = new JTextField(10);
		t13 = new JTextField(10);
		t14 = new JTextField(10);
		t23 = new JTextField(10);

		b1 = new JButton("Submit");
		b2 = new JButton("Home");
		setLayout(new GridLayout(18, 2));

		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(lcnic);
		add(tcnic);
		add(l3);
		add(t3);
		add(l22);
		add(t22);
		add(l4);
		add(t4);
		add(l5);
		add(t5);
		add(l6);
		add(t6);
		add(l7);
		add(t7);
		add(l8);
		add(t8);
		add(l9);
		add(t9);
		add(l10);
		add(t10);
		add(l11);
		add(t11);
		add(l12);
		add(t12);
		add(l13);
		add(t13);
		add(l14);
		add(t14);
		add(l23);
		add(t23);

		add(b1);
		add(b2);
		MyActionListener m = new MyActionListener();
		b1.addActionListener(m);
		b2.addActionListener(m);
		setVisible(true);
	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Home")) {

				dispose();
				Menu a = new Menu();
			} else if (e.getActionCommand().equals("Submit")) {
				if (t1.getText().equals("") || t1.getText().equals("") || t22.getText().equals("")
						|| t5.getText().equals("") || t9.getText().equals("") || t11.getText().equals("")
						|| t4.getText().equals("") || t3.getText().equals("") || t4.getText().equals("")
						|| Long.parseLong(t3.getText()) > 999999999 || t6.getText().equals("")
						|| tcnic.getText().equals("") || Long.parseLong(tcnic.getText()) > 99999999) {
					JOptionPane.showMessageDialog(new JFrame(), "Please FIll all fields CareFully");
					dispose();
					SignUp d = new SignUp();
				} else {
					String name = t1.getText();
					String fName = t2.getText();
					long cnic = Long.parseLong(tcnic.getText());

					long phone = Long.parseLong(t3.getText());
					String gen = t22.getText();
					int pin = Integer.parseInt(t4.getText());
					String mail = t5.getText();
					int day = Integer.parseInt(t6.getText());
					int month = Integer.parseInt(t7.getText());
					int year = Integer.parseInt(t8.getText());
					String rel = t9.getText();
					Double inc = Double.parseDouble(t10.getText());
					String occ = t11.getText();
					// String houseNo = t12.getText();
					int houseNo = Integer.parseInt(t12.getText());
					int sNo = Integer.parseInt(t13.getText());
					String city = t14.getText();
					Address address = new Address(houseNo, sNo, city);
					Date date = new Date(day, month, year);

					if (name.equals(null)) {
						JOptionPane.showMessageDialog(new JFrame(), "Please Enter Name");
					}

					Double db = Double.parseDouble(t23.getText());

					Customer customer = new Customer(name, fName, phone, gen, pin, mail, date, rel, inc, occ, address,
							db, cnic);
					try {
						FileData.writeToFile(customer);
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(new JFrame(), "SuccessFul SignUp. Welcome");
					dispose();
					Menu d = new Menu();
				}
			}
		}

	}
}