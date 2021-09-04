////给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
////
//// 请返回所有可行解 s 中最长长度。
////
////
////
//// 示例 1：
////
//// 输入：arr = ["un","iq","ue"]
////输出：4
////解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
////
////
//// 示例 2：
////
//// 输入：arr = ["cha","r","act","ers"]
////输出：6
////解释：可能的解答有 "chaers" 和 "acters"。
////
////
//// 示例 3：
////
//// 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
////输出：26
////
////
////
////
//// 提示：
////
////
//// 1 <= arr.length <= 16
//// 1 <= arr[i].length <= 26
//// arr[i] 中只含有小写英文字母
////
//// Related Topics 位运算 回溯算法
//// 👍 120 👎 0
//
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Set;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class L1239 {
//    int max = 0;
//    public int maxLength(List<String> arr) {
//        if (arr == null || arr.size() == 0) {
//            return 0;
//        }
//
//        //
//    }
//
//    private void backtrack(List<String> arr, String cur, int idx, Set<Character> set) {
//        if (max == 26) return;
//        if (idx == arr.size()) return;
//        if (set.size() == 26) return;
//
//        for (int i = idx; i < arr.size(); i++) {
//            char[] cc = arr.get(idx).toCharArray();
//            for (char c: cc) {
//                boolean noDuplicateChar = true;
//                if (set.contains(c)) {
//                    noDuplicateChar = false;
//                    break;
//                }
//                if (noDuplicateChar) {
//                    max += (cur+arr.get(idx)).length();
//                    for (char ch: cc) {
//                        set.add(ch);
//                    }
//                    backtrack(arr, cur+ arr.get(i),idx+1, set);
//                }
//            }
//
//        }
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
