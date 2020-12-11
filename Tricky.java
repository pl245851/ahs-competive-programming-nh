import java.io.IOException;
import java.util.Scanner;

public class Tricky {
	
	public static class Vector {
		int x, y;
		
		public Vector(int x, int y) {
			this.x = x;
			this.y = y;
		}

                public Vector add(Vector other) {
        			return new Vector(this.x + other.x, this.y + other.y);
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
        			return Math.sqrt(this.x * this.x + this.y * this.y);
        		}

	}
	
	public static double getProteinForCracker(Vector a, Vector b, Vector c) {
		double amag = a.subtract(b).magnitude();
	    double bmag = b.subtract(c).magnitude();
	    double cmag = c.subtract(a).magnitude();
		double s = (amag+bmag+cmag)/2;
		double area = Math.sqrt(s*(s-amag)*(s-bmag)*(s-cmag));
		return area;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int crackers = scanner.nextInt();
		
		for (int cracker = 1; cracker <= crackers; cracker++) {
			Vector a = new Vector(scanner.nextInt(), scanner.nextInt());
			Vector b = new Vector(scanner.nextInt(), scanner.nextInt());
			Vector c = new Vector(scanner.nextInt(), scanner.nextInt());
			
			double protein = getProteinForCracker(a, b, c);
			System.out.printf("Cracker #%d: %.2f grams of protein%n", cracker, protein);
		}
	}
}