public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildTree(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        // Choose the middle element as the root.
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        // Build the left subtree.
        root.left = buildTree(nums, left, mid - 1);

        // Build the right subtree.
        root.right = buildTree(nums, mid + 1, right);

        return root;
    }

    public static void printTree(TreeNode root, String prefix, boolean isLeft) {

        if (root == null) {
            return;
        }

        System.out.println(
                prefix +
                (isLeft ? "├── " : "└── ") +
                root.val
        );

        if (root.left != null) {
            printTree(
                    root.left,
                    prefix + (isLeft ? "│   " : "    "),
                    true
            );
        }

        if (root.right != null) {
            printTree(
                    root.right,
                    prefix + (isLeft ? "│   " : "    "),
                    false
            );
        }
    }

    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};

        System.out.println("=== Task 108 ===");
        System.out.println("Convert Sorted Array to Binary Search Tree");
        System.out.println();

        System.out.print("Sorted array: ");

        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();
        System.out.println();

        TreeNode root = sortedArrayToBST(nums);

        System.out.println("Height-balanced BST:");

        System.out.println(root.val);

        if (root.left != null) {
            printTree(root.left, "", true);
        }

        if (root.right != null) {
            printTree(root.right, "", false);
        }
    }
}
