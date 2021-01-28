import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class chief {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			int problems = scanner.nextInt();
			double radius = scanner.nextDouble();
			ArrayList<box> nums = new ArrayList<>();
			for(int i =0; i< problems; i++) {
				nums.add(new box(scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble()));
			}
			Collections.sort(nums);
			boolean possible = true;
			for(int i =0; i< problems; i++) {
				if(radius<=nums.get(i).h) {
					possible = false;
					break;
				}
				else {
					radius = Math.sqrt(radius*radius + 3*nums.get(i).area/(4*3.141592653589793));
				}
			}
			if(!possible) {
				System.out.printf("Problem Set #%d: We need to rebuild this!%n", c+1);
			}
			else {
				System.out.printf("Problem Set #%d: It's going to be a good set!%n", c+1);
			}
		}

	}

	public static class box implements Comparable<box>{
	double w;
	double l;
	double h;
	double area;
	
	public box(double x, double y, double z){
		this.w = x;
		this.l = y;
		this.h = z;
		area = x*y*z;
	}

	public int compareTo(box o) {
		return (int) (this.h - o.h);
	}
	
	}
	
}

