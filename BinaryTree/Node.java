package BinaryTree;

public class Node {
    int val;
    Node left;
    Node right;
    public Node(){}

    public Node(int val){
        this.val = val;
    }
    public Node(int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class NodeFunc{
    public Node nodeInsert(int val, Node l){
        Node newNode = new Node(val, null, null);
        Node head = l;
        if(l == null){
            head = new Node(val);
        }
        while(l != null){
            int curr_val = l.val;
            if(val > curr_val){
                if(l.right == null){
                    l.right = new Node(val);
                    break;
                }
                l = l.right;
            }
            else if(val < curr_val){
                if(l.left == null){
                    l.left = new Node(val);
                    break;
                }
                l = l.left;
            }
        }
        return head;
    }
    Node head;
    Node prev;
    public Node treeToDoublyList(Node root){
        if(root == null){
            return null;
        }
        inorder(root);
        head.left = prev;
        prev.right = head;
        return head;
    }
    private void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev == null){
            head = root;
        }
        else{
            prev.right = root;
        }
        root.left = prev;
        prev = root;
        inorder(root.right);
    }
    public static void main(String [] args){
        NodeFunc func = new NodeFunc();
        Node node  = new Node(8);
        node = func.nodeInsert(5,node);
        node = func.nodeInsert(9,node);
        node = func.nodeInsert(3,node);
        node = func.nodeInsert(4,node);
        node = func.nodeInsert(6,node);
        node = func.treeToDoublyList(node);
        for(int i = -1; i< 6; i++){
            System.out.print(node.val);
            node = node.right;
        }
    }
}
