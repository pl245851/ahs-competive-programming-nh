import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class chief {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			int problems = scanner.nextInt();
			double area = Math.pow(scanner.nextDouble(),3)*4*3.141592653589793/3;
			ArrayList<box> nums = new ArrayList<>();
			for(int i =0; i< problems; i++) {
				nums.add(new box(scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble()));
			}
			Collections.sort(nums);
			boolean possible = true;
			for(int i =0; i< problems; i++) {
				if(Math.pow(area*3/4/3.141592653589793,1/3)<=nums.get(i).h/2) {
					possible = false;
					break;
				}
				else {
					area = area + nums.get(i).area;
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
		return Double.compare(this.h, o.h);
	}
	
	}
	
}

/*
2
4 5.0
10.0 10.0 10.0
10.0 10.0 10.0
10.0 10.0 10.0
10.0 10.0 10.0
6 5.0
20.0 20.0 1.0
20.0 20.0 2.0
20.0 20.0 3.0
20.0 20.0 4.0 
20.0 20.0 5.0
20.0 20.0 11.0

 */

