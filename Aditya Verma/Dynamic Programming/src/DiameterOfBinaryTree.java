
public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int ans;
	int diameter(Node root) {
	    if(root==null) return 0;
		ans = Integer.MIN_VALUE;
		solve(root);
		return ans;
    }
	
	int solve(Node root) {
		if(root==null) return 0;
		
		int left = solve(root.left);
		int right = solve(root.right);
		
		int temp = Math.max(left, right) + 1;
		ans = Math.max(ans, left+right+1);
		
		return temp;
	}
	
	private class Node {
	    int data;
	    Node left;
	    Node right;
	    Node(int data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

}
