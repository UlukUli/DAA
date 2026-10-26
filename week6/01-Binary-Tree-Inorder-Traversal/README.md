
# 94. Binary Tree Inorder Traversal

## 1. Problem

The task is to return the values of a binary tree's nodes in inorder order. Inorder means visiting the left subtree first, then the current node, and finally the right subtree.

## 2. Approach

I used a recursive Depth-First Search (DFS) approach.

The algorithm follows three steps:
1. If the current node is null, stop.
2. Traverse the left subtree.
3. Add the current node's value to the result, then traverse the right subtree.

The result list stores the values in the required order.

### Step-by-Step Trace

For the tree `[1, null, 2, 3]`:

```text
    1
     \
      2
     /
    3
```

1. Visit node `1`. Its left child is null.
2. Add `1` to the result: `[1]`.
3. Move to node `2`.
4. Visit its left child `3` and add it: `[1, 3]`.
5. Return to node `2` and add it: `[1, 3, 2]`.
6. Node `2` has no right child, so the traversal finishes.

Output: `[1, 3, 2]`

### Challenges and Testing

One challenge was understanding when to add a node's value. Adding the value before visiting the left subtree would produce preorder traversal instead of inorder traversal.

I tested the solution with:
- An empty tree: `[]` → `[]`
- A tree with one node: `[1]` → `[1]`
- A tree with a missing left child: `[1, null, 2, 3]` → `[1, 3, 2]`

These cases help check the recursion's stopping condition and traversal order.

## 3. Time Complexity

**Time Complexity: O(n)**

Here, `n` is the number of nodes in the tree. Each node is visited once, and processing each node takes constant time apart from the recursive calls. Therefore, the total time grows linearly with the number of nodes.

## 4. Space Complexity

**Space Complexity: O(n)** in the worst case.

The result list stores all `n` node values. The recursive call stack also uses space depending on the tree's height `h`, up to `O(n)` for a completely skewed tree. The auxiliary stack space alone is `O(h)`.

## 5. Reflection / Improvement

The recursive solution is simple and easy to understand. An iterative solution using an explicit stack can avoid relying on the language's recursion stack.

The iterative version still takes `O(n)` time and uses `O(h)` auxiliary stack space, in addition to the result list. It can be useful for very deep trees because it avoids recursive call-stack overflow.
