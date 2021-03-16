//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1204 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class L46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        bt(nums, 0, used, new ArrayList<Integer>(), res);
        return res;
    }

    private static void bt(int[] nums, int idx, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i< nums.length; i++){
            if(used[i]) {
                continue;
            }

            used[i] = true;
            list.add(nums[i]);
            bt(nums, i, used, list, res);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)