public class TreeDiameter {
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
    }

    static class TreeInfo {
        int ht;
        int diam;
        public TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter(Node root) {
        if(root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);

        int myHeight = Math.max(left.ht, right.ht)+1;

        int d1 = left.diam;
        int d2 = right.diam;
        int d3 = left.ht + right.ht +1;

        int myDiam = Math.max(Math.max(d2, d1), d3)+1;
        TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
        return myInfo;
    }
    public static void main(String[] args) {
        int preorder[] = {1, 2, 3, -1, -1, 4, -1, -1, 5, -1, -1};

        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(preorder);

        System.out.println(diameter(root).diam);
    }
}
