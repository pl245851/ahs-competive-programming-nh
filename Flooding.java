import java.util.Scanner;

public class Flooding {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int i = 0; i<cases;i++)
		{
			// Triangle
			Vector a = new Vector(scanner.nextInt(),scanner.nextInt());
			Vector b = new Vector(scanner.nextInt(),scanner.nextInt());
			Vector c = new Vector(scanner.nextInt(),scanner.nextInt());
			
			Line ab = new Line(a,b);
			Line bc = new Line(b,c);
			Line ac = new Line(c,a);
			
			// List of lines to consider
			int tests = scanner.nextInt();
			Line[] lines = new Line[tests];
			for(int j = 0;j<tests;j++) {
				Vector start = new Vector(scanner.nextInt(),scanner.nextInt());
				Vector end = new Vector(scanner.nextInt(),scanner.nextInt());
				lines[j] = new Line(start,end);
			}
			
			int count = 0;
			for (Line line : lines) {
				if (isInTriangle(line.start, a, b, c) ^ isInTriangle(line.end, a, b, c)) {
					count++;
				}
				
				//if (line.intersects(ab) || line.intersects(bc) || line.intersects(ac)) {
				//	count++;
				//}
			}
			System.out.printf("Scenario %d: %d", i+1, count);
		}
	}
	
	public static boolean isInTriangle(Vector point, Vector a, Vector b, Vector c) {
		double angleWithA = b.sub(a).angleBetween(point.sub(a));
		double angleWithB = c.sub(b).angleBetween(point.sub(b));
		double angleWithC = a.sub(c).angleBetween(point.sub(c));
		
		boolean leftA = angleWithA < 0;
		boolean leftB = angleWithB < 0;
		boolean leftC = angleWithC < 0;
		
		if (leftA == leftB && leftB == leftC) {
			return true;
		} else {
			return false;
		}
	}
	
	public static class Line {
		Vector start, end;
		
		public Line(Flooding.Vector a, Flooding.Vector b) {
			start = a;
			end = b;
		}

		boolean intersects(Line o) {
			return true;
		}
	}
	
	public static class Vector {
		int x, y;
		
		public Vector(int i, int j) {
			x = i;
			y = j;
		}

		double angleBetween(Vector o) {
			double rad = Math.atan2(this.x-o.x, this.y-o.y);
			return Math.toDegrees(rad);
		}
		
		Vector sub(Vector o) {
			return new Vector(this.x - o.x, this.y - o.y);
		}
	}
}