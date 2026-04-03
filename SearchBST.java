public class SearchBST {
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

    public static boolean search(Node root, int val) {
        if(root == null) return false;
        if(root.data == val) return true;

        if(root.data > val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }
    public static void main(String[] args) {
        int val[] = {5, 1, 3, 4, 2, 7};
        Node root = buildBST(val);
        System.out.println(search(root, 1));
    }
}
