//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4
// Related Topics 位运算 哈希表
// 👍 1778 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class L136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i : nums) {
            res ^= i;
        }
        return res;
    }
}
// 交换律：a ^ b ^ c <=> a ^ c ^ b

// 任何数于0异或为任何数 0 ^ n => n

// 相同的数异或为0: n ^ n => 0

// var a = [2,3,2,4,4]

// 2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
//leetcode submit region end(Prohibit modification and deletion)
