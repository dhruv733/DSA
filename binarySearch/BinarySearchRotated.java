package binarySearch;

public class BinarySearchRotated {
	public static void main(String[] args) {
		int[] arr = { 21,22,23,24, 0, 1, 4, 7, 9, 14, 19 };
		int target = 1;
		int ans = binarySearchRotated(arr, target);
		System.out.println(ans);
	}

	static int binarySearchRotated(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {

			int mid = start + (end - start) / 2;
			
			if(arr[mid]==target) {
				return mid;
			}
			
			// right is sorted
			if (arr[mid] <= arr[end]) {
				if (target <= arr[end] && target >= arr[mid]) {
					// preset
					start = mid + 1;
				} else {
					end = mid - 1;
				}

			}
			// left is sorted
			else {
				if (target >= arr[start] && target <= arr[mid]) {
					// preset
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		// answer not found
		return -1;
	}

}
