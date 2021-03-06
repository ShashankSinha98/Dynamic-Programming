import java.util.*;
public class MinimumSubsetSumDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1, 4};
		int ans = minDifference(arr, arr.length);
		System.out.println("Ans: "+ans);
	}
	

	public static int minDifference(int arr[], int n) 
	{ 
		int sum=0;
		for(int ai:arr) sum+=ai;
		
		boolean[][] T = new boolean[n+1][sum+1];
		
		for(int i=0; i<=sum; i++) T[0][i] = false;
		for(int i=0; i<=n; i++) T[i][0] = true;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=sum; j++) {
				
				if(arr[i-1]<=j) {
					T[i][j] = T[i-1][j-arr[i-1]] || T[i-1][j]; 
				} else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		boolean lastRow[] = T[n];
		int ans = 0;
		for(int i=sum/2; i>=0; i--) {
			if(lastRow[i]) {
			    ans = sum - (2*i);
			    break;
			}
		}
		
		return ans;
	}  

}
