import java.util.Arrays;

public class EggDroppingPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int e = 2;
		int f = 10;
		
		int ans = eggDrop(e, f);
		System.out.println("Ans: "+ans);
	}
	
	static int[][] T;
	static int eggDrop(int e, int f) {
	    
		T = new int[e+1][f+1];
		for(int[] a: T)
			Arrays.fill(a, -1);
		
		return solve(e,f);
	}
	
	private static int solve(int eggs, int floors) {
		
		if(floors==0|| floors==1) return floors;
		
		if(eggs==1) return floors;
		
		if(T[eggs][floors]!=-1) return T[eggs][floors];
		
		int ans = Integer.MAX_VALUE;
		for(int k=1; k<=floors; k++) {
			int temp = Math.max(solve(eggs-1, k-1), solve(eggs, floors-k)) + 1;
			ans = Math.min(ans, temp);
		}
		
		return T[eggs][floors]=ans;
	}

}
