import java.util.ArrayList;
import java.util.Scanner;

public class inequalities {
	
	static int[][] answer;
	static ArrayList<inequality> checks;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c<cases; c++) {
			answer = new int[4][4];
			for(int i = 0; i<4; i++) {
				for(int j = 0; j<4;j++) {
					int nextint = scanner.nextInt();
					if(nextint!=0) {
						answer[i][j] = nextint;
					}
				}
			}
			checks = new ArrayList<>();
			int ineq = scanner.nextInt();
			for(int i = 0; i<ineq; i++) {
				checks.add(new inequality(scanner.nextInt()-1,scanner.nextInt()-1,scanner.nextInt()-1,scanner.nextInt()-1));
			}
			for(int i = 0; i<4; i++) {
				
			}
			permutefour(new int[4][4], 0, 0, new boolean[4]);
			System.out.printf("Puzzle #%d:%n", c+1);
			for(int i = 0; i<4;i++) {
				for(int j = 0; j<4; j++) {
					System.out.printf("%d ", answer[i][j]+1);
				}
				System.out.printf("%n");
			}
			System.out.printf("%n");
		}
	}
	
	public static void permutefour(int[][] indexes, int index, int indexy, boolean[] used) {
		if (index >= 4) {
//			if(!validatefour(indexes[indexy])) {
//				return;
//			}
			if(indexy >= 3) {
				validate(indexes);
				return;
			}
			indexy++;
			index=0;
			for(int i = 0; i< 4; i++) {
				used[i] = false;
			}
		}
		if(answer[index][indexy]!=0) {
			used[answer[index][indexy]-1] = true;
			indexes[index][indexy] = answer[index][indexy]-1;
			permutefour(indexes, index + 1, indexy, used);
		}
		for (int i = 0; i < indexes.length; i++) {
			// Check if we haven't included this index yet
			if (!used[i]) {
				// Generate a permutation with i in this index
				used[i] = true;
				indexes[index][indexy] = i;
				permutefour(indexes, index + 1, indexy, used);
				
				// Remove i from used to allow it to be used in
				// future permutations.
				used[i] = false;
			}
		}
	}
	public static boolean validatefour(int[] indexes) {
		boolean poss = true;
		ArrayList<Integer> included = new ArrayList<>();
		for(int i = 0; i< 4; i++) {
			if(included.contains(indexes[i])) {
				poss = false;
			}
			included.add(indexes[i]);
		}
		return poss;
		
	}
	
	public static void validate(int[][] indexes) {
		boolean pass = true;
		for(int i = 0; i< 4; i++) {
			if(!validatefour(indexes[i])) {
				pass = false;
			}
		}
		for(int i = 0; i<checks.size();i++) {
			if(indexes[checks.get(i).lessx][checks.get(i).lessy]>=indexes[checks.get(i).greatx][checks.get(i).greaty]) {
				pass = false;
			}
		}
		if(pass) {
			for(int i = 0; i<4; i++) {
				for(int j = 0; j<4; j++) {
					answer[i][j] = indexes[i][j];
				}
			}
			
		}
		
	}

	public static class inequality{
		int greatx;
		int greaty;
		int lessx;
		int lessy;
		
		public inequality(int x1,int y1,int x2,int y2){
			greatx = x2;
			greaty = y2;
			lessx = x1;
			lessy = y1;
		}
		
	}
}
