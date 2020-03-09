package 每日一题;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/5 14:08
 */
public class Mianshiti1711 {
    /**
     * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
     * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
     *
     * 示例：
     *
     * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
     * 输出：1
     * 提示：
     *
     * words.length <= 100000
     *
     * 链接：https://leetcode-cn.com/problems/find-closest-lcci
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int findClosest(String[] words, String word1, String word2) {
        // 找到word1出现的数组下标存到数组a，找到word2出现的数组下标存到数组b，找下最短距离不就vans了
        // 初始化word1的index1=-1.word2的index2=-1，找到了新的index就给覆盖掉index，然后算当前两个最新的index的距离，小了就更新最小值
        return 0;
    }
}
