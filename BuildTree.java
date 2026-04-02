public class BuildTree {
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

        public static void preOrderTraversal(Node root) {
            if(root == null) return;

            System.out.print(root.data+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        public static void inOrder(Node root) {
            if(root == null) return;

            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        } 

        public static void postOrder(Node root) {
            if(root == null) return;

            inOrder(root.left);
            inOrder(root.right);
            System.out.print(root.data+" ");
        } 
        
    }

    public static void main(String[] args) {
        int preorder[] = {1, 2, 5, -1, -1, 4, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(preorder);

        b.preOrderTraversal(root);
        System.out.println();
        b.inOrder(root);
        System.out.println();
        b.postOrder(root);
    } 
}
