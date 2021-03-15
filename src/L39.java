//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。
//
// 说明：
//
//
// 所有数字（包括 target）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1：
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
//
//
// 示例 2：
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
//
//
//
// 提示：
//
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// candidate 中的每个元素都是独一无二的。
// 1 <= target <= 500
//
// Related Topics 数组 回溯算法
// 👍 1218 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class L39 {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(arr == null || arr.length == 0) {
            return res;
        }
        bt(arr, 0, target, 0, new ArrayList<Integer>(), res);

        return res;
    }

    private static void bt(int[] arr, int curIdx, int target, int curSum, List<Integer> list, List<List<Integer>> res) {
        if(curSum == target) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(curSum > target) return;

        for (int i=curIdx; i<arr.length; i++) {
            curSum += arr[i];
            list.add(arr[i]);
            bt(arr, i, target, curSum, list, res);
            list.remove(list.size()-1);
            curSum -= arr[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
