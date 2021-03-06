
public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] price = new int[] {3, 5, 8, 9, 10, 17, 17, 20};

		
		int ans = cutRod(price, price.length);
		System.out.println("Ans: "+ans);
	}
	
	public static int cutRod(int price[], int n) {
        
		return solve(price, n, n);
    }
	
	private static int solve(int[] price, int L, int n) {
		
		int[][] T = new int[n+1][L+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=L; j++) {
				if(i<=j) {
					T[i][j] = Math.max(price[i-1]+T[i][j-i], T[i-1][j]);
				} else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		return T[n][L];
	}
}
