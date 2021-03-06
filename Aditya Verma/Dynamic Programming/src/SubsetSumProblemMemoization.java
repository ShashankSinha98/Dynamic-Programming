import java.util.Arrays;

public class SubsetSumProblemMemoization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {3, 34, 4, 12, 5, 2};
		int sum = 9;
		boolean ans = isSubsetSum(arr.length, arr, sum);
		System.out.println("Ans: "+ans);
	}

	static int[][] T;
	
	static Boolean isSubsetSum(int N, int arr[], int sum){
        
		T = new int[N+1][sum+1];
		for(int[] a: T)
			Arrays.fill(a, -1);
		
		return solve(N, arr, sum);
    }
	
	private static Boolean solve(int N, int arr[], int sum) {
		if(N==0 && sum!=0) return false;
		else if(sum==0) return true;
		
		if(T[N][sum]!=-1) {
			return T[N][sum]==1?true:false;
		}
		
		if(arr[N-1]<=sum) {
			boolean a1 = solve(N-1, arr, sum-arr[N-1]); // include
			boolean a2 = solve(N-1, arr, sum); // don't
			boolean ans = a1 || a2;
			if(ans) T[N][sum] = 1; else T[N][sum] = 0;
			
			return ans;
		} else {
			boolean ans = solve(N-1, arr, sum);
			if(ans) T[N][sum] = 1; else T[N][sum] = 0;
			
			return ans; 
		}
	}
}
