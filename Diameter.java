public class Diameter {
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

        public static int height(Node root) {
            if(root == null) return 0;
            return Math.max(height(root.left), height(root.right))+1;
        }

        public static int diameterOfTree(Node root) {
            if(root == null) return 0;
            return Math.max((height(root.left)+height(root.right)+1),
                 Math.max(diameterOfTree(root.left), diameterOfTree(root.right)));
        }

    }

    public static void main(String[] args) {
        int preorder[] = {1, -1, 2, 2, 3, 4, -1, -1, -1, 3, -1, -1, 7, 4, -1, -1, 5, -1, -1};

        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(preorder);
        System.out.println(b.height(root));
        System.out.println(b.diameterOfTree(root));
    } 
}
