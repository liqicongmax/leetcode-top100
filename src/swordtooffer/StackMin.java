package swordtooffer;

import java.util.Stack;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/10 15:59
 */
public class StackMin {
    /**
     * 题目描述
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
     * @param node
     * ....玄学
     */
    Stack<Integer> source=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    public void push(int node) {
        source.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }else{
            int min=minStack.peek();
            min=Math.min(min,node);
            minStack.push(min);
        }
    }

    public void pop() {
        if(!source.isEmpty()){
            source.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(!source.isEmpty()) {
            return source.peek();
        }
        return -1;
    }

    public int min() {
        if(!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }
}
