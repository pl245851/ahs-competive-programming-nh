import java.util.Scanner;

public class badminton {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0 ; c< cases; c++) {
			int start = "AB".indexOf(scanner.next());
			int serves = scanner.nextInt();
			int[] points = {0,0};
			for(int i = 0 ; i< serves; i++) {
				int hits = scanner.nextInt();
				if(hits==1) {
					points[start]++;
					//System.out.print(start);
				}
				else {
					if(hits%2==1) {
						points[start]++;
						//System.out.print(start);
					}
					else
					start = 1- start;
				}
			}
			System.out.println(points[0]+"-"+points[1]);
		}

	}

}
