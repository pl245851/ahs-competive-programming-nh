import java.io.IOException;
import java.util.Scanner;

public class Tag {
	
	public static int applyTag(int yourBitmask, int taggedBitmask, int startingBit) {
		if ((yourBitmask & taggedBitmask) == yourBitmask) {
			// Reset to starting point
			return 1 << startingBit;
		}
		
		return yourBitmask | taggedBitmask;
	}
	
	public static int countBits(int bitmask) {
		return Integer.bitCount(bitmask);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int games = scanner.nextInt();
		for (int g = 0; g < games; g++) {
			int tags = scanner.nextInt();
			int startingBit = scanner.nextInt();
			
			int bitmask = (1 << startingBit);
			for (int t = 0; t  < tags; t++) {
				int bitsForTaggedPlayer = scanner.nextInt();
				int taggedBitmask = 0;
				
				for (int b = 0; b < bitsForTaggedPlayer; b++) {
					int bit = scanner.nextInt();
					taggedBitmask = taggedBitmask | (1 << bit);
				}
				
				bitmask = applyTag(bitmask, taggedBitmask, startingBit);
			}
			
			int points = countBits(bitmask);
			System.out.println(points);
		}
	}
}