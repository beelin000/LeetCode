//给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
//
// 注意：
//数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
//
// 示例:
//
//
//int[] nums = new int[] {1,2,3,3,3};
//Solution solution = new Solution(nums);
//
//// pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
//solution.pick(3);
//
//// pick(1) 应该返回 0。因为只有nums[0]等于1。
//solution.pick(1);
//
// Related Topics 蓄水池抽样
// 👍 107 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class L398 {
    Random random = new Random();
    Map<Integer, List<Integer>> map;

    public L398(int[] nums) {
        map = new HashMap<>();

        for (int i=0; i< nums.length; i++) {
            if (map.get(nums[i]) == null) {
                List<Integer> list = new ArrayList();
                list.add(i);
                map.put(nums[i], list);
            }
            else {
                map.get(nums[i]).add(i);
            }
        }
    }

    public int pick(int target) {
        if (map.get(target) == null) {
            return -1;
        }
        List indexes = map.get(target);
        int range = indexes.size();
        return (int) indexes.get(random.nextInt(range));
    }
}

// 蓄水池采样法
//class Solution {
//对第i个元素，以1/i的概率更新取值，以1 - 1/i的概率保留原值,则n个元素最终留下的概率都是1/n
//int[]nums;
//    public Solution(int[] nums) {
//        this.nums=nums;
//    }
//
//    public int pick(int target) {
//        Random r=new Random();
//        int count=0;//等于target的元素数目
//        int res=0;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]==target){
//                count++;
//                if(r.nextInt(count)==0) res=i;//在1-count之间选择数字，最终所有的元素都以1/n留下（这里蓄水池的容量为1）
//            }
//        }
//        return res;
//    }
//}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)
