package badtest;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/29 11:16
 */
public class Main1 {
    public static void main(String[] args){
        PeopleStaticProxy psp=new PeopleStaticProxy(new People());
        psp.eatBreakFastThenWork();
    }
}
