//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//
// 进阶：
//
//
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
// 你能想出一个仅使用常量空间的解决方案吗？
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
//
//
// 示例 2：
//
//
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
//
// Related Topics 数组
// 👍 462 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class L73 {
    public void setZeroes(int[][] m) {
        if(m == null || m.length == 0 || m[0].length == 0) {
            return;
        }

        // if 1st row has 0, flag1 = true
        // if 1st col has 0, flag2 = true
        boolean flag1 = false;
        boolean flag2 = false;


        // mark row 1
        for (int i : m[0]) {
            if(i == 0) {
                flag1 = true;
                break;
            }
        }

        // mark col 1
        for (int i=0; i< m.length; i++) {
            if (m[i][0] == 0) {
                flag2 = true;
                break;
            }
        }

        // traverse matrix except row1 and col1
        for (int i=1; i< m.length; i++) {
            for(int j=1; j<m[0].length; j++) {
                if (m[i][j] == 0) {
                    // mark 0
                    m[0][j] = 0;
                    m[i][0] = 0;
                }
            }
        }

        // set zeroes for row[1], col[1]
        for (int i=1; i< m.length; i++) {
            for(int j=1; j<m[0].length; j++) {
                if (m[0][j] == 0 || m[i][0] == 0) {
                    // set 0
                    m[i][j] = 0;
                }
            }
        }

        // set 1st row
        for (int i=0; i<m[0].length; i++) {
            if(flag1) {
                m[0][i] = 0;
            }
        }

        // set 1st col
        for (int i=0; i<m.length; i++) {
            if(flag2) {
                m[i][0] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
