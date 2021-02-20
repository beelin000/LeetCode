//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2164 👎 0

import java.util.Stack;

public class L20 {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        // loop string
        for(char c:s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case ')':
                    if(stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if(stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if(stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
            }
        }
        return stack.isEmpty();
    }
}
