public class CountNode {
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

        public static int count(Node root) {
            if(root == null) return 0;

            return count(root.left)+count(root.right)+1;
        }
        
        public static int sumOfNode(Node root) {
            if(root == null) return 0;

            return sumOfNode(root.left)+sumOfNode(root.right)+root.data;
        }
        public static int heightOfTree(Node root) {
            if(root == null) return 0;

            return Math.max(heightOfTree(root.left), heightOfTree(root.right)) +1;
        }
    }

    public static void main(String[] args) {
        int preorder[] = {1, 2, 5, -1, -1, 4, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(preorder);
        System.out.println("Number of Node : "+b.count(root));
        System.out.println("Sum of Node : "+b.sumOfNode(root));
        System.out.println("Height of Tree : "+b.heightOfTree(root));
    }
}
