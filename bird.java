import java.util.Scanner;

public class bird {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c= 0 ; c< cases; c++) {
			int dist = scanner.nextInt();
			int sides = scanner.nextInt();
			Vector[] walls = new Vector[sides];
			for(int i = 0; i< sides; i++) {
				walls[i] = new Vector(scanner.nextInt(), scanner.nextInt());
			}
			
		}
	}
	public static class Vector {
		double x, y;
		
		public Vector(double x, double y) {
			this.x = x;
			this.y = y;
		}

                public Vector add(Vector other) {
        			return new Vector(this.x + other.x, this.y + other.y);
        		}
                
                public Vector addpolar(double deg, double dist) {
                	return new Vector(this.x + dist*Math.cos(Math.toRadians(deg)), this.y + dist*Math.sin(Math.toRadians(deg)));
                }
        		
        		public Vector subtract(Vector other) {
        			return new Vector(this.x - other.x, this.y - other.y);
        		}
        		
        		public double dot(Vector other) {
        			return this.x * other.x + this.y * other.y;
        		}
        		
        		public double cross(Vector other) {
        			return this.x * other.y - this.y * other.x;
        		}
        		
        		public double magnitude() {
        			return Math.hypot(this.x, this.y);
        		}  
        		public Vector scale(double s) {
        			return new Vector(x*s,y*s);
        		}
        		public Vector normalize() {
        			return scale(1/magnitude());
        		}
        		public double angle() {
        			return angleBetween(new Vector(1,0));
        		}
        		public double angleBetween(Vector o) {
        			return Math.atan2(cross(o), dot(o));
        		}
        		public Vector project(Vector o) {
        			return o.normalize().scale(scalarProject(o));
        		}
        		public double scalarProject(Vector o) {
        			return dot(o.normalize());
        		}
        		
        		
	}
	
//	public static double area(Vector[] points) {
//		double total = 0; 
//		for (int i = 0; i <points.length; i++) {
//			
//		}
//	}
	
	
}
