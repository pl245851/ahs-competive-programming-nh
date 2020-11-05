import java.util.Scanner;

public class SemorCode {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String operation = scanner.next();
		
		int cases = scanner.nextInt();
		for (int c = 0; c < cases; c++) {
			Node root = new Node(4);
			int letters = 30;
			for (int i = 0; i < letters; i++) {
				String location = scanner.next();
				String ch = scanner.next();
				
				Node node = root.find(location);
				node.value = ch.charAt(0);
			}
			
			if (operation.equals("print")) {
				int queries = scanner.nextInt();
				for (int q = 0; q < queries; q++) {
					String location = scanner.next();
					Node n = root.find(location);
					
					System.out.println(Character.toString(n.value));
				}
			} else if (operation.equals("preorder")) {
				root.preorder();
				System.out.println();
			} else if (operation.equals("inorder")) {
				root.inorder();
				System.out.println();
			} else if (operation.equals("postorder")) {
				root.postorder();
				System.out.println();
			} else if (operation.equals("height")) {
				int heights = scanner.nextInt();
				for (int h = 0; h < heights; h++) {
					String location = scanner.next();
					Node n = root.find(location);
					
					System.out.println(n.height());
				}
			}
		}
	}
	
	public static class Node {
		private Node left, right;
		private Character value;
		
		/*
		 * Creates a new Node of the given height.
		 * Do not touch this code.
		 */
		public Node(int height) {
			if (height > 0) {
				left = new Node(height - 1);
				right = new Node(height - 1);
			}
		}
		
		/*
		 * This method should return the node found by following "location"
		 * from this particular node. For instance, if the "location" was
		 * ".-.", then we would want `this.left.right.left`, for example.
		 * When the location is empty, we should return this.
		 */
		public Node find(String location) {
			if(location.isEmpty()) {
				return this; // But only when location is empty!
			}
			else if (location.charAt(0)=='.') {
				return left.find(location.substring(1));
			}
			else {
				return right.find(location.substring(1));
			}
		}
		
		/*
		 * Print each character using "preorder" traversal from
		 * this node onward.
		 */
		public void preorder() {
			if(this.value != null) {
				System.out.print(this.value);
			}
			if(this.left != null) {
				this.left.preorder();
			}
			if(this.right!= null) {
				this.right.preorder();
			}
			
		}
		
		/*
		 * Print each character using "inorder" traversal from
		 * this node onward.
		 */
		public void inorder() {
			
			if(this.left != null) {
				this.left.inorder();
			}
			if(this.value != null) {
				System.out.print(this.value);
			}
			if(this.right!= null) {
				this.right.inorder();
			}
		}
		
		/*
		 * Print each character using "postorder" traversal from
		 * this node onward.
		 */
		public void postorder() {
			
			if(this.left != null) {
				this.left.postorder();
			}
			if(this.right!= null) {
				this.right.postorder();
			}
			if(this.value != null) {
				System.out.print(this.value);
			}
		}
		
		/*
		 * Return the height of the tree rooted from this node.
		 */
		public int height() {
			int max = 0;
			if(left!=null) {
				max = Math.max(max, left.height()+1);
			}
			if(right!=null) {
				max = Math.max(max, right.height()+1);
			}
			return max;
		}
	}
}