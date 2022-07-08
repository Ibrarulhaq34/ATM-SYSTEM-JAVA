import java.io.Serializable;

public class Address implements Serializable {
	private int home;
	private int street;
	private String city;

	public Address() {

	}

	public Address(int h, int s, String c) {
		home = h;
		street = s;
		city = c;
	}

	public int getHome() {
		return home;
	}

	public void setHome(int home) {
		this.home = home;
	}

	public int getStreet() {
		return street;
	}

	public void setStreet(int street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address: home" + home + ", street:" + street + ", city:" + city + "";
	}

}
