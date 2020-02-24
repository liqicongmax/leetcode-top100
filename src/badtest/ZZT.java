package badtest;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/21 14:51
 */
public class ZZT {
    public static String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        String reverse=new StringBuilder(s).reverse().toString();
        int max=0;
        String str="";
        int len=s.length();
        int[][] dp=new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(s.charAt(i)==reverse.charAt(j)){
                    if(i>0&&j>0){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]=1;
                    }
                    if(dp[i][j]>max){
                        if(len-i+dp[i][j]-2==j){
                            max=dp[i][j];
                            str=s.substring(j-max+1,j+1);
                        }
                    }
                }
            }
        }
        return str;
    }
}
