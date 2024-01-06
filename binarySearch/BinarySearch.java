package binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 7, 9, 14, 19 };
        int target = 14;
        int ans = binarySearch(arr, target);
        System.out.println(ans);
    }

    static int binarySearch(int[] arr, int target) {
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
                // ans found
                return mid;
            }
        }
        //answer not found
        return -1;
    }
}