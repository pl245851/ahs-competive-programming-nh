import java.util.Scanner;

public class sniper2 {

	public static void Main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c =0; c< cases;c++) {
			int soldiers = scanner.nextInt();
			int bullets = scanner.nextInt();
			int[] bf = new int[soldiers];
			for(int i = 0; i< soldiers; i++) {
				bf[i] = scanner.nextInt();
			}
			for(int i =0; i<bullets; i++) {
				if(bf[i]<0) {
					bf[i]-=scanner.nextInt();
				}
				else {
					bf[i]+=scanner.nextInt();
				}
			}
			int total = 0;
			for(int i =0; i<soldiers; i++) {
				total+=bf[i];
			}
			System.out.println(total);
		}
	}
}
