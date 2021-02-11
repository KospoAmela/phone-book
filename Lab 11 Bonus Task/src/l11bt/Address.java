package l11bt;

public class Address {
	private String street;
	private String city;
	
	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}
	public String getStreet() {
		return this.street;
	}
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setStreer(String street) {
		this.street = street;
	}
}
