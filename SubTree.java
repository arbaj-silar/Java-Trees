public class SubTree {
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
            if(preorder[idx] == -1 || idx >= preorder.length) return null;

            Node root = new Node(preorder[idx]);
            root.left = buildTree(preorder);
            root.right = buildTree(preorder);

            return root;
        }
    }

    public static boolean isIdentical(Node root, Node subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        
        if(root.data == subRoot.data) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if(subRoot == null) return false;
        if(root == null) return false;

        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot)) return true;
        }

        return isSubtree(root.left, subRoot) || isIdentical(root.right, subRoot);
    }
    public static void main(String[] args) {
        int p[] = {1, 2, 3, -1, -1, 4, -1, -1, 5, -1, -1};
        int q[] = {2, 3, -1, -1, 4, -1, -1};

        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(p);
        Node subRoot = b.buildTree(q);

        System.out.println(isSubtree(root, subRoot));
    }
}
