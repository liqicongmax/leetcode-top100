package 回溯.leetcode17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/2 14:18
 */
public class Solution {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     * <p>
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     *
     * @param digits
     * @return
     */
    public static HashMap<String, String> keyBoard = new HashMap<>();

    static {
        keyBoard.put("2", "abc");
        keyBoard.put("3", "def");
        keyBoard.put("4", "ghi");
        keyBoard.put("5", "jkl");
        keyBoard.put("6", "mno");
        keyBoard.put("7", "pqrs");
        keyBoard.put("8", "tuv");
        keyBoard.put("9", "wxyz");
    }

    //给23，得出xx，xx，xx，xx
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        helper(res, digits, 0, new StringBuilder());
        return res;
    }

    public void helper(List<String> res, String digits, int index, StringBuilder sb) {
        if (sb.toString().length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        //顺序是指定的，第一个只能是从digits第一个数字开始
        String word = keyBoard.get(String.valueOf(digits.charAt(index)));
        //确定当前初始word,第一个词只能在word里面选
        for (int i = 0; i < word.length(); i++) {
            StringBuilder temp = new StringBuilder(sb);
            temp.append(word.charAt(i));
            helper(res, digits, index+1, temp);
            temp.deleteCharAt(index);
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().letterCombinations("234").toArray()));
    }
}