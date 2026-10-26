
# 112. Path Sum

## 1. Problem

The task is to determine whether a binary tree contains a root-to-leaf path whose node values add up to a given target sum. A leaf is a node with no children.

## 2. Approach

I used a recursive Depth-First Search (DFS) approach.

The algorithm works as follows:
1. If the current node is null, return `false`.
2. If the current node is a leaf, compare its value with the remaining target sum.
3. Otherwise, subtract the current node's value from the remaining sum.
4. Recursively search the left and right subtrees. If either subtree contains a valid path, return `true`.

The algorithm only accepts a path that ends at a leaf.

### Step-by-Step Trace

For the example with `targetSum = 22`, consider the path `5 -> 4 -> 11 -> 2`:

```text
        5
       /
      4
     /
    11
   /  \
  7    2
```

1. Start at node `5`. The remaining sum becomes `22 - 5 = 17`.
2. Move to node `4`. The remaining sum becomes `17 - 4 = 13`.
3. Move to node `11`. The remaining sum becomes `13 - 11 = 2`.
4. Move to leaf node `2`. Its value matches the remaining sum.
5. The recursive call returns `true`, so a valid root-to-leaf path exists.

Output: `true`

### Challenges and Testing

One challenge was understanding why a matching sum must be checked at a leaf. A path that reaches an internal node is not enough, even if its sum matches the target.

I tested the solution with:
- An empty tree and target `0`: `false`
- A single node with value `1` and target `1`: `true`
- A single node with value `1` and target `2`: `false`
- The example path `5 -> 4 -> 11 -> 2` with target `22`: `true`
- A tree where no root-to-leaf path matches the target: `false`

These cases check empty trees, leaf validation, and successful or unsuccessful path searches.

## 3. Time Complexity

**Time Complexity: O(n)**

Here, `n` is the number of nodes in the tree. In the worst case, the algorithm may need to visit every node before determining whether a valid path exists. Each visited node requires constant additional work, so the worst-case running time is `O(n)`.

## 4. Space Complexity

**Auxiliary Space Complexity: O(h)**

The recursive call stack depends on the tree's height `h`. In the worst case, a completely skewed tree has height `n`, resulting in `O(n)` auxiliary space.

## 5. Reflection / Improvement

An iterative DFS using a stack could solve the same problem without recursive calls. Each stack entry could store a node and its remaining sum.

The iterative approach still has `O(n)` worst-case time complexity and up to `O(n)` auxiliary space. It may be useful for very deep trees because it avoids recursion stack overflow.
