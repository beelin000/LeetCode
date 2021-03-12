//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// 👍 829 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class L35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length-1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] > target) {
                high = mid-1;
            }

            else if(nums[mid] < target) {
                low = mid;
            }
            else {
                return mid;
            }
            high++;
        }
        return target > nums[low] ? low+1 : low;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
