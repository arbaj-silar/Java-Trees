import java.util.ArrayList;

public class LeafPaths {
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

    public static void printAllpaths(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i)+"->");
        }
        System.out.println("null");
    }

    public static void printPaths(Node root, ArrayList<Integer> path) {
        if(root == null) return;

        path.add(root.data);
        if(root.left == null && root.right == null) {
            printAllpaths(path);
        } else {
            printPaths(root.left, path);
            printPaths(root.right, path);
        }
        path.remove(path.size()-1);
    }
    
    public static void main(String[] args) {
        int val[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = buildBST(val);

        printPaths(root, new ArrayList<>());
    }
}
