package smallToBig;

public class Test {
	//不需要弄那么麻烦 这样就行了 
	public static void main(String[] args) {
		String s = "AHn9&nGJMm";
		System.out.println(s.toUpperCase());
/*		for (int i = 0; i < s.length(); i++) {
			// 如果是小写
			if (s.substring(i, i + 1).equals(s.substring(i, i + 1).toLowerCase())) {
				System.out.print(s.substring(i, i + 1).toUpperCase());
			} else {
				System.out.print(s.substring(i, i + 1).toLowerCase());
			}
		}*/
	}
}
