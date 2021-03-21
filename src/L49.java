//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
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
// Related Topics 哈希表 字符串
// 👍 688 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class L49 {
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        // sorted string as key, added str to matched key list
        if(strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            List list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        // 使用质数代表每个字母， 则乘积相同的字符串即为同组
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        Map<Long, List<String>> map = new HashMap<>();

        for (String s : strs) {
            long key = 1;
            char[] cs = s.toCharArray();
            for (char c : cs ) {
                key *= primes[c - 'a'];
            }
            List list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }

}
//leetcode submit region end(Prohibit modification and deletion)
