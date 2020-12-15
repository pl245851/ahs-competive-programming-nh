import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class snack {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		int cases= scanner.nextInt();
		for(int c =0; c<cases;c++) {
			List<Snack> snacklist = new ArrayList<Snack>();
			int snacks = scanner.nextInt();
			for(int i =0; i<snacks;i++) {
				snacklist.add(new Snack(scanner.next()));
			}
			Collections.sort(snacklist);
			System.out.printf("Cabinet #%d:%n",c+1);
			for(int i =0; i<snacks; i++) {
				System.out.println(snacklist.get(i).name);
			}
			System.out.println();
		}

	}
	public static class Snack implements Comparable<Snack>{

		String name;
		int vowels =0;
		String vowellist = "aeiou";
		
		public Snack(String name) {
			this.name=name;
			for(int i =0; i<name.length();i++) {
				if(name.charAt(i)=='y') {
					vowels+=2;
				}
				if(name.charAt(i)=='a'||name.charAt(i)=='e'||name.charAt(i)=='i'||name.charAt(i)=='o'||name.charAt(i)=='u') {
					vowels+=1;
				}
			}
			
			
		}
		
		public int compareTo(Snack o) 
		{
			if(this.vowels-o.vowels==0) {
				return this.name.compareTo(o.name);
			}
			return -(this.vowels-o.vowels);
		}
		
	}

}
