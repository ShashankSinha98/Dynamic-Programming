
public class KnapsackTopBottom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = new int[] {1,2,3};
		int[] wt = new int[] {4,5,1};
		int W = 3;
		
		int ans = knapSack(W, wt, val, wt.length);
		System.out.println("Ans: "+ans);
	}
	
	 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
       int[][] T = new int[n+1][W+1];
       
       // base case
       for(int r=0; r<=n; r++) T[r][0] = 0;
       for(int c=0; c<=W; c++) T[0][c] = 0;
       
       for(int ni=1; ni<=n; ni++) {
    	   for(int wi=1; wi<=W; wi++) {
    		   if(wt[ni-1]<=wi) {
    			   T[ni][wi] = Math.max(val[ni-1]+T[ni-1][wi-wt[ni-1]],
    					   				T[ni-1][wi]);
    		   } else {
    			   T[ni][wi] = T[ni-1][wi];
    		   }
    	   }
       }
       
       return T[n][W];
    } 

}
