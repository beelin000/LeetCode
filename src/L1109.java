//这里有 n 个航班，它们分别从 1 到 n 进行编号。 
//
// 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 
//firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。 
//
// 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//输出：[10,55,45,25,25]
//解释：
//航班编号        1   2   3   4   5
//预订记录 1 ：   10  10
//预订记录 2 ：       20  20
//预订记录 3 ：       25  25  25  25
//总座位数：      10  55  45  25  25
//因此，answer = [10,55,45,25,25]
// 
//
// 示例 2： 
//
// 
//输入：bookings = [[1,2,10],[2,2,15]], n = 2
//输出：[10,25]
//解释：
//航班编号        1   2
//预订记录 1 ：   10  10
//预订记录 2 ：       15
//总座位数：      10  25
//因此，answer = [10,25]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁴ 
// 1 <= bookings.length <= 2 * 10⁴ 
// bookings[i].length == 3 
// 1 <= firsti <= lasti <= n 
// 1 <= seatsi <= 10⁴ 
// 
// Related Topics 数组 前缀和 👍 259 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class L1109 {
    // 暴力遍历O(n^2)
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        if (bookings == null || bookings.length == 0) {
            return res;
        }
        for (int[] booking :  bookings) {
            addBooking(res, booking);
        }

        return res;
    }

    private void addBooking(int[] res, int[] b) {
        int first = b[0]-1;
        int last = b[1]-1;
        int bookings = b[2];
        for (int i=first; i<=last; i++) {
            res[i] += bookings;
        }
    }

    // 差分数组: arr[i] = bookings[i] - bookings[i-1]
//    差分数组对应的概念是前缀和数组，对于数组 [1,2,2,4][1,2,2,4]，
//    其差分数组为 [1,1,0,2][1,1,0,2]，差分数组的第 ii 个数即为原数组的第 i-1i−1 个元素和第 ii 个元素的差值，
//    也就是说我们对差分数组求前缀和即可得到原数组。
//    O(n+m)

    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] res = new int[n];
        if (bookings == null || bookings.length == 0) {
            return res;
        }
        for (int[] booking :  bookings) {
            res[booking[0]-1] += booking[2];
            if (booking[1] < n) {
                res[booking[1]] -= booking[2];// 第i+1个比第i个少booking[2]
            }
        }
        for (int i=1; i<res.length; i++) {
            res[i] += res[i-1];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)