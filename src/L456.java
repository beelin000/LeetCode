//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
//
//
//
// 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
//
//
// 示例 2：
//
//
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
//
//
// 示例 3：
//
//
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 104
// -109 <= nums[i] <= 109
//
// Related Topics 栈
// 👍 464 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class L456 {
    // 单调栈递减的栈存可以为 ‘2’的元素
    // max_2维护出栈的最大值
    // nums[i]与max_2比较，若nums[i] < max_2,则可以作为‘1’，找到答案
    // 否则栈弹出所有严格小于nums[i]的元素，若弹出元素大于max_2则同时更新max_2，nums[i]入栈

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int max_2 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[nums.length-1]);
        for (int i=nums.length-2; i>=0; i--) {
            if(nums[i] < max_2) {
                return true;
            }
            if(!stack.empty() && nums[i] == stack.peek()) {
                // 此时max_2 不会扩大，nums[i]之后也会被弹出栈，所以可以跳过
                continue;
            }
            while (!stack.empty() && nums[i] > stack.peek()) {
                max_2 = Math.max(stack.pop(), max_2);
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
