//编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
//
// 注意：本题相对原题稍作修改
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串 排序
// 👍 64 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class M10_02 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = genStringKey(s);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());
    }

    private String genStringKey(String s) {
        int[] map = new int[26];
        // count strings' letters
        for (int i=0; i<s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i:map) {
            sb.append(i);
        }
        return sb.toString();
    }

    private boolean compareStr(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) return false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];
        // count strings' letters
        for (int i=0; i<len1; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        // compare letter count
        for (int i=0; i<26; i++) {
            if (map1[i] != map2[i]) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
