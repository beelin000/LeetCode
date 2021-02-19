//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 深度优先搜索 递归 字符串 回溯算法
// 👍 1125 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 手机字母组合
 */
class L17 {
    public List<String> letterCombinations(String digits) {
        List res = new ArrayList<String>();
        if(digits == null || digits.length() < 1) {
            return res;
        }

        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        // backtrack
        backtrack(res, map, digits, 0, new StringBuffer());
        return res;
    }

    private static void backtrack(List<String> res, Map<Character, String> map, String digits, int idx, StringBuffer sb) {
        if(digits.length() == idx) {
            // combination reaches expected length
            // add it to result
            res.add(sb.toString());
        } else {
            // combination not reaches expected length
            // loop on to next letter
            String letters = map.get(digits.charAt(idx));
            for(int i=0; i<letters.length(); i++) {
                // backtrack to try every possible combinations
                sb.append(letters.charAt(i));
                backtrack(res, map, digits, idx+1, sb);

                // remove the letter at the end of current combination
                // so that it can loop on to try next mapped letter
                sb.deleteCharAt(idx);
            }
        }
    }
}
