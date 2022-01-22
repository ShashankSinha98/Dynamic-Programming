
public class MinimumAndMaximumValuesOfAnExpressionWithMultiplyAndDivide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "1+2*3+4*5";
		int ans = minValue(s);
		System.out.println("Min ans: "+ans);
		
		ans = maxValue(s);
		System.out.println("Max ans: "+ans);
	}
	
	static int minValue(String s) {

		if(s.length()==1) {
			return s.charAt(0)-'0';
		}
		
		int ans = Integer.MAX_VALUE;
		for(int k=1; k<s.length(); k+=2) {
			int left = minValue(s.substring(0, k));
			int right = minValue(s.substring(k+1));
			
			if(s.charAt(k)=='+') 
				ans = Math.min(ans, left+right);
			else if(s.charAt(k)=='*')
				ans = Math.min(ans, left*right);
		}
		
		return ans;
	}
	
	static int maxValue(String s) {

		if(s.length()==1) {
			return s.charAt(0)-'0';
		}
		
		int ans = Integer.MIN_VALUE;
		for(int k=1; k<s.length(); k+=2) {
			int left = maxValue(s.substring(0, k));
			int right = maxValue(s.substring(k+1));
			
			if(s.charAt(k)=='+') 
				ans = Math.max(ans, left+right);
			else if(s.charAt(k)=='*')
				ans = Math.max(ans, left*right);
		}
		
		return ans;
	}
	
	

}
