import java.util.LinkedList;
import java.util.Scanner;

public class Shortest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int height = scanner.nextInt();
		int width = scanner.nextInt();
		int movex[] = {0,1,0,-1};
		int movey[] = {1,0,-1,0};
		while(!(height==0)&&!(width==0)) {
			LinkedList<Integer> start = new LinkedList<>();
			char map[][]= new char[height][width];
			for(int i = 0; i< height; i++) {
				String row = scanner.next();
				if(row.charAt(0)=='.') {
					start.addLast(i);
				}
				for(int j = 0; j<width;j++) {
					map[i][j]=row.charAt(j);
				}
			}
			int path = 0;
			int shortestpos = 0;
			int shortest = height*width;
			while(!start.isEmpty()) {
				path++;
				int startpos = start.removeFirst();
				LinkedList<point> queue = new LinkedList<>();
				boolean visited[][]= new boolean[height][width];
				queue.addLast(new point(0,startpos));
				int count = 0;
				while(!queue.isEmpty()) {
					point here = queue.removeFirst();
					if(here.x>=width||here.x<0||here.y>=height||here.y<0) {
						continue;
					}
					if(visited[here.y][here.x]) {
						continue;
					}
					if(map[here.y][here.x]=='X') {
						continue;
					}
					if(here.x==width-1) {
						break;
					}
					visited[here.y][here.x] = true;
					count++;
					for(int l = 0; l<4;l++) {
						queue.add(new point(here.x+movex[l],here.y+movey[l]));
					}
				}
				if(count<shortest) {
					shortest = count;
					shortestpos = path;
				}
			}
			System.out.printf("I choose path %d!%n", shortestpos);
			
			
			height = scanner.nextInt();
			width = scanner.nextInt();
			
		}
	}
	public static class point{
		int x;
		int y;
		
		public point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}

}
