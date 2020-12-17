import java.util.Scanner;

public class Genes {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0;  c<cases; c++) {
			String stranda = scanner.next();
			String strandb = scanner.next();
			String answer = "";
			if(stranda.equals(strandb)) {
				answer = stranda;
			}
			else {
				for(int i = 0; i< stranda.length();i++) {
					for(int j = i+1; j<stranda.length();j++) {
						if(strandb.contains(stranda.substring(i,j))){
							if(stranda.substring(i,j).length()>answer.length()){
								answer = stranda.substring(i,j);
							}
							
						}
						else {
							break;
						}
					}
				}
			}
			if(answer.equals("")) {
				System.out.printf("No match found.%n");
			}
			else {
				System.out.printf("%s%n",answer);
			}
		}
	}
}
