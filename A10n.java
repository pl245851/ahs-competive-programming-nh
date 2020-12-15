import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class A10n {
	
	public static String getAbbreviation(String word) {
		/*
		 * Populate this method according to the problem specifications.
		 */
		if(word.length()>3){
			return word.charAt(0) + String.valueOf(word.length()-2) + word.charAt(word.length()-1);
		}
		else {
			return word;
		}
	}
	
	public static void main(String[] args) throws IOException {
		/*
		 * Notice the different method of reading in data.
		 * Although this is unnecessary for this problem, using
		 * this method increases performance a little bit.
		 * Consider using this method for problems with
		 * very large input data.
		 * 
		 * Also notice the use of StringBuilder instead of using
		 * System.out to print information as we get it. This
		 * is another small performance optimization when there
		 * is a lot of output. Consider using this when you need
		 * to print millions of data points.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		String line = br.readLine();
		while(line != null) {
			/*
			 * Be careful when using `.split()` as it takes a regular expression.
			 * In this case we only split on spaces, but if you need to split
			 * on other characters like '.', this won't work.
			 */
			String[] words = line.split(" ");
			for (int i = 0; i < words.length; i++) {
				// Sometimes trailing spaces can be the only issue
				// between a Correct and Wrong Answer response!
				if (i != 0) {
					output.append(" ");	
				}
				
				String abbreviation = getAbbreviation(words[i]);
				output.append(abbreviation);
			}
			/*
			 *  Never assume the operating system that runs the test
			 *  cases is the same as yours.
			 */
			output.append(System.lineSeparator());
			line = br.readLine();
		}

		System.out.println(output);
	}
}