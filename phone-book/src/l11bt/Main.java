package l11bt;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		PhoneBook phoneBook = new PhoneBook();
		Person pekka = new Person("pekka");
		pekka.addAddress("kfdkljdjf", "kldgljg");
		pekka.addPhoneNumber("8546884960");
		pekka.addPhoneNumber("950696");
		phoneBook.addPerson(pekka);
		
		Person bekka = new Person("bekka");
		bekka.addAddress("njsfjklsj", "sdfkjksj");
		bekka.addPhoneNumber("5665565");
		bekka.addPhoneNumber("6654545");
		phoneBook.addPerson(bekka);
		
		Person kekka = new Person("kekka");
		kekka.addPhoneNumber("46346346");
		kekka.addPhoneNumber("647777");
		phoneBook.addPerson(kekka);
		
		Person nekka = new Person("nekka");
		nekka.addAddress("kfldfk", "skfkfl");
		phoneBook.addPerson(nekka);
		
		
		System.out.println("phone search");
		System.out.println("available operations: ");
		System.out.println("1 add number");
		System.out.println("2 search for a number");
		System.out.println("3 search for a person by phone number");
		System.out.println("4 add an address");
		System.out.println("5 search for personal information");
		System.out.println("6 delete personal information");
		System.out.println("7 filtered listing");
		System.out.println("x quit");
		
		String command;
		Scanner reader = new Scanner(System.in);
		command = reader.nextLine();
		
		while(!command.equals("x")) {
			if(Integer.parseInt(command) == 1) {
				System.out.println("whose number: ");
				String name = reader.nextLine();
				System.out.println("number: ");
				String number = reader.nextLine();
				try {
				phoneBook.addNumber(name, number);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}else if(Integer.parseInt(command) == 2) {
				System.out.println("whose number: ");
				String name = reader.nextLine();
				ArrayList<String> numbers = phoneBook.getNumbers(name);
				for(String number : numbers) {
					System.out.println(number);
				}
			}else if(Integer.parseInt(command) == 3) {
				System.out.println("number: ");
				String number = reader.nextLine();
				String name = phoneBook.getNameByNumber(number);
				System.out.println(name);
			}else if(Integer.parseInt(command) == 4) {
				System.out.println("whose address: ");
				String name = reader.nextLine();
				System.out.println("street: ");
				String street = reader.nextLine();
				System.out.println("city: ");
				String city = reader.nextLine();
				phoneBook.setAddress(name, street, city);
			}else if(Integer.parseInt(command) == 5) {
				System.out.println("whose information: ");
				String name = reader.nextLine();
				try {
					Person p = phoneBook.getPersonalInformation(name);
					String city = p.getAddress().getCity();
					String street = p.getAddress().getStreet();
					ArrayList<String> numbers = p.getPhoneNumbers();
					System.out.println("address: " + street + " " + city);
					if(numbers.size() == 0) System.out.println("phone number not found");
					else {
						System.out.println("phone numbers: ");
						for(String n : numbers) {
							System.out.println(n);
						}
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}else if(Integer.parseInt(command) == 6) {
				System.out.println("whose information: ");
				String name = reader.nextLine();
				phoneBook.deleteInformation(name);
			}else if(Integer.parseInt(command) == 7) {
				System.out.println("keyword (if empty, all listed): ");
				String keyword = reader.nextLine();
				Person p = phoneBook.keywordSearch(keyword);
				if(p == null) {
					phoneBook.sort();
					for(Person a : phoneBook.getPhoneBook()) {
						String name = a.getName();
						System.out.println(name);
						if(a.getAddress() != null) {
						String city = a.getAddress().getCity();
						String street = a.getAddress().getStreet();
						System.out.println("address: " + street + " " + city);
						}else {
							System.out.println("address not found");
						}
						ArrayList<String> numbers = a.getPhoneNumbers();
						System.out.println(name + ": ");
						
						if(numbers.size() == 0) System.out.println("phone number not found");
						else {
							System.out.println("phone numbers: ");
							for(String n : numbers) {
								System.out.println(n);
							}
						}
					}
				}
				else {
					String name = p.getName();
					String city = p.getAddress().getCity();
					String street = p.getAddress().getStreet();
					ArrayList<String> numbers = p.getPhoneNumbers();
					System.out.println(name + ": ");
					System.out.println("address: " + street + " " + city);
					if(numbers.size() == 0) System.out.println("phone number not found");
					else {
						System.out.println("phone numbers: ");
						for(String n : numbers) {
							System.out.println(n);
						}
					}
				}
			}else {
				System.out.println("Invalid input");
			}
			command = reader.nextLine();
		}
		reader.close();
	}

}
