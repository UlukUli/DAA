
# 10. Merge Two Binary Trees

**LeetCode Problem:** [617. Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/)

## Problem

Given the roots of two binary trees, merge them into a single binary tree.

If two nodes overlap, their values are added together. If a node exists in only one tree, it is used in the merged tree.

Return the root of the merged tree.

## Approach

I use a recursive Depth-First Search (DFS) approach.

1. If the first node is `null`, return the corresponding node from the second tree.
2. If the second node is `null`, return the corresponding node from the first tree.
3. If both nodes exist, add the value of the second node to the first node.
4. Recursively merge the left children.
5. Recursively merge the right children.
6. Return the first node as the root of the merged tree.

The solution reuses nodes instead of creating a completely new tree.

## Step-by-Step Trace

Input:

```text
Tree 1:             Tree 2:

    1                   2
   / \                 / \
  3   2               1   3
 /                     \   \
5                       4   7
```

1. Merge the roots: `1 + 2 = 3`.
2. Merge the left children: `3 + 1 = 4`.
3. Merge the right children: `2 + 3 = 5`.
4. The left child `5` has no overlapping node, so it remains `5`.
5. The node `4` exists only in the second tree, so it is included.
6. The node `7` exists only in the second tree, so it is included.

Output:

```text
       3
      / \
     4   5
    / \   \
   5   4   7
```

## Challenges and Testing

The main challenge is handling nodes that exist in only one tree. Returning the non-null node prevents null pointer errors and preserves the remaining subtree.

Test cases:

- Two overlapping trees: `[1,3,2,5]` and `[2,1,3,null,4,null,7]` → `[3,4,5,5,4,null,7]`
- Single-node trees `[1]` and `[1]` → `[2]`
- First tree is `null` → return the second tree
- Second tree is `null` → return the first tree

These tests check overlapping nodes, non-overlapping branches, and null inputs.

## Time Complexity

**O(min(n, m))**, where `n` and `m` are the numbers of nodes in the two trees.

The algorithm recursively merges positions where both trees contain a node. If one node is `null`, it returns the other subtree immediately without traversing that subtree.

## Space Complexity

**O(h)** auxiliary space, where `h` is the maximum depth of the active recursive calls while merging overlapping nodes.

In the worst case, the recursion stack can grow linearly with the number of nodes in the smaller tree, giving **O(min(n, m))** worst-case auxiliary space.

## Reflection and Possible Improvements

The recursive solution is concise and efficient. It takes advantage of the fact that a subtree can be reused when the corresponding node in the other tree is missing.

One possible alternative is to create a completely new tree instead of modifying the first tree. That approach preserves both original trees, but requires additional memory for the newly created nodes.
