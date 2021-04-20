import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class wheel {

	static int[] memo;
	static ArrayList<Integer>[] map;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			int words = scanner.nextInt();
			memo = new int[words*2];
			Arrays.fill(memo, 0);
			map = new ArrayList[words*2];
			scanner.nextLine();
			TreeMap<String, Integer> dict = new TreeMap<>();			
			for(int i  = 0; i< words*2; i++) {
				map[i] = new ArrayList<>();
			}
			for(int i = 0 ; i< words; i++) {
				String sentence = scanner.nextLine();
				String[] split  = sentence.split(" ");
				if(!dict.containsKey(split[0])) {
					//System.out.println(split[0]);
					dict.put(split[0], dict.size());
				}
				if(!dict.containsKey(split[split.length-1])) {
					//System.out.println(split[split.length-1]);
					dict.put(split[split.length-1], dict.size());
				}
				map[dict.get(split[0])].add(dict.get(split[split.length-1]));
			}
			
			int max = 0;
			for(int i  = 0 ; i< words; i++) {
				max = Math.max(max, go(i));
			}
			System.out.printf("Puzzle #%d: %d%n",c+1 , max);
		}

	}
	
	public static int go(int index) {
		if(map[index].size() == 0) {
			return 1;
		}
		
		if(memo[index]!=0) {
			return memo[index];
		}
		
		for(int i : map[index]) {
			memo[index] = Math.max(memo[index],go(i)+1);
		}
		
		return memo[index];
		
	}

}
/*
7
5
WHEEL OF FORTUNE
FORTUNE COOKIE
COOKIE MONSTER
MONSTER MASH
NOT ME
2
ORDER CAN BE CHANGED
THEY ARE NOT GIVEN IN ORDER
5
USELESS SET
HI MY
MY NAME
NAME IS
IS REGGIE
6
HELLO FROM
HELLO THERE
FROM THE
THERE GENERAL
THE OTHER
GENERAL KENOBI
6
THE OTHER
GENERAL KENOBI
FROM THE
THERE GENERAL
HELLO FROM
HELLO THERE
10
BINARY TREE
TREE FARM
TREE MAN
FARM ANIMALS
MAN WOOD
FARM HAND
MAN BAT
ANIMALS PLANET
ANIMALS GALORE
ANIMALS BONANZA
10
BINARY TREE
TREE FARM
TREE MAN
FARM ANIMALS
MAN WOOD
FARM HAND
MAN BAT
ANIMALS PLANET
ANIMALS GALORE
ANIMALS MAN
*/
