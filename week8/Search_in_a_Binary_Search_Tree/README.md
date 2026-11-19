# 700. Search in a Binary Search Tree

## 1. Problem

We are given a Binary Search Tree (BST) and an integer `val`.

The goal is to find the node whose value is equal to `val`. If the node is found, we return the subtree starting from this node. If the value does not exist in the tree, we return `null`.

For example, for the tree:

```text
        4
       / \
      2   7
     / \
    1   3
```

If `val = 2`, we return the subtree:

```text
      2
     / \
    1   3
```

If `val = 5`, there is no such node, so we return `null`.

---

## 2. Approach

I used an iterative search.

The important property of a Binary Search Tree is:

- values smaller than the current node are located in the left subtree;
- values larger than the current node are located in the right subtree;
- if the current value equals the target, we have found the required node.

I start from the root and compare its value with `val`.

### Algorithm

1. Start with `current = root`.
2. While `current` is not `null`:
   - If `current.val == val`, return `current`.
   - If `val < current.val`, move to the left child.
   - If `val > current.val`, move to the right child.
3. If we reach `null`, the required value does not exist, so return `null`.

### Tracing Example 1

Input:

```text
root = [4,2,7,1,3]
val = 2
```

Tree:

```text
        4
       / \
      2   7
     / \
    1   3
```

Iteration 1:

```text
current = 4
val = 2

2 < 4
```

The target is smaller than `4`, so we move left.

```text
current = 2
```

Iteration 2:

```text
current = 2
val = 2

2 == 2
```

The value is found.

We return the node `2`, together with its subtree:

```text
      2
     / \
    1   3
```

Output:

```text
[2,1,3]
```

### Tracing Example 2

Input:

```text
root = [4,2,7,1,3]
val = 5
```

Start at `4`:

```text
5 > 4
```

Move right:

```text
current = 7
```

Now:

```text
5 < 7
```

Move left:

```text
current = null
```

There is no node with value `5`.

Therefore:

```text
return null
```

Output:

```text
[]
```

---

## Challenges

One possible approach is to traverse every node of the tree using a normal DFS or BFS.

For example, we could check the root, then its children, and continue until we find the target.

However, this approach does not use the main advantage of a Binary Search Tree. We do not need to visit both sides of the tree.

For example, when the current node is `4` and the target is `2`, we immediately know that the target can only be in the left subtree. The entire right subtree can be ignored.

I initially considered a full traversal because it is straightforward, but using the BST property makes the search more efficient.

The iterative solution is also simple because it does not require recursive function calls.

---

## 3. Time Complexity

### Time Complexity: O(h)

Here `h` is the height of the binary search tree.

At every step, we move to only one child: either left or right. We do not visit both subtrees.

In the worst case, we may have to travel from the root to the deepest node, which takes `h` steps.

For a balanced BST:

```text
h ≈ log(n)
```

so the complexity is:

```text
O(log n)
```

For a highly unbalanced BST:

```text
h ≈ n
```

so the worst-case complexity becomes:

```text
O(n)
```

Therefore, the general complexity is:

```text
O(h)
```

---

## Space Complexity

### Space Complexity: O(1)

The algorithm uses only one additional variable:

```text
current
```

We do not create arrays, lists, or other structures.

Therefore, the additional space complexity is:

```text
O(1)
```

---

## 4. Reflection / Improvement

The solution already uses the important property of a Binary Search Tree, so it is more efficient than checking every node.

For a balanced BST, the search takes:

```text
O(log n)
```

which is very efficient.

A recursive implementation is also possible. It would have the same time complexity, `O(h)`, but it would use additional stack space.

The iterative solution is preferable here because it achieves:

```text
Time:  O(h)
Space: O(1)
```

For a balanced tree this becomes:

```text
Time:  O(log n)
Space: O(1)
```
