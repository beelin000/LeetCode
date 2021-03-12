public class SortMethods {
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5};
        int t = 1;
        System.out.println(binarySearch(nums,t));

    }
}
