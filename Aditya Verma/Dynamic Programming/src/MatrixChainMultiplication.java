import java.util.Arrays;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] {40, 20, 30, 10, 30};
		int ans = matrixMultiplication(arr.length, arr);
		System.out.println("Ans: "+ans);
	}
	
	static int[][] T;
	static int matrixMultiplication(int N, int arr[])
    {
        int i=1, j=N-1;
        T = new int[N+1][N+1];
        
        for(int[] a: T)
        	Arrays.fill(a, -1);
        
        return solve(arr, i, j);
    }
	
	private static int solve(int[] arr, int i, int j) {
		
		if(i>=j) return 0;
		
		if(T[i][j]!=-1) return T[i][j];
		
		int ANS = Integer.MAX_VALUE;
		int tempAns;
		for(int k=i; k<j; k++) {
			int tempAns1 = solve(arr, i, k);
			int tempAns2 = solve(arr, k+1, j);
			
			tempAns = tempAns1 + tempAns2 + (arr[i-1]*arr[k]*arr[j]);
			ANS = Math.min(ANS, tempAns);
		}
		
		return T[i][j] = ANS;
	}

}
