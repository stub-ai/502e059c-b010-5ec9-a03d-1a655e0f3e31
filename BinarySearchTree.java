public class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    Node predecessor(Node root, int key) {
        Node node = search(root, key);
        if (node == null)
            return null;
        if (node.left != null)
            return maximum(node.left);
        Node y = node.parent;
        while (y != null && node == y.left) {
            node = y;
            y = y.parent;
        }
        return y;
    }

    Node search(Node root, int key) {
        if (root == null || root.key == key)
            return root;
        if (root.key > key)
            return search(root.left, key);
        return search(root.right, key);
    }

    Node maximum(Node node) {
        while (node.right != null)
            node = node.right;
        return node;
    }
}