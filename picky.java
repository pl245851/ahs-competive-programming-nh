import java.util.Arrays;
import java.util.Scanner;

public class picky {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0 ; c< cases; c++) {
			int lines =  scanner.nextInt();
			int points = scanner.nextInt();
			Vector[] shape = new Vector[lines];
			Vector[] point = new Vector[points];
			for(int i = 0; i < lines; i++) {
				shape[i] = new Vector(scanner.nextInt(), scanner.nextInt());
			}
			for(int i = 0; i < points; i++) {
				point[i] = new Vector(scanner.nextInt(), scanner.nextInt());
			}
			int count = 0;
			double mindif = Integer.MAX_VALUE; 
			for(int i = 0; i< lines; i++) {
				for(int j = 0; j< lines; j++) {
					if(i==j) {
						continue;
					}
					//double m = (shape[j].y-shape[i].y) / (shape[j].x-shape[i].x);
					//double x1 = shape[j].x;
					//double y1 = shape[j].y;
					int leftnright = 0;
					for(Vector k : point) {
						//System.out.print(" " + k.x + -x1 +m +y1 + "\n");
						//System.out.print(k.x + " " + k.y +"\n" + "x -" + x1 +"*"+m+" + "+y1+"\n");
						double angle = shape[i].angleBetween(shape[j])-shape[i].angleBetween(k);
						/*
						 * if((k.x-x1)*m + y1 == 0) { //System.out.print(" aaa\n"); leftnright = 100;
						 * break;
						 * 
						 * } else if((k.x-x1)*m + y1 > 0) { leftnright++; } else { leftnright--; }
						 */
						//System.out.println(angle);
						if(angle == 0) {
							leftnright =100;
							break;
						}
						if(angle>0) {
							leftnright++;
						}
						else {
							leftnright--;
						}
					}
					//System.out.println(leftnright);
					if(leftnright==0){
						mindif = Math.min(mindif, Math.abs(area(Arrays.copyOfRange(shape, i, (i+j)%lines))-area(shape)/2));
					}
				}
			}
			if(count==0) {
				System.out.println("No");
			}
			else {
				System.out.printf("Yes%n%f%n", mindif);
			}
			
		}

	}
	
	public static double area(Vector[] points) {
		double total = 0;
		for (int i = 0; i < points.length; i++) {
			Vector left = points[i];
			Vector right = points[(i + 1) % points.length];
			total += left.cross(right);
		}
		
		return Math.abs(total / 2);
	}
	
	public static class Vector {
		double x,y;
		public Vector(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public Vector add(Vector o) {
			return new Vector(x + o.x, y + o.y);
		}
		
		public Vector sub(Vector o) {
			return new Vector(x - o.x, y - o.y);
		}
		
		public Vector scale(double r) {
			return new Vector(x * r, y * r);
		}
		
		public double mag() {
			return Math.hypot(x, y);
		}
		
		public Vector normalize() {
			return scale(1 / mag());
		}
		
		public double dot(Vector o) {
			return x * o.x + y * o.y;
		}
		
		public double cross(Vector o) {
			return x * o.y - o.x * y;
		}
		
		public double angleBetween(Vector o) {
			return Math.atan2(cross(o), dot(o));
		}
		
		public double angle() {
			return angleBetween(new Vector(1, 0));
		}
		
	}

}
