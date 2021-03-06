// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1/

public class KnapsackRecursion {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] val = new int[] {1,2,3};
		int[] wt = new int[] {4,5,6};
		int W = 3;
		
		int ans = knapSack(W, wt, val, wt.length);
		System.out.println("Ans: "+ans);
		

	}
	
	//Function to return max value that can be put in knapsack of capacity W.
    private static int knapSack(int W, int wt[], int val[], int n) 
    { 
         if(W==0 || n==0) return 0;
         
         if(wt[n-1]<=W) {
        	 int includeProfit = val[n-1] + knapSack(W-wt[n-1], wt, val, n-1);
        	 int notIncludeProfit = knapSack(W, wt, val, n-1);
        	 
        	 return Math.max(includeProfit, notIncludeProfit);
        	 
         } else {
        	 return knapSack(W, wt, val, n-1);
         }
    } 

}
