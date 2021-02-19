//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 1462 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class L14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1) {
            return "";

        }
        // find shortest string
        String cur = null;
        int len = Integer.MAX_VALUE;
        for(String s:strs) {
            if(s.length() < len) {
                cur = s;
                len = s.length();
            }
        }

        // check if every string has cur as prefix
        // if not, subtract cur till cur is prefix, then go on checking next string
        for(int i=0; i<strs.length; i++) {
            if(strs[i].indexOf(cur) != 0) {
                for(int j=0; j<cur.length(); j++){
                    if(strs[i].charAt(j) != cur.charAt(j)){
                        cur = cur.substring(0,j);
                        break;
                    }
                }
            }
        }
       return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
