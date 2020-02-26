package huaweijishi.huaweimianshi;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/26 19:40
 */
public class OneToN {
    /**
     * 不用乘除法求1+。。+n的总和,也不能for循环while，switch，case
     * @param n
     * @return
     * 显然只能递归了
     */
    int result=0;
    int count=0;
    public int solution(int n){
        if(n==0){
            return 0;
        }
        int result=n;
        boolean f=n>0&&(result+=solution(n-1))>0;
        return result;
    }
}
