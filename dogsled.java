import java.util.Scanner;

public class dogsled {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int i = 0; i<cases; i++) {
			double angle = 0;
			Vector here = new Vector(0, 0);
			String command = scanner.next();
			while(!command.equals("Whoa!")) {
				if(command.equals("Hike!")) {
					here = here.addpolar(angle, 50);
				}
				else if(command.equals("Haw!")) {
					angle+=10;
				}
				else if(command.equals("Gee!")) {
					angle-=10;
				}
				command = scanner.next();
			}
			double distx = Math.abs(here.x -500);
			double disty = Math.abs(here.y);
			if(distx<=15.00001&&disty<=15.00001) {
				System.out.printf("Simulation #%d: Made it!%n", i+1);
			}
			else {
				System.out.printf("Simulation #%d: We're lost, eh?%n", i+1);
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
        			return Math.sqrt(this.x * this.x + this.y * this.y);
        		}  

	}
}
