public class DeleteNode {
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

    public static Node insert(Node root, int val) {
        if(root ==  null){
            root = new Node(val);
            return root;
        }

        if(root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static Node buildBST(int val[]) {
        Node root = null;

        for(int i: val) {
            root = insert(root, i);
        }
        return root;
    }

    public static Node deleteNodeBST(Node root, int val) {
        if(root == null) return null;

        if(root.data > val) {
            root.left = deleteNodeBST(root.left, val);
        } else if(root.data < val) {
            root.right = deleteNodeBST(root.right, val);
        } else {
            if(root.left == null && root.right == null) {
                return null;
            }

            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNodeBST(root.right, IS.data);
        }
        return root;
    }

    public static Node inOrderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data +" ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        int val[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = buildBST(val);
        inOrder(root);
        System.out.println();
        Node next = deleteNodeBST(root, 5);
        inOrder(root);
    }   
}
