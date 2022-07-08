import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileData {
	public static void writeToFile(Customer s) throws IOException {
		ObjectOutputStream oos = null;
		try {
			ArrayList<Customer> std = readData();
			std.add(s);
			File f = new File("List.ser");
			oos = new ObjectOutputStream(new FileOutputStream(f));
			for (int i = 0; i < std.size(); i++) {
				oos.writeObject(std.get(i));
			}

		} catch (IOException e) {
			System.out.println("IO Exception ");
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				System.out.println("IOException occur:");
			}
		}
	}

	public static ArrayList<Customer> readData() throws IOException {
		ArrayList<Customer> std = new ArrayList<>(0);
		ObjectInputStream ois = null;
		try {
			
			ois = new ObjectInputStream(new FileInputStream("List.ser"));
			boolean EOF = false;
			while (!EOF) {
				try {
					Customer obj = (Customer) ois.readObject();
					std.add(obj);
				} catch (ClassNotFoundException s) {

				} catch (EOFException e) {
					EOF = true;
				}
			}
		} catch (FileNotFoundException s) {
			return std;
		} catch (IOException e) {

		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				System.out.println("IOException occur:");
			}
		}
		return std;
	}

	public static void cashAdd(String name, int cash) throws IOException {
		ArrayList<Customer> list = readData();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getCustomerName().equals(name)) {
				double x = list.get(i).getDepositBalance();
				double addCash = (x + cash);
				list.get(i).setDepositBalance(addCash);
			}
		}
		try {
			File f = new File("List.ser");
			f.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Customer s : list) {
			FileData.writeToFile(s);
		}
	}

	public static void cashWithdraw(String name, int cash) throws IOException {
		ArrayList<Customer> list = readData();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getCustomerName().equals(name)) {
				double x = list.get(i).getDepositBalance();
				double minus = x - cash;
				list.get(i).setDepositBalance(minus);
			}
		}
		try {
			File f = new File("List.ser");
			f.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Customer s : list) {
			FileData.writeToFile(s);
		}
	}

	public static void Display(String CN, String FN) throws IOException {
		ArrayList<Customer> list = readData();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getCustomerName().equalsIgnoreCase(CN)
					&& list.get(i).getFatherName().equalsIgnoreCase(FN)) {
				JOptionPane.showMessageDialog(new JFrame(), list.get(i).toString());
			}
		}
		try {
			File f = new File("List.ser");
			f.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Customer s : list) {
			FileData.writeToFile(s);
		}
	}

	public static void checkBalance(String name, long check) throws IOException {
		ArrayList<Customer> list = readData();

		for (int i = 0; i < list.size(); i++) {

			if ((list.get(i).getCustomerName().equals(name))) {
				JOptionPane.showMessageDialog(new JFrame(), "Availabel balance " + list.get(i).getDepositBalance());
			}
		}
		try {
			File f = new File("List.ser");
			f.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Customer s : list) {
			FileData.writeToFile(s);
		}
	}

	public static void changePin(String n, int oldPin, int newPin) throws IOException {
		ArrayList<Customer> list = readData();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCustomerName().equals(n) && list.get(i).getPinCode() == oldPin) {
				list.get(i).setPinCode(newPin);

			}
		}
		try {
			File f = new File("List.ser");
			f.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Customer s : list) {
			FileData.writeToFile(s);
		}
	}
}
