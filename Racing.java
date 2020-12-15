import java.io.IOException;
import java.util.Scanner;

public class Racing {
	
	public static class Vector {
		double x, y;
		public Vector(double x, double y) {
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
	
	public static double angleBetween(Vector before, Vector at, Vector after) {
		Vector left = before.subtract(at);
		Vector right = after.subtract(at);
		
		return Math.atan2(left.cross(right), left.dot(right));
	}

    public static boolean angleSharperThan(double thisAngle, double bestAngle) {
    	double thisDifference = Math.abs(Math.PI - Math.abs(thisAngle));
    	double bestDifference = Math.abs(Math.PI - Math.abs(bestAngle));
    	
    	if (thisDifference < bestDifference) {
    		return false;
    	}
    	
    	return true;
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int races = scanner.nextInt();
		for (int race = 1; race <= races; race++) {
			int turns = scanner.nextInt();
			Vector[] points = new Vector[turns];
			for (int t = 0; t < turns; t++) {
				points[t] = new Vector(scanner.nextDouble(), scanner.nextDouble());
			}
			
			int sharpestTurn = 1;
			
			// Populate the starting value for the sharpestAngle
			double sharpestAngle = Math.PI;
			for (int i = 0; i < turns; i++) {
				// Neat trick to always get the previous value of an array,
				// even if you are considering the first point.
				Vector pointBefore = points[(i + turns - 1) % turns];
				Vector pointAt = points[i];
				
				// This allows you to "wrap around" the array to the beginning
				// when you reach the end.
				Vector pointAfter = points[(i + 1) % turns];
				
				double angle = angleBetween(pointBefore, pointAt, pointAfter);
				if (angleSharperThan(angle, sharpestAngle)) {
					sharpestTurn = i;
					sharpestAngle = angle;
				}
			}
			
			System.out.printf("Race #%d: Turn %d is the most exciting!%n", race, sharpestTurn + 1);
		}
	}
}