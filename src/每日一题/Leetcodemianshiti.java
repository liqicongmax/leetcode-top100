package 每日一题;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/3 9:37
 */
public class Leetcodemianshiti {
    /**
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     * <p>
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * A = [1,2,3,0,0,0], m = 3
     * B = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     * <p>
     * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int k=m+n-1;
        int i=m-1;
        int j=n-1;
        while(i>=0&&j>=0){
            if(A[i]<B[j]){
                A[k--]=B[j--];
            }else{
                A[k--]=A[i--];
            }
        }
        //如果i用完了j没用完，说明剩下的B都是小的，直接放到A前面就行
        //如果i没用完j用完了，不需要处理了，前面的A都是已排序好的
        while(j>=0){
            A[k--]=B[j--];
        }
        System.out.println(Arrays.toString(A));
    }



    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{2, 5, 6};
        new Leetcodemianshiti().merge(A, 3, B, 3);
    }
}
