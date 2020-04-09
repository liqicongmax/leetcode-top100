package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/17 10:18
 */
public class leetcode1160 {
    /**
     * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
     * <p>
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
     * <p>
     * 注意：每次拼写时，chars 中的每个字母都只能用一次。
     * <p>
     * 返回词汇表 words 中你掌握的所有单词的 长度之和。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
     * 输出：6
     * 解释：
     * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
     * 示例 2：
     * <p>
     * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
     * 输出：10
     * 解释：
     * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= words.length <= 1000
     * 1 <= words[i].length, chars.length <= 100
     * 所有字符串中都仅包含小写英文字母
     * <p>
     * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
     *
     * @param words
     * @param chars
     * @return 先统计chars里面每个单词的次数，arr int[26],然后遍历每个单词，再遍历一个单词的字符，也建一个int[26]
     */
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] charAppear = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charAppear[chars.charAt(i) - 'a'] += 1;
        }
        int[] hash = new int[26];
        next:
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Arrays.fill(hash, 0);
            for (int j = 0; j < word.length(); j++) {
                hash[word.charAt(j) - 'a'] += 1;
                if (hash[word.charAt(j) - 'a'] > charAppear[word.charAt(j) - 'a']) {
                    continue next;
                }
            }
            res += word.length();
        }

        return res;
    }

    public static void main(String[] args) {

    }

}
