package huaweijishi;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/24 19:52
 */
public class EliminateDuplicateNumbers {
    /**
     * 华为机试：消除重复数字以后的最大整数
     * 示例： 输入：423234  输出：432
     * 423
     *
     * @param num
     * @return
     */
    public int solution(int num) {
        if (num < 10) {
            return num;
        }
        char[] ints = String.valueOf(num).toCharArray();
        String word = "";
        //滑动窗口的做法，先从长度1开始
        for (int i = 0; i < ints.length; i++) {
            if ("".equals(word)) {
                word += ints[i];
            } else if (word.contains(String.valueOf(ints[i]))) {
                //如果窗口里遇到了和当前ints[i]有相同的数字，就进行比较，哪个大留哪个
                //那么留到最后的就是最大的，直接返回即可
                int now = Integer.valueOf(word);
                int index = word.indexOf(ints[i]);
                String nowWord=index != word.length() - 1 ?
                        word.substring(0, index) + word.substring(index + 1) + ints[i] :
                        word.substring(0, index) + ints[i];
                int newNum = Integer.valueOf(nowWord);
                if(newNum>now){
                    word=nowWord;
                }
            }else {
                word+=ints[i];
            }

        }
        return Integer.valueOf(word);
    }
    public static void main(String[] args){
        System.out.println(new EliminateDuplicateNumbers().solution(1441));
    }
}
