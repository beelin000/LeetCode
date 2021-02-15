/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 *
 * 注意：
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * 来源：力扣（LeetCode）
 */
public class L485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int res = 0;

        // sliding window
        for(int l=0; l<nums.length; l++){
            if(nums[l] == 0) continue;
            else{
                int count = 0;
                int r = l;
                while(r < nums.length && nums[r] == 1) {
                    r++;
                    count++;
                }
                res = Math.max(res, count);
                l = r;
            }
        }
        return res;
    }

    public static void main(String[] args){
//        int[] arr = new int[]{1,1,0,1,1,1,0,0,1,0,1,1};
        int[] arr = new int[]{0};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
