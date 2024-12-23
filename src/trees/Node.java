package trees;

public class Node<T> {
    public T val;
    public Node<T> left;
    public Node<T> right;

    public Node(T val) {
        this(val, null, null);
    }

    public Node(T val, Node<T> left, Node<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node<T> dfs(Node<T> root, T val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        Node<T> left = dfs(root.left, val);
        if (left != null) {
            return left;
        }
        return dfs(root.right, val); // Return right node regardless if it is null or not
    }

}
