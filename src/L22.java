//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 回溯算法
// 👍 1565 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class L22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        dfs("", n ,n, res);
        return res;
    }

    /**
     * 回溯+剪枝
     * @param cur 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private static void dfs(String cur, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        if(left == 0 && right == 0) {
            res.add(cur);
            return;
        }

        // 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        // 如： cur --> ")", "())"
        if(left > right) {
            return;
        }

        if(left > 0 ) {
            dfs(cur + '(', left-1, right, res);
        }

        if(right > 0) {
            dfs(cur + ')', left, right-1, res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
