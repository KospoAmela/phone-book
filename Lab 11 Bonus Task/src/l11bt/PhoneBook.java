package l11bt;

import java.util.ArrayList;

public class PhoneBook {
	private ArrayList<Person> phonebook = new ArrayList<Person>();
	
	public ArrayList<Person> getPhoneBook(){
		return this.phonebook;
	}
	
	public void addPerson(Person p) {
		this.phonebook.add(p);
	}
	
	public String getNameByNumber(String number) {
		String result = "not found";
		for(Person p : this.phonebook) {
			result = p.isThereTheNumber(number);
		}
		return result;
	}
	
	public ArrayList<String> getNumbers(String name) {
		ArrayList<String> numbers = new ArrayList<String>();
		for(Person p : this.phonebook) {
			if(name.equals(p.getName())) {
				numbers = p.getPhoneNumbers();
			}
		}
		if(numbers.size() == 0) numbers.add("not found");
		return numbers;
	}
	
	public void deleteInformation(String name) {
		for(Person p : this.phonebook) {
			if(name.equals(p.getName())) {
				this.phonebook.remove(p);
				break;
			}
		}
	}
	
	public Person getPersonalInformation(String name) {
		for(Person p : this.phonebook) {
			if(name.equals(p.getName())) {
				return p;
			}
		}
		throw new IllegalArgumentException("That person doesnt exist");
	}
	
	public void addNumber(String name, String number) {
		boolean personExists = false;
		for(Person p : this.phonebook) {
			if(p.getName().equals(name)) {
				p.addPhoneNumber(number);
				personExists = true;
			}
		}
		if(!personExists) throw new IllegalArgumentException("The person doesn't exist");
	}
	public void setAddress(String name, String street, String city) {
		for(Person p : this.phonebook) {
			if(p.getName().equals(name)) {
				p.addAddress(street, city);
			}
		}
	}
	
	public Person keywordSearch(String keyword) {
		for(Person p : this.phonebook) {
			if(p.getName().contains(keyword)) {
				return p;
			}if(p.getAddress() != null) {
				if(p.getAddress().getCity().contains(keyword) || p.getAddress().getStreet().contains(keyword)) {
					return p;
				}
			}
		}
		return null;
	}
	
	public void sort() {
		/*for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[j] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } */
		for(int i = 0; i < this.phonebook.size(); i++) {
			for(int j = 0; j < this.phonebook.size() - i - 1; j++) {
				if(phonebook.get(j).getName().compareTo(phonebook.get(j+1).getName()) > 0) {
					Person temp = phonebook.get(j);
					phonebook.get(j).set(phonebook.get(j+1));
					phonebook.get(j+1).set(temp);
				}
			}
		}
	}
}
