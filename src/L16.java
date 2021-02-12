
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
        // 先排序
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        // loop + 2 pointers
        for(int i=0; i<len-2; i++) {
            int l = i+1;
            int r = len-1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];// -3
                if(Math.abs(target-sum) < Math.abs(target-res)) res = sum;
                if(sum > target) {
                    r--;
                    // 解决nums[r]重复
                    while(l < r && nums[r] == nums[r+1]) r--;
                }
                else {
                    l++;
                    // 解决nums[l]重复
                    while(l < r && nums[l] == nums[l-1]) l++;
                }
            }
            // 解决nums[i]重复
            while(i<len-2 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
