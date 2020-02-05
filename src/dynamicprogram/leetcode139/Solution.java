package dynamicprogram.leetcode139;

import java.util.List;

/**
 * @Author liqicong
 * @Date 2020/2/5 18:31
 * @Description
 */
public class Solution {
    /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     *
     * 说明：
     *
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     *
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     * 示例 2：
     *
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     *      注意你可以重复使用字典中的单词。
     * 示例 3：
     *
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     *
     * 链接：https://leetcode-cn.com/problems/word-break
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        boolean[] res=new boolean[len+1];
        res[0]=true;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(res[j]&&wordDict.contains(s.substring(j,i))){
                    res[i]=true;
                    break;
                }
            }
        }
        return res[len];
    }
}
