package 每日一题;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/20 16:37
 */
public class Mianshiti40 {
    /**
     *输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     *
     *
     * 示例 1：
     *
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * 示例 2：
     *
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     *
     *
     * 限制：
     *
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0){
            return arr;
        }
//        maxHeapSort(arr);
        int[] res=new int[k];
        if(k==0){
            return res;
        }
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        maxHeapSort(res);
        for(int i=k;i<arr.length;i++){
            if(arr[i]<res[0]){
                res[0]=arr[i];
                maxHeapSort(res);
            }
        }
        return res;
    }

    private void maxAdjust(int[] arr, int parentIndex, int length) {
        int temp = arr[parentIndex];
        int childrenIndex = parentIndex * 2 + 1;
        while (childrenIndex < length) {
            if (childrenIndex + 1 < length && arr[childrenIndex + 1] > arr[childrenIndex]) {
                childrenIndex++;
            }
            if (temp >= arr[childrenIndex]) {
                break;
            }
            arr[parentIndex]=arr[childrenIndex];
            parentIndex=childrenIndex;//下一轮循环现在的子节点就是下一轮的头结点
            childrenIndex=childrenIndex*2+1;
        }
        arr[parentIndex]=temp;
    }

    public void maxHeapSort(int[] arr){
        for(int i=(arr.length-2)/2;i>=0;i--){//构建二叉堆,实际上还是数组形式,构造成根节点和必然大于他们的叶节点的形式
            maxAdjust(arr,i,arr.length);
        }
//        for(int i=arr.length-1;i>=0;i--){
//            int temp=arr[0];
//            arr[0]=arr[i];
//            arr[i]=temp;
//            maxAdjust(arr,0,i);//0位置上的根节点必然是当前堆中最大的值,所以放到末尾,然后对数组长度-1的数组进行重新构建堆,生成一个新的大顶堆,继续下一轮的排序
//        }
    }
    public static void main(String[] args){
        int[] arr=new int[]{0,0,1,2,4,2,2,3,1,4};
        int[] res=new Mianshiti40().getLeastNumbers(arr,8);
        System.out.println(Arrays.toString(res));

    }
}
