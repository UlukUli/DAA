public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;

        while (current != null) {

            if (current.val == val) {
                return current;
            }

            if (val < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {

        /*
                 4
                / \
               2   7
              / \
             1   3
        */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 2;

        System.out.println("=== Task 700 ===");
        System.out.println("Search in a Binary Search Tree");
        System.out.println();

        System.out.println("Target value: " + val);

        TreeNode result = searchBST(root, val);

        if (result != null) {
            System.out.println("Node found!");
            System.out.print("Subtree: ");
            printTree(result);
            System.out.println();
        } else {
            System.out.println("Node not found.");
        }
    }
}
