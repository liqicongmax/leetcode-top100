package 每日一题;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/19 10:04
 */
public class Leetcode409 {
    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     *
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     *
     * 注意:
     * 假设字符串的长度不会超过 1010。
     *
     * 示例 1:
     *
     * 输入:
     * "abccccdd"
     *
     * 输出:
     * 7
     *
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        //偶数个的字符，出现次数直接加上去，奇数个的字符加的时候都得减去1凑到偶数个，最后判断下如果全是偶数个的字符就直接返回了，有奇数个的字符，那得补个中间点。
        //偶数个的字符为0，且奇数个的字符都等于1，
        if(s.length()<2){
            return s.length();
        }
        int[] arr=new int[52];
        int total=0;
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            if(temp<='Z'){
                arr[temp-'A']+=1;
            }else{
                arr[temp-'a'+26]+=1;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                total+=arr[i];
            }else{
                total+=arr[i]-1;
            }
        }
        return total<s.length()?total+1:total;
    }
}
