
# 144. Binary Tree Preorder Traversal

## 1. Problem

The task is to return the values of a binary tree's nodes in preorder order. Preorder means visiting the current node first, then the left subtree, and finally the right subtree.

## 2. Approach

I used recursive Depth-First Search (DFS).

The algorithm follows three steps:
1. If the current node is null, stop.
2. Add the current node's value to the result.
3. Recursively traverse the left subtree, followed by the right subtree.

### Step-by-Step Trace

For the tree `[1, null, 2, 3]`:

```text
1
 \
  2
 /
3
```

1. Visit node `1` and add it: `[1]`.
2. Its left child is null, so return.
3. Visit node `2` and add it: `[1, 2]`.
4. Visit the left child of `2`, which is node `3`: `[1, 2, 3]`.
5. No more nodes remain.

Output: `[1, 2, 3]`

### Challenges and Testing

One challenge was remembering to add the current node before visiting its children. If the value is added after the left subtree, the result follows a different traversal order.

I tested the solution with:
- An empty tree: `[]` → `[]`
- A single node: `[1]` → `[1]`
- A root with a right child: `[1, null, 2, 3]` → `[1, 2, 3]`
- A tree with both left and right subtrees: `[1, 2, 3]` → `[1, 2, 3]`

## 3. Time Complexity

**Time Complexity: O(n)**

Each of the `n` nodes is visited once, and the work performed at each node is constant. Therefore, the total running time is linear.

## 4. Space Complexity

**Auxiliary Space Complexity: O(h)**

The recursive call stack uses space proportional to the tree height `h`. In the worst case, a skewed tree has height `n`, so auxiliary space is `O(n)`.

The result list itself stores all `n` values and therefore requires `O(n)` space.

## 5. Reflection / Improvement

An iterative preorder traversal can use an explicit stack instead of recursion. Push the root first, then repeatedly visit a node and push its right child before its left child. This order ensures that the left child is processed first.

The iterative approach still takes `O(n)` time and up to `O(n)` auxiliary space, but it avoids recursive call-stack overflow.
