
# 145. Binary Tree Postorder Traversal

## 1. Problem

The task is to return the values of a binary tree's nodes in postorder order. Postorder means visiting the left subtree first, then the right subtree, and finally the current node.

## 2. Approach

I used recursive Depth-First Search (DFS).

The algorithm follows these steps:
1. If the current node is null, stop.
2. Recursively traverse the left subtree.
3. Recursively traverse the right subtree.
4. Add the current node's value to the result.

Unlike preorder traversal, the current node is added only after both subtrees have been processed.

### Step-by-Step Trace

For the tree `[1, null, 2, 3]`:

```text
1
 \
  2
 /
3
```

1. Start at node `1`. Do not add it yet.
2. Move to node `2` through the right subtree.
3. Visit node `3`, its left child, and add it: `[3]`.
4. Return to node `2` and add it: `[3, 2]`.
5. Return to node `1` and add it last: `[3, 2, 1]`.

Output: `[3, 2, 1]`

### Challenges and Testing

One challenge was understanding why the current node must be added after both recursive calls. Adding it before the children would produce a different traversal order.

I tested the solution with:
- An empty tree: `[]` → `[]`
- A single node: `[1]` → `[1]`
- A root with a right child: `[1, null, 2, 3]` → `[3, 2, 1]`
- A tree with a left and a right child: `[1, 2, 3]` → `[2, 3, 1]`

These cases help verify that children are processed before their parent.

## 3. Time Complexity

**Time Complexity: O(n)**

The algorithm visits each of the `n` nodes exactly once. The work at each node is constant apart from the recursive calls, so the total time complexity is `O(n)`.

## 4. Space Complexity

**Auxiliary Space Complexity: O(h)**

The recursive call stack depends on the tree height `h`. In the worst case, a skewed tree has height `n`, resulting in `O(n)` auxiliary space.

The result list requires another `O(n)` space to store the node values.

## 5. Reflection / Improvement

An iterative postorder traversal can use an explicit stack. One possible approach is to process nodes in root-right-left order and then reverse the collected result to obtain left-right-root order.

This approach takes `O(n)` time and `O(n)` auxiliary space. It avoids recursive calls but requires additional stack and result-management logic.
