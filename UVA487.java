import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class UVA487 {
	static int movex[] = {1,1, 1,0, 0,-1,-1,-1};
	static int movey[] = {1,0,-1,1,-1, 1, 0,-1};
	static char map[][];
	static List<String> set;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			set = new ArrayList<>();
			int length = scanner.nextInt();
			map = new char[length][length];
			for(int i = 0; i<length; i++) {
				String line = scanner.next();
				for(int j = 0; j<length;j++) {
					map[i][j] = line.charAt(j);
				}
			}
			for(int i  =0 ; i< length; i++) {
				for(int j = 0; j< length; j++) {
					search("",i,j);
				}
			}
			Collections.sort(set);
			Comparator<String> sizefirst = (String o1, String o2) -> o1.length()-( o2.length());
			Collections.sort(set, sizefirst );
			
			for(int i = 0; i<set.size();i++) {
				System.out.printf("%s%n", set.get(i));
			}
			System.out.printf("%n");
		}

	}
	public static void search(String current,int x,int y) {
		if(check(current)) {
			for(int i = 0; i< 8; i++) {
				if(x+movex[i]>=0&&x+movex[i]<map.length&&y+movey[i]>=0&&y+movey[i]<map.length) {
					search(current+map[x+movex[i]][y+movey[i]],x+movex[i] ,y+movey[i]);
				}
			}
		}
	}
	
	
	public static boolean check(String word) {
		char[] chek = word.toCharArray();
		boolean pass = true;
		for(int i = 1; i<chek.length&&chek.length>1; i++) {
			if(chek[i]<=chek[i-1]) {
				pass = false;
			}
		}
		//System.out.printf("%s%b%n", word, pass);
		if(pass&&word.length()>2) {
			if(!set.contains(word)) {
				set.add(word);
				//System.out.printf("%s%b%n", word, pass);
			}
		}
		return pass;
	}

}