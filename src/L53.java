//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：0
//
//
// 示例 4：
//
//
//输入：nums = [-1]
//输出：-1
//
//
// 示例 5：
//
//
//输入：nums = [-100000]
//输出：-100000
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// -105 <= nums[i] <= 105
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治 动态规划
// 👍 3433 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class L53 {
    // 动态规划 dp[i]表示以数组中下表i结尾的字数组的最大和
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0]; // init first result;
        int max = dp[0];
        for (int i=1; i<len; i++) {
            // dp[i] = max(nums[i], nums[i]+dp[i-1])
            dp[i] = dp[i-1] > 0 ? dp[i-1]+nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 动态规划 dp[i]表示以数组中下表i结尾的字数组的最大和
    // 滚动记忆优化，空间复杂变为O（1）
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if (len == 1) return nums[0];
        int prevMax = nums[0];
        int max = prevMax;
        for (int i=1; i<len; i++) {
            // cur = max(nums[i], nums[i]+prevMax)
            int cur = prevMax > 0 ? prevMax+nums[i] : nums[i];
            max = Math.max(max, cur);
            prevMax = cur;
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, -2, 1};
        System.out.println(maxSubArray2(arr));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
