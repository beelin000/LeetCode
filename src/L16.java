
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。
//
//
//
// 示例：
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4
//
// Related Topics 数组 双指针
// 👍 683 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class L16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        // loop + 2 pointers
        int l=0, r=nums.length-1;
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            l = i+1;
            int sum = nums[i] + nums[l] + nums[r];
            while(l < r){
                if (sum == target) return sum;

                else if(sum > target) {
                    while (nums[i] + nums[l] + nums[r] > target){
                        l++;
                    }
                }
                else if(sum < target){
                    res = Math.min(res, nums[i] + nums[l] + nums[r]);
                    l++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
