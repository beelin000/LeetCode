import java.util.HashMap;
import java.util.Map;

class L167 {
    public int[] twoSum1(int[] nums, int target) {
        if(nums == null || nums.length < 2) return new int[2];

        // Ascending Array! 2 pointers
        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum < target){
                left++;
            }
            else if(sum > target) {
                right--;
            }
            else {
                // sum == target
                // index of  result array start from 1
                return new int[]{left+1, right+1};
            }
        }
        return new int[2];
    }

    public int[] twoSum2(int[] nums, int target) {
        if(nums == null || nums.length < 2) return new int[2];

        // Ascending Array! remember seen numbers using Map<value, index>.
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            // if target-nums[i] seen, get that seen number's index
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i])+1, i+1};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}