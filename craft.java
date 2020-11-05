import java.util.Scanner;

public class craft {
	static char[][][] graph;
	public static void main(String[] args){
         Scanner scanner = new Scanner(System.in);
         int cases = scanner.nextInt();
         for (int i = 0; i<cases; i++) {
        	 int le = scanner.nextInt();
        	 int wi = scanner.nextInt();
        	 int he = scanner.nextInt();
        	 graph = new char[he+2][le+2][wi+2];
        	 int[] start = new int[3];
        	 for (int h = 0; h<he; h++) {
        		 for (int l = 0; l<le; l++) {
        			 String row = scanner.next();
        			 for (int w = 0; w<wi; w++) {
        				 graph[h+1][l+1][w+1] = row.charAt(w);
        				 if(row.charAt(w)=='*') {
        					 start[0] = h+1;
        					 start[1] = l+1;
        					 start[2] = w+1;
        					 graph[h+1][l+1][w+1] = '.';
        				 }
        			 }
        		 }
        	 }
        	 int count = 0;
        	 System.out.printf("Map #%d: %d%n", i+1, dfs(start[0],start[1],start[2]));
         }
    }

	public static int dfs(int height, int length, int width) {
		if(graph[height][length][width] == '#'|| graph[height][length][width] == 0 ) {
			return 0;
		}
		else if(graph[height][length][width] == '*') {
			return 0;
		}
		else {
			graph[height][length][width] = '*';
		    if(graph[height+1][length][width]=='.') {
			    return dfs(height+1, length, width)+1;
		    }
		    else if(graph[height+1][length][width] != '*'){
			    return dfs(height,length+1,width) + dfs(height,length-1, width) + dfs(height,length, width+1) + dfs(height,length, width-1) +1;
		    }
		    else {
		    	return 1;
		    }
		}
		
		
	}
}
