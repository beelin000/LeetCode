public class L704 {
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int l = 0;
        int r = len-1;

        while (l < r) {
            int mid = l + (r-l)/2;
            if (nums[mid] < target) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
