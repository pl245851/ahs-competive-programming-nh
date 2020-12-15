import java.util.LinkedList;
import java.util.Scanner;

public class Ball {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			int length = scanner.nextInt();
			int width = scanner.nextInt();
			int dist = scanner.nextInt();
			while(!(length ==0) && !(width==0) && !(dist==0)) {
				int startx = 0;
				int starty = 0;
				char floor[][] = new char[length][width];
				for(int j = 0; j<length; j++) {
					String row = scanner.next();
					for(int k = 0; k<width; k++) {
						floor[j][k]=row.charAt(k);
						if(row.charAt(k)=='*') {
							startx = j;
							starty = k;
						}
					}
				}
					boolean visited[][]= new boolean[length][width]; 
					LinkedList<point> queue = new LinkedList<point>();
					queue.add(new point(startx, starty, 0));
					boolean possible = false;
					int movex[] = {0,1,0,-1};
					int movey[] = {1,0,-1,0};
					while(!queue.isEmpty()) {
						point place = queue.removeFirst();
						if(place.dist>dist) {
							continue;
						}
						if(place.x<0||place.x>=length||place.y<0||place.y>=width) {
							continue;
						}
						if(floor[place.x][place.y]=='X') {
							continue;
						}
						if(visited[place.x][place.y]) {
							continue;
						}
						visited[place.x][place.y]=true;
						if(floor[place.x][place.y]=='o') {
							possible = true;
							break;
						}
					
						for(int l = 0; l<4; l++) {
					queue.addLast(new point(movex[l]+place.x,movey[l]+place.y,place.dist+1));
						}
					}
					if(possible) {
						System.out.printf("HIJINKS! You have bested the Ball Game.%n");
					}
					else {
						System.out.printf("Pathetic human! The great Papyrus looms large!%n");
					}
					length = scanner.nextInt();
					width = scanner.nextInt();
					dist = scanner.nextInt();
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
