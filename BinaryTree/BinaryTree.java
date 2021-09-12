package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTree {
    int val;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int val) {
        this.val = val;
    }

    public BinaryTree(int val, BinaryTree left, BinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {
    public BinaryTree curr;
    public Deque<BinaryTree> stack;

    public BSTIterator(BinaryTree root){
        curr = root;
        stack = new LinkedList<BinaryTree>();

    }
    public int next(){
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        int curr_root_val = curr.val;
        curr = curr.right;
        return curr_root_val;
    }

    public boolean hasNext(){
        return !stack.isEmpty()||curr!=null;
    }
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(7, new BinaryTree(3,new BinaryTree(1,null,null),new BinaryTree(4,null,null)), new BinaryTree(15, new BinaryTree(9,null,null), new BinaryTree(20,null,null)));
        BSTIterator bstIterator = new BSTIterator(root);
        //System.out.println(bstIterator.next());
        //System.out.println(bstIterator.hasNext());

    }
}

class isSubtree{
    public boolean isSubtree(BinaryTree root, BinaryTree subroot){
        if(root == null){
            return false;
        }
        return check(root,subroot)|| isSubtree(root.left,subroot) || isSubtree(root.right,subroot);
    }
    private boolean check(BinaryTree root, BinaryTree subroot){
        if(root == null && subroot == null){
            return true;
        }
        if(root == null || subroot == null || root.val != subroot.val){
            return false;
        }
        return check(root.left,subroot.left)&&check(root.right,subroot.right);
    }


    public static void main(String[] args){
        BinaryTree root = new BinaryTree(3,new BinaryTree(4,new BinaryTree(1,null,null),new BinaryTree(2,null,null)),new BinaryTree(5,null,null));
        BinaryTree subroot = new BinaryTree(4,new BinaryTree(1,null,null),new BinaryTree(2,null,null));
        isSubtree issubtree = new isSubtree();
        boolean ans = issubtree.isSubtree(root,subroot);
        System.out.println(ans);
    }
}
