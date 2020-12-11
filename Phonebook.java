import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Phonebook {
	
	public static class Friend implements Comparable<Friend> {
		/*
		 *  I mark these as "final" so I don't accidentally override them
		 *  somewhere else in the program.
		 */
		final String phoneNumber;
		final String firstName;
		final String lastName;
		
		public Friend(String phoneNumber, String firstName, String lastName) {
			this.phoneNumber = phoneNumber;
			this.firstName = firstName;
			this.lastName= lastName; 
		}
		
		/*
		 * This will be what is printed whenever this gets converted
		 * into a String. For example: System.out.print(friend), or
		 * String string = "Prefix: " + friend.
		 */
		public String toString() {
			// This is exactly what printf uses for formatting too!
			return String.format("%s, %s: %s", lastName, firstName, phoneNumber);
		}
		
		public int compareTo(Friend other) {
			
			return this.toString().toUpperCase().compareTo(other.toString().toUpperCase());
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int friendCount = scanner.nextInt();
		
		ArrayList<Friend> friends = new ArrayList<Friend>();
		
		for (int i = 0; i < friendCount; i++) {
			Friend friend = new Friend(scanner.next(), scanner.next(), scanner.next());
			friends.add(friend);
		}
		
		Collections.sort(friends);
		
		for (Friend friend : friends) {
			System.out.println(friend);
		}
	}
}