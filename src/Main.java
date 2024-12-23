import trees.Node;
import trees.Traversals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter values separated by spaces and use 'x' to specify an empty child:");
        System.out.println("E.g. 5 4 3 x x 8 x x 6 x x");
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        //Node<String> root = buildTree(splitWords(scanner.nextLine()).iterator(), Function.identity());
        scanner.close();
        // You can now use the root node for traversal or other operations
        var integerTraversals = new Traversals<Integer>();
        //var stringTraversals = new Traversals<String>();
        System.out.println("Preorder, inorder, and postorder traversals:");
        integerTraversals.preorderTraversal(root);
        System.out.println();
        integerTraversals.inorderTraversal(root);
        System.out.println();
        integerTraversals.postorderTraversal(root);
        System.out.println();
        System.out.println("PERFORM DFS");
        if (root != null) {
            Node<Integer> result = root.dfs(root, 3);
            System.out.println(result == null ? "Value was not found" : result);
        }

    }

    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }
}