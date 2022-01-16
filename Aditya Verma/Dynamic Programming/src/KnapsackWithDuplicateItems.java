
public class KnapsackWithDuplicateItems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] val = new int[] {1, 4, 5, 7};
		int[] wt = new int[] {1, 3, 4, 5};
		int W = 8;
		
		int ans = knapSack(val.length, W, val, wt);
		System.out.println("Ans: "+ans);
		
	}
	
	static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] T = new int[N+1][W+1];
        
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=W; j++) {
        		if(wt[i-1]<=j) {
        			T[i][j] = Math.max(val[i-1]+T[i][j-wt[i-1]],T[i-1][j]);
        		} else {
        			T[i][j] = T[i-1][j];
        		}
        	}
        }
        
        return T[N][W];
    }

}
