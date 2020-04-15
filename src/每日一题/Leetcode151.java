package 每日一题;

/**
 * @author liqicong@myhexin.com
 * @date 2020/4/10 15:13
 */
public class Leetcode151 {
    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     *
     *  
     *
     * 示例 1：
     *
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     * 示例 2：
     *
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     *
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *  
     *
     * 说明：
     *
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if(s.length()==0){
            return s;
        }
        int len=s.length();
        StringBuilder sb=new StringBuilder();
        int pre=len-1;
        int last=len;
        for( pre=len-1;pre>=0;pre--){
            //遍历字符，如果pre从空格到有字符，就把last赋值为pre+1
            if(pre+1<len&&s.charAt(pre+1)==' '&&s.charAt(pre)!=' '){
                last=pre+1;
                if(pre==0){
                    sb.append(s.substring(pre,last));
                    sb.append(" ");
                }
                continue;
            }
            //如果pre走到的不为空，就继续往前
            if(s.charAt(pre)!=' '){
                if(pre==0){
                    sb.append(s.substring(pre,last));
                    sb.append(" ");
                }
//                pre--;
                continue;
            }
            //如果pre从有字符走到了空,截取字符串
            if(pre+1<len&&s.charAt(pre)==' '&&s.charAt(pre+1)!=' '){
                sb.append(s.substring(pre+1,last));
                sb.append(" ");
            }

        }
        if(sb.length()>0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(new Leetcode151().reverseWords(" "));
    }
}
