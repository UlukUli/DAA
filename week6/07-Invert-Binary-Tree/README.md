
# 226. Invert Binary Tree

## 1. Problem

The task is to invert a binary tree by swapping the left and right children of every node. The method must return the root of the inverted tree.

## 2. Approach

I used a recursive Depth-First Search (DFS) approach.

The algorithm works as follows:
1. If the current node is null, return null.
2. Store the left child in a temporary variable.
3. Assign the right child to the left pointer and the saved child to the right pointer.
4. Recursively invert the new left and right subtrees.
5. Return the current root.

### Step-by-Step Trace

For the input `[4, 2, 7, 1, 3, 6, 9]`:

```text
Before:               After:

      4                    4
     / \                  / \
    2   7                7   2
   / \ / \              / \ / \
  1  3 6  9             9  6 3  1
```

1. At node `4`, swap children `2` and `7`.
2. Process node `7`. Swap its children `6` and `9`.
3. Its children are leaves, so their recursive calls stop.
4. Process node `2`. Swap its children `1` and `3`.
5. The remaining children are leaves, so the recursion finishes.

Output: `[4, 7, 2, 9, 6, 3, 1]`

### Challenges and Testing

One challenge was remembering to swap the children before recursively processing the subtrees. The recursive calls then work on the updated left and right children.

I tested the solution with:
- An empty tree: `[]` → `[]`
- A single node: `[1]` → `[1]`
- A tree with two children: `[2, 1, 3]` → `[2, 3, 1]`
- A larger tree: `[4, 2, 7, 1, 3, 6, 9]` → `[4, 7, 2, 9, 6, 3, 1]`

## 3. Time Complexity

**Time Complexity: O(n)**

Each node is visited once, and swapping its children requires constant time. Therefore, the total running time is proportional to the number of nodes.

## 4. Space Complexity

**Auxiliary Space Complexity: O(h)**

The recursive call stack uses space proportional to the tree height `h`. In the worst case, a skewed tree has height `n`, so the auxiliary space complexity is `O(n)`.

The algorithm modifies the existing tree and does not create a separate tree of nodes.

## 5. Reflection / Improvement

An iterative approach using a queue or stack could invert the tree without recursion. It would swap each node's children and then process its children.

The iterative approach has `O(n)` time complexity and up to `O(n)` auxiliary space. Its main advantage is avoiding recursive call-stack overflow for very deep trees.
