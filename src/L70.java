
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
// 👍 1669 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    public class L70 {

        // DP: f(n) = f(n-1) + f(n-2)
        // 方法1： 迭代
        public int climbStairs(int n) {
            int[] res = new int[n+1];
            // climb 0 stair -> 1 solution
            res[0] = 1;
            // climb 1 stair -> 1 solution
            res[1] = 1;

            for (int i = 2; i< res.length; i++) {
                // f(n) = f(n-1) + f(n-2)
                // 爬n层楼梯的解 = 爬n-1层的解 + 爬n-2层的解
                res[i] = res[i-1] + res[i-2];
            }
            return res[n];
        }

        // DP: f(n) = f(n-1) + f(n-2)
        // 方法2： 记忆递归
        public int climbStairs2(int n) {
            int[] res = new int[n+1];
            // climb 0 stair -> 1 solution
            res[0] = 1;
            // climb 1 stair -> 1 solution
            res[1] = 1;
            return climbStairRecursive(n, res);
        }

        // DP: f(n) = f(n-1) + f(n-2)
        // 方法1： 迭代
        private int climbStairRecursive(int n, int[] res) {
            if (n == 0) return 1;
            if (n == 1) return 1;
            if (res[n] != 0) return res[n];
            res[n] = climbStairRecursive(n-1, res) + climbStairRecursive(n-2, res);
            return res[n];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)