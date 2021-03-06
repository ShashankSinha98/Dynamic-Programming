
public class SubsetSumProblemRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] {3, 34, 4, 12, 5, 2};
		int sum = 30;
		boolean ans = isSubsetSum(arr.length, arr, sum);
		System.out.println("Ans: "+ans);
	}
	
	static Boolean isSubsetSum(int N, int arr[], int sum){
        
		if(N==0 && sum!=0) return false;
		else if(sum==0) return true;
		
		if(arr[N-1]<=sum) {
			boolean a1 = isSubsetSum(N-1, arr, sum-arr[N-1]); // include
			boolean a2 = isSubsetSum(N-1, arr, sum); // don't
			
			return a1 || a2;
		} else {
			return isSubsetSum(N-1, arr, sum);
		}
    }

}
