

public class MaximumPathSumBetween2LeafNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int ans;
    int maxPathSum(Node node) {
    	
    	ans = Integer.MIN_VALUE;
    	solve(node);
    	return ans;
    }
    
    private int solve(Node node) {
    	if(node.left==null && node.right==null) return node.data;
    	
    	int left = solve(node.left);
    	int right = solve(node.right);
    	
    	int temp = Math.max(left, right)+node.data;
    	ans = Math.max(ans, left+right+node.data);
    	
    	return temp;
    }
	
	class Node
	{
	    int data;
	    Node left, right;

	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}

}
