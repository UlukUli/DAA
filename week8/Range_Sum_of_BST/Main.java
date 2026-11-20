public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }

        // If the current value is smaller than low,
        // we only need to search the right subtree.
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // If the current value is larger than high,
        // we only need to search the left subtree.
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // The current value is inside the required range.
        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {

        /*
                  10
                 /  \
                5    15
               / \     \
              3   7     18
        */

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.right = new TreeNode(18);

        int low = 7;
        int high = 15;

        System.out.println("=== Task 938 ===");
        System.out.println("Range Sum of BST");
        System.out.println();

        System.out.println("Low: " + low);
        System.out.println("High: " + high);

        int result = rangeSumBST(root, low, high);

        System.out.println(
                "Sum of values in range [" +
                low + ", " + high + "]: " + result
        );
    }
}
