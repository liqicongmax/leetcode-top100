package badtest;

import java.util.ArrayList;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/20 10:58
 */
public class OOM {

    public static void main(String[] args){
        ArrayList<Integer> list=new ArrayList<>(10);
        System.out.println(list.size());
        int[] arr=new int[10];
        System.out.println(arr.length);
    }

}
