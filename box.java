import java.util.LinkedList;
import java.util.Scanner;

public class box {
	static int movex[] = {1,0,-1,0};
	static int movey[] = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int height = scanner.nextInt();
		int width = scanner.nextInt();
		while(height!=0&&width!=0) {
			char map[][] = new char[height][width]; 
			int dist = 0;
			point portals[] = new point[20];
			boolean visited[][] = new boolean[height][width];
			LinkedList<point> queue = new LinkedList<point>();
			for(int i = 0; i<height; i++) {
				String line = scanner.next();
				for(int j = 0; j< width; j++) {
					map[i][j]=line.charAt(j);
					if(Character.isDigit(line.charAt(j))){
						if(portals[Character.getNumericValue(line.charAt(j))*2] == null) {
							portals[Character.getNumericValue(line.charAt(j))*2] = new point(i, j, line.charAt(j),0);
						}
						else {
							portals[Character.getNumericValue(line.charAt(j))*2+1] = new point(i, j, line.charAt(j),0);
						}
					}
					if(line.charAt(j)=='B') {
						queue.add(new point(i,j,'B',0));
					}
					
				}
			}
			while(!queue.isEmpty()) {
				point p = queue.remove();
				visited[p.y][p.x] = true;
				if(p.value == 'X') {
					System.out.printf("He got the Box in %d steps!%n",p.dist);
					break;
				}
				if(p.value == 'W') {
					continue;
				}
				if(Character.isDigit(p.value)) {
					if(!visited[portals[Character.getNumericValue(p.value)*2].y][portals[Character.getNumericValue(p.value)*2].x]) {
						queue.add(new point(portals[Character.getNumericValue(p.value)*2].y,portals[Character.getNumericValue(p.value)*2].x,portals[Character.getNumericValue(p.value)*2].value, p.dist));
					}
					if(!visited[portals[Character.getNumericValue(p.value)*2+1].y][portals[Character.getNumericValue(p.value)*2+1].x]) {
						queue.add(new point(portals[Character.getNumericValue(p.value)*2+1].y,portals[Character.getNumericValue(p.value)*2+1].x, portals[Character.getNumericValue(p.value)*2+1].value, p.dist));
					}
				}
				for(int i = 0; i<4; i++) {
					if(!(p.y+movey[i]<0||p.y+movey[i]>=height||p.x+movex[i]<0||p.x+movex[i]>=width)) {
						if(!visited[p.y+movey[i]][p.x+movex[i]]) {
							queue.add(new point(p.y+movey[i],p.x+movex[i],map[p.y+movey[i]][p.x+movex[i]],p.dist+1));
							visited[p.y+movey[i]][ p.x+movex[i]] = true;
						}	
					}
				}
			}
		height = scanner.nextInt();
		width = scanner.nextInt();
		}
	
	}
	public static class point{
		int x;
		int y;
		char value;
		int dist;
		
		public point(int y, int x, char value, int dist){
			this.x = x;
			this.y = y;
			this.value = value;
			this.dist = dist;
			}
		}
}