// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1/#

import java.util.Arrays;

public class KnapsackMemoization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = new int[] {1,2,3};
		int[] wt = new int[] {4,5,6};
		int W = 3;
		
		int ans = knapSack(W, wt, val, wt.length);
		System.out.println("Ans: "+ans);
	}

	static int T[][];
	
	//Function to return max value that can be put in knapsack of capacity W.
    private static int knapSack(int W, int wt[], int val[], int n) 
    { 
        T = new int[n+1][W+1];
        for(int[] arr: T) Arrays.fill(arr, -1);
        
       
        return solve(W, wt, val, n);
    }
    
    private static int solve(int W, int wt[], int val[], int n) {
    	
    	if(W==0 || n==0) return 0;
        
    	if(T[n][W]!=-1) return T[n][W];
    	
        if(wt[n-1]<=W) {
       	 int includeProfit = val[n-1] + solve(W-wt[n-1], wt, val, n-1);
       	 int notIncludeProfit = solve(W, wt, val, n-1);
       	 
       	 return T[n][W] = Math.max(includeProfit, notIncludeProfit);
       	 
        } else {
       	 return T[n][W] =  solve(W, wt, val, n-1);
        }
    }

}
