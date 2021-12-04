import java.util.Scanner;

public class arithmetic {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		for(int c = 0; c < count; c++) {
			
			int amount = scanner.nextInt();
			int num = scanner.nextInt();
			boolean possible = num>=amount && (num%amount==0 || (amount%2 == 0 &&num%(amount/2)==0));
			if(possible){
				double mid =(num/(double)amount);
				if(num%amount==0) {
					for(int i = 0; i< amount; i++) {
						System.out.print((int)mid+" ");
					}
				}
				else if((int) mid == mid) {
					for(int i = 0; i< amount; i++) {
						System.out.print((int)(mid+ -amount/2 + i) +" ");
					}
				}
				else {
					for(int i = 0; i< amount; i++) {
						System.out.print((int)(mid+ -amount/2 + i+0.5) +" ");
					}
				}
				
			}
			else {
				System.out.print("IMPOSSIBLE");
			}
			System.out.println();
			
		}
	}

}
