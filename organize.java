import java.util.Scanner;

public class organize {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int box = 0;
		while(scanner.hasNext()) {
			box++;
			int h = scanner.nextInt();
			int w = scanner.nextInt();
			int d = scanner.nextInt();
			int disks = scanner.nextInt();
			if(h==0&&w==0&&d==0&disks==0) {
				return;
			}
			else {
				if((h>=120&&w>=120)) {
					if (d>=disks*2) {
						System.out.printf("Box %d: Stack of %d discs fits!%n", box, disks);
					}
					else if(w>=120&&d>=120) {
						if (h>=disks*2) {
							System.out.printf("Box %d: Stack of %d discs fits!%n", box, disks);
						}
						else if(d>=120&&h>=120) {
							if (w>=disks*2) {
								System.out.printf("Box %d: Stack of %d discs fits!%n", box, disks);
							}
							else {
								System.out.printf("Box %d: Stack of %d discs does not fit.%n", box, disks);
							}
						}
						else {
						System.out.printf("Box %d: Stack of %d discs does not fit.%n", box, disks);
					    }
					}
					else {
						System.out.printf("Box %d: Stack of %d discs does not fit.%n", box, disks);
					}
				}
				else if(w>=120&&d>=120) {
					if (h>=disks*2) {
						System.out.printf("Box %d: Stack of %d discs fits!%n", box, disks);
					}
					else if(d>=120&&h>=120) {
						if (w>=disks*2) {
							System.out.printf("Box %d: Stack of %d discs fits!%n", box, disks);
						}
						else {
							System.out.printf("Box %d: Stack of %d discs does not fit.%n", box, disks);
						}
					}
					else {
						System.out.printf("Box %d: Stack of %d discs does not fit.%n", box, disks);
					}
				}
				else if(d>=120&&h>=120) {
					if (w>=disks*2) {
						System.out.printf("Box %d: Stack of %d discs fits!%n", box, disks);
					}
					else {
						System.out.printf("Box %d: Stack of %d discs does not fit.%n", box, disks);
					}
				}
				else {
					System.out.printf("Box %d: Stack of %d discs does not fit.%n", box, disks);
				}
			}
		}



	}

}
