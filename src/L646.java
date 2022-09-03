//给出n个数对。在每一个数对中，第一个数字总是比第二个数字小。
//
//        现在，我们定义一种跟随关系，当且仅当b < c时，数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链。
//
//        给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
//
//
//        示例：
//
//        输入：[[1,2], [2,3], [3,4]]
//        输出：2
//        解释：最长的数对链是 [1,2] -> [3,4]


import java.util.Arrays;

public class L646 {
    public static int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int curTail = pairs[0][1];
        int res = 1;
        for (int i=1; i<pairs.length; i++) {
            int[] curPair = pairs[i];
            if (curPair[0] > curTail) {
                res++;
                curTail = curPair[1];
            }
        }

        return res;
    }



    public static void main(String[] ars) {
        int[][] a = new int[][]{{1,2}, {2,3}, {3,4}};
        System.out.println(findLongestChain(a));
    }
}
