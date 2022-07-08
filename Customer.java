import java.io.Serializable;

public class Customer extends Person implements Serializable {
	private long CNIC;
	private int pinCode;
	private String eMail;
	private Date dateOfBirth;
	private String religion;
	private double income;
	private String occuption;
	private double depositBalance;
	private Address address;

	public Customer() {
		super();
		dateOfBirth = new Date();
		address = new Address();

	}

	public Customer(String cn, String fn, long p, String g, int pc, String em, Date d, String re, double in, String oc,
			Address ad, double db,long cnic) {
		super(cn, fn, p, g);
		pinCode = pc;
		eMail = em;
		dateOfBirth = d;
		religion = re;
		income = in;
		occuption = oc;
		address = ad;
		depositBalance = db;
		CNIC = cnic;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getOccuption() {
		return occuption;
	}

	public void setOccuption(String occuption) {
		this.occuption = occuption;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getDepositBalance() {
		return depositBalance;
	}

	public void setDepositBalance(double depositBalance) {
		this.depositBalance = depositBalance;
	}

	public long getCNIC() {
		return CNIC;
	}

	public void setCNIC(long cNIC) {
		CNIC = cNIC;
	}

	@Override
	public String toString() {
		return super.toString() + ", eMail=" + eMail + ", dateOfBirth=" + dateOfBirth + ", religion="
				+ religion + ", income=" + income + ", occuption=" + occuption + ", depositBalance=" + depositBalance
				+ ", address=" + address + "" + "ID Card no."+ CNIC;
	}

}
