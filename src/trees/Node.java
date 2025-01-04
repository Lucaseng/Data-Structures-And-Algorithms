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

    public int maxTreeDepth(Node<Integer> root) {
        if (root == null) {
            return 0;
        } else {
            return maxTreeDepthDfs(root) - 1;
        }
    }

    public int maxTreeDepthDfs(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        var left = maxTreeDepthDfs(root.left);
        var right = maxTreeDepthDfs(root.right);
        return Math.max(left, right) + 1;
    }


    public int visibleTreeNode(Node<Integer> root) {
        return visibleTreeNodeDfs(root, Integer.MIN_VALUE);
    }

    public int visibleTreeNodeDfs(Node<Integer> root, int currentMax) {
        if (root == null) {
            return 0;
        }
        var total = 0;
        if (root.val >= currentMax) {
            total += 1;
        }
        total += visibleTreeNodeDfs(root.left, Math.max(currentMax, root.val));
        total += visibleTreeNodeDfs(root.right, Math.max(currentMax, root.val));
        return total;
    }
}
