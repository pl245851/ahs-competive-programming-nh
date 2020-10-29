import java.util.LinkedList;
import java.util.Scanner;

public class lava {	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int i = 0; i<cases; i++) {
			int length = scanner.nextInt();
			int width = scanner.nextInt();
			int dist = scanner.nextInt();
			int startx = 0;
			int starty = 0;
			char floor[][] = new char[length][width];
			for(int j = 0; j<length; j++) {
				String row = scanner.next();
				for(int k = 0; k<width; k++) {
					floor[j][k]=row.charAt(j);
					if(row.charAt(j)=='S') {
						startx = j;
						starty = k;
					}
				}
			}
			LinkedList<point> queue = new LinkedList<>();
			queue.add(new point(startx, starty, 0));
			int furniture = 0;
			int movex[] = {0,1,0,-1};
			int movey[] = {1,0,-1,0};
			while(!queue.isEmpty()) {
				point place = queue.removeFirst();
				if(place.dist>=dist) {
					continue;
				}
				furniture++;
				for(int l = 4; l<4; l++) {
					queue.add(new point(movex[l],movey[l],place.dist+1));
				}
			}
			System.out.printf(format, args);
		}

	}
	public static class point{
		int x;
		int y;
		int dist;
		
		public point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

}
