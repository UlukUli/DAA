# 108. Convert Sorted Array to Binary Search Tree

## 1. Problem

We are given an integer array `nums` sorted in strictly increasing order.

The task is to convert this array into a Binary Search Tree (BST) that is height-balanced.

A height-balanced tree is a tree where the heights of the left and right subtrees are kept as close as possible.

For example:

```text id="l0r7fp"
nums = [-10, -3, 0, 5, 9]
```

One valid result is:

```text id="g7x0nq"
        0
       / \
     -3   9
     /   /
   -10  5
```

The array is already sorted, so we can use this order to construct the BST.

---

## 2. Approach

I use the middle element of each part of the array as the root of the corresponding subtree.

The reason is that the middle element divides the array into two approximately equal parts.

The left part contains values smaller than the root, so it becomes the left subtree.

The right part contains values greater than the root, so it becomes the right subtree.

This also helps keep the resulting tree balanced.

### Algorithm

1. Start with the entire array.
2. Find the middle index.
3. Create a tree node using the middle element.
4. Recursively build the left subtree using the elements before the middle.
5. Recursively build the right subtree using the elements after the middle.
6. Continue until the left index becomes greater than the right index.
7. Return the root of the constructed tree.

The middle index is calculated as:

```text id="2kzq4m"
mid = left + (right - left) / 2
```

This is a safe way to calculate the middle position without directly adding `left + right`.

---

## Tracing Example 1

Input:

```text id="d0m56w"
nums = [-10, -3, 0, 5, 9]
```

Initial range:

```text id="u4k2m1"
left = 0
right = 4
```

Calculate middle:

```text id="q6z0ps"
mid = 0 + (4 - 0) / 2
mid = 2
```

The middle value is:

```text id="9az6ut"
nums[2] = 0
```

So `0` becomes the root.

```text id="1p5g1v"
        0
```

---

### Build the left subtree

The left part is:

```text id="u9tqjv"
[-10, -3]
```

Indexes:

```text id="b6g7yr"
left = 0
right = 1
```

Middle:

```text id="6ib4fk"
mid = 0
```

Value:

```text id="b2d5pn"
-10
```

So `-10` becomes the left child of `0`.

```text id="e0g5na"
        0
       /
    -10
```

Now the remaining value `-3` becomes part of the right subtree of `-10`.

The tree becomes:

```text id="0xj6qn"
        0
       /
     -10
        \
        -3
```

---

### Build the right subtree

The right part of the original array is:

```text id="u9o0x1"
[5, 9]
```

The middle value is `5`.

So `5` becomes the left child of `9` in this recursive construction:

```text id="6m1f0k"
        0
       / \
     -10  5
       \   \
       -3   9
```

This is a valid BST, although LeetCode can accept different balanced BST structures depending on which middle element is selected.

A possible accepted output is:

```text id="9f0b9z"
[0,-3,9,-10,null,5]
```

Another valid balanced BST can also be produced.

The important thing is that the result is a valid BST and is height-balanced.

---

## Tracing Example 2

Input:

```text id="4k2j8p"
nums = [1, 3]
```

Initial range:

```text id="t9q3vm"
left = 0
right = 1
```

Middle:

```text id="r8y2bc"
mid = 0
```

The value `1` becomes the root.

The remaining value `3` is placed in the right subtree.

Result:

```text id="q2n7ws"
    1
     \
      3
```

This is height-balanced because the difference between the heights of the left and right subtrees is at most 1.

Another accepted answer could use `3` as the root:

```text id="0k3v9s"
    3
   /
  1
```

Both structures satisfy the requirements.

---

## Why does choosing the middle work?

Suppose we have:

```text id="z1x8c3"
[1, 2, 3, 4, 5, 6, 7]
```

If we always choose the first element as the root, we would get:

```text id="m6r3ab"
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
           \
            7
```

This is not balanced.

Instead, choosing the middle:

```text id="j2s8kl"
        4
       / \
      2   6
     / \ / \
    1  3 5  7
```

creates two nearly equal subtrees.

Therefore, selecting the middle element at every recursive step is a natural way to construct a height-balanced BST.

---

## Challenges

One simple approach would be to insert every array element into a BST one by one.

For example:

```text id="r6z2fd"
insert 1
insert 2
insert 3
insert 4
...
```

However, because the array is already sorted, inserting the elements in their original order can produce a very unbalanced tree.

For example:

```text id="7h4m1a"
[1, 2, 3, 4, 5]
```

could produce:

```text id="7t9x2k"
1
 \
  2
   \
    3
     \
      4
       \
        5
```

This does not satisfy the requirement for a height-balanced BST.

Another idea is to sort the array before constructing the tree. However, the array is already sorted, so sorting it again is unnecessary and would increase the amount of work.

The key observation is that the array is already sorted. Therefore, we can directly use its middle element as the root and recursively process the two halves.

---

## 3. Time Complexity

### Time Complexity: O(n)

Every element of the input array is used exactly once to create a tree node.

For example, if there are `n` elements:

```text id="q1p7vm"
n = 5
```

we create exactly 5 tree nodes.

The recursive calls divide the array into smaller parts, but every element is eventually processed.

Therefore:

```text id="j5z0rp"
Time Complexity: O(n)
```

---

## Space Complexity

### Space Complexity: O(n)

There are two reasons to consider the space used.

First, the resulting BST itself contains `n` nodes:

```text id="4z7p2s"
O(n)
```

The recursion stack has a depth equal to the height of the resulting balanced tree.

Because the tree is balanced:

```text id="c1x8vf"
O(log n)
```

additional stack space is used.

Therefore, if we count the output tree, the total space is:

```text id="d8y3km"
O(n)
```

The auxiliary space used by the recursive calls, excluding the output tree, is:

```text id="s4n6pq"
O(log n)
```

---

## 4. Reflection / Improvement

The solution already has optimal time complexity for this problem.

We need to create `n` nodes in the resulting tree, so we cannot do better than:

```text id="7v2m1a"
O(n)
```

because every input element must be represented in the BST.

A possible improvement would be to construct the tree iteratively instead of recursively.

However, this would not improve the asymptotic time complexity. The solution would still require:

```text id="p8q3xy"
O(n)
```

time.

The recursive solution is shorter and clearly shows how the array is divided into smaller sections.

### Final Complexity

```text id="w5c1nz"
Time Complexity: O(n)
Auxiliary Space: O(log n)
Total Space including the output tree: O(n)
```
