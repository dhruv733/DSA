package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstAndLastPosition {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 7, 9, 14, 14, 14, 14, 19 };
		int target = 15;
		
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(binarySearch(arr, target, true));
		answer.add(binarySearch(arr, target, false));
		System.out.println(answer);
		Integer[] answer1 = {-1,-1};
		answer1[0] = binarySearch(arr, target, true);
		answer1[1] = binarySearch(arr, target, false);
		System.out.println(Arrays.asList(answer1));
		System.out.println("{" + answer1[0] + ", " + answer1[1] + "}");
	}

	static int binarySearch(int[] arr, int target, Boolean isStart) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			// int mid = (start + end)/2;
			int mid = start + (end - start) / 2;

			if (target < arr[mid]) {
				end = mid - 1;
			} else if (target > arr[mid]) {
				start = mid + 1;
			} else {
				if (isStart) {
					// ans found
					return mid;
				} else {
					for (int i = mid; i < arr.length; i++) {
						if (arr[i + 1] == arr[mid]) {
							continue;
						} else {
							return i;
						}
					}

				}

			}
		}
		// answer not found
		return -1;
	}
}