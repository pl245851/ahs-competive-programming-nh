import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class adventure {

	static int[] memo;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			int pages = scanner.nextInt();
			memo = new int[pages];
			Arrays.fill(memo, 0);
			map = new int[pages][pages];
			scanner.nextLine();
			List<Integer> starts = new ArrayList<>();
			for(int i = 0 ; i< pages; i++) {
				String options = scanner.nextLine();
				if(options.equals("ENDING")) {
					starts.add(i);
					continue;
				}
				for( String j : options.split(" ")) {
					map[Integer.valueOf(j)-1][i] = 1;
				}
			}
			int max = 0;
			for(int i : starts) {
				max = Math.max(max, go(i));
			}
			System.out.printf("Book #%d: The longest story is %d pages.%n",c+1 , max);
		}
	}
	
	public static int go(int index) {
		if(index == 0) {
			return 1;
		}
		
		if(memo[index]!=0) {
			return memo[index];
		}
		
		for(int i = 0 ; i< memo.length; i++) {
			if(map[index][i]==1) {
				memo[index] = Math.max(memo[index],go(i)+1);
			
			}
		}
		return memo[index];
		
	}

}
