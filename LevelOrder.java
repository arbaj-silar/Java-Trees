import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        
        public static Node buildTree(int preorder[]) {
            idx++;
            if(preorder[idx] == -1) return null;

            Node root = new Node(preorder[idx]);
            root.left = buildTree(preorder);
            root.right = buildTree(preorder);

            return root;
        }

        public static void levelOrder(Node root) {
            if(root == null) return;

            Queue<Node> q = new LinkedList<>();

            q.add(root);
            q.add(null);
            while(!q.isEmpty()) {
                Node curr = q.remove();

                if(curr == null) {
                    System.out.println();
                    if(q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data+" ");
                    if(curr.left != null) {
                        q.add(curr.left);
                    }
                    if(curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int preorder[] = {1, 2, 5, -1, -1, 4, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(preorder);

        b.levelOrder(root);
    }
}
