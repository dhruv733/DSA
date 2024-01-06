package binarySearch;

//this is also called as Biotonic Array
//eg: 1234321 or 134597531
public class PeakIndexMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 4, 7, 9, 14, 19, 3, 2, 1, 1, 1, 1, 1 };
//		int target = 19;

		int ans1 = binarySearch1(arr);
		int start = 0;
		int end = arr.length - 1;
		int mid = start + (end - start) / 2;
		int ans2 = binarySearch2(arr, mid);
		int ans3 = binarySearch3(arr, start, end, mid);
		System.out.println(ans3);
	}

	// normal method
	static int binarySearch1(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return i;
			}
		}
		return -1;
	}

	// optimized
	private static int binarySearch2(int[] arr, int mid) {
		// TODO Auto-generated method stub
		if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
			mid++;
			return binarySearch2(arr, mid);
		} else if (arr[mid] < arr[mid - 1] && arr[mid] > mid + 1) {
			mid--;
			return binarySearch2(arr, mid);
		} else if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
			return mid;
		}

		return 0;
	}

	// more optimized
	private static int binarySearch3(int[] arr, int start, int end, int mid) {
		// TODO Auto-generated method stub
		if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
			start = mid - 1;
			mid = start + (end - start) / 2;
			return binarySearch3(arr, start, end, mid);
		} else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
			end = mid + 1;
			mid = start + (end - start) / 2;
			return binarySearch2(arr, mid);
		} else if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
			return mid;
		}

		return 0;
	}

}
