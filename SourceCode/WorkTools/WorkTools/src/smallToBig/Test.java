package smallToBig;

public class Test {
	public static void main(String[] args) {
		String str ="abcd";
		char[] arr = str.toCharArray();   //�ָ��ַ���Ϊchar����
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(String.valueOf(arr));   //�ϲ�char����Ϊ�ַ���
	}
}