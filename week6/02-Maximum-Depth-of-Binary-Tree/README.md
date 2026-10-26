
# 104. Maximum Depth of Binary Tree

## 1. Problem

The task is to find the maximum depth of a binary tree. The maximum depth is the number of nodes on the longest path from the root to a leaf.

## 2. Approach

I used a recursive Depth-First Search (DFS) approach.

The algorithm works as follows:
1. If the current node is null, return `0`.
2. Recursively calculate the depth of the left subtree.
3. Recursively calculate the depth of the right subtree.
4. Return `1 + max(leftDepth, rightDepth)`. The extra `1` counts the current node.

This approach compares both subtrees and chooses the deeper one.

### Step-by-Step Trace

For the tree `[3, 9, 20, null, null, 15, 7]`:

```text
       3
      / \
     9   20
        /  \
       15   7
```

1. Nodes `9`, `15`, and `7` are leaves. Each has depth `1`.
2. Node `20` has two children with depth `1`, so its depth is `1 + max(1, 1) = 2`.
3. At node `3`, the left subtree has depth `1` and the right subtree has depth `2`.
4. The final depth is `1 + max(1, 2) = 3`.

Output: `3`

### Challenges and Testing

One challenge was understanding why the algorithm uses the maximum of the two subtree depths rather than adding them together. The maximum depth describes one longest path, not the total number of nodes in both subtrees.

I tested the solution with:
- An empty tree: `[]` → `0`
- A tree with one node: `[1]` → `1`
- A tree with two levels: `[1, null, 2]` → `2`
- A tree with three levels: `[3, 9, 20, null, null, 15, 7]` → `3`

These cases check the base condition and whether the algorithm correctly selects the deeper subtree.

## 3. Time Complexity

**Time Complexity: O(n)**

Here, `n` is the number of nodes. The algorithm visits every node once and performs a constant amount of work at each node. Therefore, the running time grows linearly with the number of nodes.

## 4. Space Complexity

**Auxiliary Space Complexity: O(h)**

The recursive call stack depends on the tree's height `h`. For a balanced tree, the height is approximately `O(log n)`. For a completely skewed tree, the height can be `O(n)`.

The algorithm does not need an additional list to store the nodes.

## 5. Reflection / Improvement

The recursive solution is concise and easy to understand. An iterative solution using a queue and level-order traversal could calculate the maximum depth without recursive calls.

The iterative approach would still take `O(n)` time and use up to `O(n)` auxiliary space for the queue. Its main advantage is avoiding potential recursion stack overflow for very deep trees.
