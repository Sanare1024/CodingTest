package Graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk1991 {

    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char value, left, right;


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            value = st.nextToken().charAt(0);
            left = st.nextToken().charAt(0);
            right = st.nextToken().charAt(0);

            insert(value, left, right);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    private static void insert(char value, char left, char right) {
        if (root == null) {
            root = new Node(value);

            if(left != '.'){
                root.left = new Node(left);
            }
            if(right != '.'){
                root.right = new Node(right);
            }
        }

        searchNode(root, value, left, right);
    }

    public static void searchNode(Node node, char value, char left, char right){
        if(node == null){
            return;
        }
        if (node.value == value){
            if(left != '.'){
                node.left = new Node(left);
            }
            if (right != '.'){
                node.right = new Node(right);
            }
        }
        searchNode(node.left, value, left, right);
        searchNode(node.right, value, left, right);
    }

    //전위 순회 root -> left -> right
    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    //중위 순회 left -> root -> right
    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }
    //후위 순회 left -> right -> root
    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
        }
    }
}
