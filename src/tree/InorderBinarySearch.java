package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/4 15:44
 */
public class InorderBinarySearch {
    public List<Integer> inorderSearch(TreeNode root){
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            if(!stack.isEmpty()){
                root=stack.pop();
                list.add(root.val);
                root=root.right;
            }
        }
        return list;
    }
}
