package testing;

public class LowerAndUpperBound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { 3, 3, 3, 3, 3, 5, 5, 7, 7, 7, 7, 33 };
		int target = 7;
		System.out.println(lowerBound(arr, target));
		System.out.println(upperBound(arr, target));

	}

	private static int lowerBound(int[] arr, int target) {

		int start = 0;
		int end = arr.length - 1;
		int lower = -1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (target < arr[mid]) {
//				lower = mid;
				end = mid - 1;
			} else if (target == arr[mid]) {
				lower = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return lower;
	}

	private static int upperBound(int[] arr, int target) {

		int start = 0;
		int end = arr.length - 1;
		int upper = -1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (target > arr[mid]) {
//				upper = mid;
				start = mid + 1;
			} else if (target == arr[mid]) {
				upper = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return upper;
	}

}
