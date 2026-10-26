
# 111. Minimum Depth of Binary Tree

## 1. Problem

The task is to find the minimum depth of a binary tree. The minimum depth is the number of nodes on the shortest path from the root to a leaf. A leaf is a node with no children.

## 2. Approach

I used recursion to calculate the minimum depth.

The algorithm follows these rules:
1. If the current node is null, return `0`.
2. If the left child is null, continue through the right subtree.
3. If the right child is null, continue through the left subtree.
4. If both children exist, calculate both depths and return `1 + min(leftDepth, rightDepth)`.

The special cases are important because an empty subtree cannot be treated as a path to a leaf.

### Step-by-Step Trace

For the tree `[2, null, 3, null, 4, null, 5, null, 6]`:

```text
2
 \
  3
   \
    4
     \
      5
       \
        6
```

1. Node `6` is a leaf, so its depth is `1`.
2. Node `5` has no left child. Its minimum depth is `1 + 1 = 2`.
3. Node `4` has minimum depth `1 + 2 = 3`.
4. Node `3` has minimum depth `1 + 3 = 4`.
5. Node `2` has minimum depth `1 + 4 = 5`.

Output: `5`

### Challenges and Testing

The main challenge was handling nodes with only one child. Taking the minimum of both subtree depths without special conditions could incorrectly return `1` for a tree that has only a long right-side path.

I tested the solution with:
- An empty tree: `[]` → `0`
- A single node: `[1]` → `1`
- A tree with a left leaf: `[3, 9, 20, null, null, 15, 7]` → `2`
- A one-sided tree: `[2, null, 3, null, 4, null, 5, null, 6]` → `5`

## 3. Time Complexity

**Time Complexity: O(n)**

Each node is visited at most once. The algorithm performs a constant amount of work at each visited node, so the total time is proportional to the number of nodes.

## 4. Space Complexity

**Auxiliary Space Complexity: O(h)**

The recursive call stack depends on the tree height `h`. In the worst case, a completely skewed tree has height `n`, so the auxiliary space complexity is `O(n)`.

## 5. Reflection / Improvement

An iterative breadth-first search (BFS) using a queue could find the first leaf level and return its depth immediately. This can avoid visiting nodes below the nearest leaf level.

The worst-case time complexity remains `O(n)`, and the queue may require `O(n)` space. BFS can be especially useful when a shallow leaf is found early.
