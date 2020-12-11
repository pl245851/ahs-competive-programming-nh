import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class alphasong {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int i = 0; i<cases;i++) {
			int words = scanner.nextInt();
			String[] wrdlst = new String[words];
			for(int j = 0; j<words;j++) {
				wrdlst[j] = (scanner.next().toLowerCase());
			}
			int count = 0;
			String newlist[] = wrdlst.clone();
			Arrays.sort(wrdlst);
			for(int k = 0; k<words; k++) {
				if(newlist[k].equals(wrdlst[k])) {
					count++;
				}
			}
			System.out.printf("%d%n",count);
		}

	}

}
