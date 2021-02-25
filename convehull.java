import java.util.Arrays;
import java.util.List;

public class convehull {
	
	public static List<Vector> convexhull(Vector[] points){
		Arrays.sort(points);
		
		Vector[] lower = new Vector[points.length];
		int index = 0;
		for(Vector v : points) {
			if(index<2) {
				lower[index++] = v;
				continue;
			}
			Vector previous = lower[index-1].subtract(lower[index-2]);
			
			if(previous.cross(v)>0) {
				lower[index++] = v;
			}
			else {
				do {index--;
				
				}while(index>=2 && lower[index-1].subtract(lower[index-2]).cross(v)<0);
			}
			
			lower[index++] = v;
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
}
