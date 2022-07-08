import java.io.Serializable;

public class Person implements Serializable {
	protected String customerName;
	protected String fatherName;
	protected long phone;
	protected String gender;

	public Person() {

	}

	public Person(String cn, String fn, long p, String g) {
		customerName = cn;
		fatherName = fn;
		phone = p;
		gender = g;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "customerName: " + customerName + " fatherName: " + fatherName + " phone: " + phone + " gender: "
				+ gender + "";
	}

}
