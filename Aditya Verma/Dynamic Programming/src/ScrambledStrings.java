import java.util.HashMap;

public class ScrambledStrings {
	
	public static void main(String[] args) {
		
		String s1 ="abcdefghijklmnopq";
		String s2 ="efghijklmnopqcadb";
		
		boolean ans = isScramble(s1, s2);
		System.out.println("Ans: "+ans);
	}
	
	static HashMap<String, Boolean> T;
	public static boolean isScramble(String s1, String s2) {
		
		T = new HashMap<>();
        return solve(s1, s2);
    }
	
	private static boolean solve(String a, String b) {
		
		if(a.length()!=b.length()) return false;
		
		String key = new StringBuilder(a+" "+b).toString();
		if(T.containsKey(key)) return T.get(key);
		
		if(a.equals(b)) return true;
		
		if(a.length()<=1) return false;
		
		boolean isScramble = false;
		for(int k=1; k<a.length(); k++) {
			boolean noSplit = solve(a.substring(0,k), b.substring(0,k)) &&
								solve(a.substring(k), b.substring(k));
			
			boolean split = solve(a.substring(0,k), b.substring(b.length()-k)) &&
					solve(a.substring(k), b.substring(0,b.length()-k));
			
			if(split || noSplit) isScramble = true;
		}
		
		T.put(key, isScramble);
		return isScramble;
	}

}
