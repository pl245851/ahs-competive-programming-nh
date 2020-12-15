import java.util.Scanner;

public class sniper{

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c =0; c< cases;c++) {
			int soldiers = scanner.nextInt();
			int bullets = scanner.nextInt();
			int[] gc = new int[soldiers];
			int gcn = 0;
			long total = 0;
			for(int i = 0; i< soldiers; i++) {
				int sold = scanner.nextInt();
				total+=sold;
				if(sold>0) {
					gcn++;
				}
				else {
					gcn--;
				}
				gc[i] = gcn;
			}
			for(int i =0; i<bullets; i++) {
				int aoe = scanner.nextInt();
				if(gc[(aoe-1)]>0) {
					total+=gc[aoe-1];
							
					}
				}
			System.out.println(total);
		}
	}
}
/*
3
6 5
3 -2 -4 1 5 -1
3 5 4 1 3
1 2
-1
1 1
3 2
1 -2 -10
2 1
*/
