import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //输入: s = "abcabcbb"
 * //输出: 3
 * //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //输入: s = "bbbbb"
 * //输出: 1
 * //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * //
 * //
 * // 示例 3:
 * //
 * //
 * //输入: s = "pwwkew"
 * //输出: 3
 * //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * //
 * //
 * // 示例 4:
 * //
 * //
 * //输入: s = ""
 * //输出: 0
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 0 <= s.length <= 5 * 104
 * // s 由英文字母、数字、符号和空格组成
 * //
 * // Related Topics 哈希表 双指针 字符串 Sliding Window
 * // 👍 4964 👎 0
 */
public class L3 {
    public int lengthOfLongestSubstring(String s) {
        // 哈希表 双指针 字符串 Sliding Window
        if(s == null || s.length() == 0) return 0;

        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int res = 0;
        int l = 0, r = 0;
        while(r < arr.length) {
            // 出现重复，left右移，直到没有与right没有重复
            while(r < arr.length && set.contains(arr[r])){
                set.remove(arr[l++]);
            }

            // left -> right无重复，right向右前进，同时更新res
            while(r < arr.length && !set.contains(arr[r])) {
                res = Math.max(res, r - l + 1);
                set.add(arr[r++]);
            }
        }
        return res;
    }
}
