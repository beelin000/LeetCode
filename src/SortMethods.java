public class SortMethods {
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

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5};
        int t = 1;
        System.out.println(binarySearch(nums,t));

    }
}
