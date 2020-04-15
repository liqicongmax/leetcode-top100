package xiaomi;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2020/4/15 15:03
 */
public class ShuzuBanyun {
    /**
     * {2，0，4，0，0，6，0，0}  把0 全部挪在后面其他数字挪到前面 ,并且保证非0数字的相对顺序不变
     * @param arr
     * @return
     */
    public int[] swapZeroToRight(int [] arr){
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[index]=arr[i];
                if(index!=i) {
                    arr[i] = 0;
                }
                index++;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(new ShuzuBanyun().swapZeroToRight(new int[]{2,0,4,0,0,6,0,0})));
    }
}
