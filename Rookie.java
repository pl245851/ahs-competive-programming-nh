import java.util.LinkedList;
import java.util.Scanner;


public class Rookie {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c<cases; c++) {
			int startx = 0;
			int starty = 0;
			char map[][] = new char[8][8];
			for(int i = 0; i<8; i++) {
				String row = scanner.next();
				for(int j = 0; j<8; j++) {
					map[i][j]=row.charAt(j);
					if(row.charAt(j)=='R') {
						starty = i;
						startx = j;
					}
				}
			}
			boolean visited[][][]= new boolean[8][8][4]; 
			LinkedList<point> queue = new LinkedList<point>();
			queue.add(new point(startx, starty, 0, -10));
			int movex[] = {1,0,-1,0};
			int movey[] = {0,1,0,-1};
			while(!queue.isEmpty()) {
				point here = queue.removeFirst();
				if(here.x<0||here.x>=8||here.y<0||here.y>=8) {
					continue;
				}
				if(map[here.y][here.x]=='X') {
					continue;
				}
				if(here.x!=startx&&here.y!=starty) {
					visited[here.y][here.x][here.lastdir]=true;
				}
				if(map[here.y][here.x]=='O') {
					System.out.printf("%d%n", here.dist);
					break;
				}
				for(int l = 0; l<4; l++) {
					if(here.lastdir!=l) {
						if(!(here.x+movex[l]<0||here.x+movex[l]>=8||here.y+movey[l]<0||here.y+movey[l]>=8)) {
							if(!visited[movey[l]+here.y][movex[l]+here.x][l]) {
								queue.addLast(new point(movex[l]+here.x,movey[l]+here.y,here.dist+1,l));
								visited[movey[l]+here.y][movex[l]+here.x][l] = true;
							}
						}	
					}
					else {
						if(!(here.x+movex[l]<0||here.x+movex[l]>=8||here.y+movey[l]<0||here.y+movey[l]>=8)) {
							queue.addFirst(new point(movex[l]+here.x,movey[l]+here.y,here.dist,l));
							visited[movey[l]+here.y][movex[l]+here.x][l] = true;
						}
					}
				}
			}

		}
	}

	public static class point{
		int x;
		int y;
		int dist;
		int lastdir;
		
		public point(int x, int y, int dist, int z) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.lastdir = z;
		}
	}
}
/*
7
........
...R....
........
........
...X....
........
........
.......O
........
........
..X.X...
..XOX...
..XXX...
........
..XRX...
........
R.XXXXXX
...XXXXX
.X..XXXX
.XX..XXX
.XXX..XX
.XXXX..X
.XXXXX..
.......O
O.XXXXXX
...XXXXX
.X..XXXX
.XX..XXX
.XXX..XX
.XXXX..X
.XXXXX..
.......R
R.XXXXXX
...XXXXX
.X..XXXX
.XX..XXX
.XXX..XX
.XXXX..X
.XXXXX..
....X..O
........
........
........
........
...X....
........
.......R
.......O
........
........
...XXX..
..X.....
R.X.OXX.
..X.....
...XXX..
........
*/
