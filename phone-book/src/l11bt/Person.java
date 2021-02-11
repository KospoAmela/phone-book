package l11bt;

import java.util.ArrayList;

public class Person {
	private String name;
	private Address address;
	private ArrayList<String> phoneNumbers = new ArrayList<String>();
	
	public Person(String name) {
		this.name = name;
	}
	
	public void set(Person p) {
		this.name = p.getName();
		if(p.getAddress() != null) {
			this.address = new Address(p.getAddress().getStreet(), p.getAddress().getCity());
		}
		if(p.getPhoneNumbers().size() != 0) {
			this.phoneNumbers = p.getPhoneNumbers();
		}
	}
	public void addPhoneNumber(String phoneNumber) {
		this.phoneNumbers.add(phoneNumber);
	}
	
	public void addAddress(String street, String city) {
		this.address = new Address(street, city);
	}
	
	public String getName() {
		return this.name;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	public ArrayList<String> getPhoneNumbers(){
		return this.phoneNumbers;
	}
	
	public String isThereTheNumber(String phoneNumber) {
		if(this.phoneNumbers.contains(phoneNumber)) {
			return this.name;
		}else {
			return "Doesn't contain";
		}
	}
}
