//给你一个长度为 n下标从 0开始的字符串blocks，blocks[i]要么是'W'要么是'B'，表示第i块的颜色。字符'W' 和'B'分别表示白色和黑色。
//
//        给你一个整数k，表示想要连续黑色块的数目。
//
//        每一次操作中，你可以选择一个白色块将它 涂成黑色块。
//
//        请你返回至少出现 一次连续 k个黑色块的 最少操作次数。
//
//
//
//        示例 1：
//
//        输入：blocks = "WBBWWBBWBW", k = 7
//        输出：3
//        解释：
//        一种得到 7 个连续黑色块的方法是把第 0 ，3 和 4 个块涂成黑色。
//        得到 blocks = "BBBBBBBWBW" 。
//        可以证明无法用少于 3 次操作得到 7 个连续的黑块。
//        所以我们返回 3 。
//        示例 2：
//
//        输入：blocks = "WBWBBBW", k = 2
//        输出：0
//        解释：
//        不需要任何操作，因为已经有 2 个连续的黑块。
//        所以我们返回 0 。
//
//
//        提示：
//
//        n == blocks.length
//        1 <= n <= 100
//        blocks[i]要么是'W'，要么是'B' 。
//        1 <= k <= n
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class L2379 {
    public static int minimumRecolors(String blocks, int k) {
        if(blocks == null || blocks.length() < k) {
            return -1;
        }
        char[] chars = blocks.toCharArray();
        int res = Integer.MAX_VALUE;
        int head = 0;
        int tail = k-1;
        int curWhiteCount = 0;
        for (int i=0; i<k; i++) {
            if (chars[i] == 'W') {
                curWhiteCount++;
            }
        }
        res = curWhiteCount;

        while (res != 0 && tail < chars.length-1) {
            curWhiteCount = chars[head++] == 'W' ? curWhiteCount-1 : curWhiteCount;
            curWhiteCount = chars[++tail] == 'W' ? curWhiteCount+1 : curWhiteCount;
            res = Math.min(res, curWhiteCount);
        }

        return res;
    }

    public static void main(String[] a) {
        String s = "WBWBBBW";
        int k = 2;

        System.out.println(minimumRecolors(s, k));
    }
}
