
public class MaximumPathSumFromAnyNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	static int ans;
    int findMaxSum(Node node) {
    	
    	ans = Integer.MIN_VALUE;
    	solve(node);
    	return ans;
    }
    
    private int solve(Node node) {
    	if(node==null) return 0;
    	
    	int left = solve(node.left);
    	int right = solve(node.right);
    	
    	int temp = Math.max(Math.max(left, right)+node.data, node.data);
    	ans = Math.max(ans, left+right+node.data);
    	ans = Math.max(ans, temp);
    	
    	return temp;
    }
    
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

}
