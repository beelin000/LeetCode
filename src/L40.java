//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。
//
// 说明：
//
//
// 所有数字（包括目标数）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//
//
// 示例 2:
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]
// Related Topics 数组 回溯算法
// 👍 525 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class L40 {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);

        bt(nums, target, 0, 0, new boolean[nums.length], new ArrayList<>(), res);

        return res;
    }

    private static void bt(int[] nums, int target, int idx, int sum, boolean[] used,
                           List<Integer> list, List<List<Integer>> res) {
        if(sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > target) {
            return;
        }

        for(int i=idx; i< nums.length; i++) {
            // used[i - 1] == true，说明同一树支candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if(used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            sum += nums[i];
            used[i] = true;
            list.add(nums[i]);
            bt(nums, target, i+1, sum, used ,list, res);
            list.remove(list.size()-1);
            used[i] = false;
            sum -= nums[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
