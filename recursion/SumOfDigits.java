package recursion;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumOfDigit(2156));
	}

	static int sumOfDigit(int n) {
		if(n==0) {
			return 0;
		}
		 return n%10 + sumOfDigit(n/10);
	}

}
