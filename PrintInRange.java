public class PrintInRange {
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

    public static void printRange(Node root, int x, int y) {
        if(root == null) return;

        if(root.data >= x && root.data <= y) {
            printRange(root.left, x, y);
            System.out.print(root.data+" ");
            printRange(root.right, x, y);
        } else if(root.data >= y) {
            printRange(root.left, x, y);
        }else {
            printRange(root.right, x, y);
        }
    }
    public static void main(String[] args) {
        int val[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = buildBST(val);
        
        printRange(root, 3, 8);
    } 
}
