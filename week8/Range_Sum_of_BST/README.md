# 938. Range Sum of BST

## 1. Problem

We are given a Binary Search Tree (BST) and two integers `low` and `high`.

The task is to calculate the sum of all node values that belong to the inclusive range:

```text
[low, high]
```

This means that both `low` and `high` are included.

For example:

```text
root = [10,5,15,3,7,null,18]
low = 7
high = 15
```

The values inside the range are:

```text
7, 10, 15
```

Therefore:

```text
7 + 10 + 15 = 32
```

---

## 2. Approach

I used a recursive DFS approach.

The main idea is to use the properties of a Binary Search Tree to avoid visiting branches that cannot contain valid values.

For every node, there are three possible situations.

### Case 1: Current value is smaller than `low`

```text
root.val < low
```

The current value is too small.

Because this is a BST, every value in the left subtree is even smaller.

Therefore, the entire left subtree can be ignored.

We only continue searching in the right subtree.

```text
return rangeSumBST(root.right, low, high);
```

---

### Case 2: Current value is larger than `high`

```text
root.val > high
```

The current value is too large.

Every value in the right subtree is even larger, so none of them can belong to the required range.

Therefore, we ignore the right subtree and continue with the left subtree.

```text
return rangeSumBST(root.left, low, high);
```

---

### Case 3: Current value is inside the range

If:

```text
low <= root.val <= high
```

the current value should be included in the sum.

However, there can also be valid values in both the left and right subtrees.

Therefore, we calculate:

```text
root.val
+ sum of left subtree
+ sum of right subtree
```

---

## Algorithm

1. If the current node is `null`, return `0`.
2. If the current value is smaller than `low`, search only the right subtree.
3. If the current value is larger than `high`, search only the left subtree.
4. Otherwise, add the current value and recursively search both subtrees.
5. Return the final sum.

---

## Tracing Example 1

Input:

```text
root = [10,5,15,3,7,null,18]
low = 7
high = 15
```

Tree:

```text
        10
       /  \
      5    15
     / \     \
    3   7     18
```

### Step 1

Current node:

```text
10
```

Check:

```text
7 <= 10 <= 15
```

So `10` belongs to the range.

Current sum:

```text
10
```

We must check both subtrees.

---

### Step 2

Move to the left:

```text
5
```

Check:

```text
5 < 7
```

The value `5` is too small.

Because this is a BST, everything in the left subtree of `5` is even smaller.

Therefore, we skip:

```text
3
```

and move directly to the right subtree.

```text
7
```

---

### Step 3

Current node:

```text
7
```

Check:

```text
7 <= 7 <= 15
```

So `7` belongs to the range.

Current sum becomes:

```text
10 + 7 = 17
```

---

### Step 4

Move back and check the right subtree of `10`:

```text
15
```

Check:

```text
7 <= 15 <= 15
```

So `15` belongs to the range.

Current sum:

```text
10 + 7 + 15 = 32
```

---

### Step 5

Check the right child of `15`:

```text
18
```

Since:

```text
18 > 15
```

the node is too large.

The entire right subtree of `18` can be ignored.

Final result:

```text
32
```

---

## Tracing Example 2

Input:

```text
root = [10,5,15,3,7,13,18,1,null,6]
low = 6
high = 10
```

Tree:

```text
          10
         /  \
        5    15
       / \   / \
      3   7 13 18
     /   /
    1   6
```

Start with `10`.

```text
6 <= 10 <= 10
```

Include `10`.

Sum:

```text
10
```

Go to `5`.

```text
5 < 6
```

The node is too small, so we skip its left subtree and move to `7`.

```text
7
```

Now:

```text
6 <= 7 <= 10
```

Include `7`.

Sum:

```text
10 + 7 = 17
```

Move to its left child:

```text
6
```

The value is inside the range:

```text
6 <= 6 <= 10
```

Include `6`.

Final sum:

```text
10 + 7 + 6 = 23
```

The nodes `5`, `3`, `1`, `15`, `13`, and `18` are not included.

Output:

```text
23
```

---

## Challenges

A simple solution would be to traverse every node in the tree and check whether its value is between `low` and `high`.

For example, we could use DFS:

```text
visit every node
if low <= node.val <= high:
    add node.val
```

This solution is correct, but it does not use the special structure of a BST.

The important improvement is that the BST tells us where valid values can exist.

For example, if:

```text
root.val = 5
low = 7
```

we already know that every value in the left subtree is less than `5`, so none of those nodes can be valid.

Similarly, if:

```text
root.val = 15
high = 10
```

all values in the right subtree are at least `15` or greater, so that entire branch can be ignored.

This makes the algorithm more efficient on many trees because unnecessary branches are not visited.

---

## 3. Time Complexity

### Time Complexity: O(n) in the worst case

Let `n` be the number of nodes that may need to be visited.

In the worst case, the range is large enough that almost every node has to be checked.

Therefore, the worst-case complexity is:

```text
O(n)
```

However, because we use the BST property to skip some branches, the actual number of visited nodes can be smaller than `n`.

For a balanced tree, the search can avoid many irrelevant branches, especially when the range is narrow.

---

## Space Complexity

### Space Complexity: O(h)

The solution is recursive, so each recursive call is stored on the call stack.

The maximum number of recursive calls depends on the height `h` of the tree.

For a balanced BST:

```text
h = O(log n)
```

Therefore:

```text
Space Complexity: O(log n)
```

For a highly unbalanced tree:

```text
h = O(n)
```

so the worst-case space complexity is:

```text
O(n)
```

Thus, the general space complexity is:

```text
O(h)
```

---

## 4. Reflection / Improvement

The solution already improves on a simple traversal because it uses the BST property to skip branches that cannot contain valid values.

A full DFS that visits every node would always take:

```text
O(n)
```

time.

The current solution can visit fewer nodes because it ignores unnecessary branches.

An iterative implementation could be used instead of recursion. This could reduce the additional stack space in some cases and avoid recursive calls.

For example, an iterative DFS could use an explicit stack.

The current recursive solution is simpler to understand and clearly demonstrates how the BST property can be used.

### Summary

```text
Time:  O(n) worst case
Space: O(h)
```

For a balanced tree, the recursion depth is approximately:

```text
O(log n)
```
