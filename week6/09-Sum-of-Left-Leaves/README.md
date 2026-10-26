
# 09. Sum of Left Leaves

**LeetCode Problem:** [404. Sum of Left Leaves](https://leetcode.com/problems/sum-of-left-leaves/)

## Problem

Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

## Approach

I use a recursive Depth-First Search (DFS) approach.

1. If the current node is `null`, return `0`.
2. Check whether the current node has a left child.
3. If the left child has no children, add its value to the sum.
4. Otherwise, recursively calculate the sum of left leaves in the left subtree.
5. Recursively calculate the sum of left leaves in the right subtree.
6. Return the total sum.

It is important to count only leaves that are left children, not every leaf in the tree.

## Step-by-Step Trace

Example input:

```text
       3
      / \
     9   20
        /  \
       15   7
```

1. Start at node `3`.
2. Node `9` is a left leaf, so add `9`.
3. Visit node `20`.
4. Node `15` is a left leaf, so add `15`.
5. Node `7` is a right leaf, so do not add it.
6. Return the total: `9 + 15 = 24`.

Output: `24`

## Challenges and Testing

The main challenge is distinguishing left leaves from right leaves and from left children that have their own children.

Test cases:

- Standard tree `[3,9,20,null,null,15,7]` → `24`
- Single node `[1]` → `0`
- Tree `[1,2]` → `2`
- Tree `[1,null,2]` → `0`

These tests check both left and right leaves and the case where no left leaf exists.

## Time Complexity

**O(n)**, where `n` is the number of nodes in the tree.

In the worst case, the algorithm visits every node once to determine whether it is a left leaf.

## Space Complexity

**O(h)** auxiliary space, where `h` is the height of the tree, due to the recursive call stack.

In the worst case, a skewed tree has height `n`, so the space complexity becomes **O(n)**. For a balanced tree, it is **O(log n)**.

## Reflection and Possible Improvements

The recursive solution is simple and easy to understand. An iterative DFS using a stack could also solve the problem in O(n) time.

The main lesson is that a leaf's position matters: only leaves that are left children contribute to the sum.
