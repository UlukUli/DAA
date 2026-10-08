# Merge Two Sorted Lists

## 1. Problem

The task is to merge two sorted linked lists into one sorted linked list.

Both input lists are already sorted in non-decreasing order. We need to connect their existing nodes in the correct order and return the head of the new merged list.

For example:

```text
list1 = 1 → 2 → 4
list2 = 1 → 3 → 4
```

The result should be:

```text
1 → 1 → 2 → 3 → 4 → 4
```

I should not create a completely new list of values. Instead, I can connect the existing nodes from the two lists.

---

## 2. Approach

I use two pointers, one for each input list:

* `list1` points to the current node in the first list.
* `list2` points to the current node in the second list.
* `current` points to the last node of the merged list.

I also create a temporary `dummy` node. It makes it easier to build the result because I do not need to handle the first node separately.

At every iteration, I compare the values of `list1` and `list2`.

* If `list1.val <= list2.val`, I connect `list1` to the merged list and move `list1` forward.
* Otherwise, I connect `list2` and move `list2` forward.
* Then I move `current` to the newly added node.

The process continues while both lists still have nodes.

When one list becomes empty, all remaining nodes of the other list are already sorted. Therefore, I can connect the remaining part directly.

Finally, I return `dummy.next`, because `dummy` itself is only a helper node.

---

## 3. Tracing the Algorithm

Consider:

```text
list1 = 1 → 2 → 4
list2 = 1 → 3 → 4
```

Initially:

```text
list1 → 1
list2 → 1

merged:
dummy → 
```

### Iteration 1

Compare:

```text
1 <= 1
```

We take the node from `list1`.

```text
merged:
1
```

Now:

```text
list1 → 2
list2 → 1
```

---

### Iteration 2

Compare:

```text
2 > 1
```

We take the node from `list2`.

```text
merged:
1 → 1
```

Now:

```text
list1 → 2
list2 → 3
```

---

### Iteration 3

Compare:

```text
2 <= 3
```

We take `2` from `list1`.

```text
merged:
1 → 1 → 2
```

Now:

```text
list1 → 4
list2 → 3
```

---

### Iteration 4

Compare:

```text
4 > 3
```

We take `3` from `list2`.

```text
merged:
1 → 1 → 2 → 3
```

Now:

```text
list1 → 4
list2 → 4
```

---

### Iteration 5

Compare:

```text
4 <= 4
```

We take `4` from `list1`.

```text
merged:
1 → 1 → 2 → 3 → 4
```

Now `list1` is empty.

The remaining part of `list2` is:

```text
4
```

We connect it directly:

```text
1 → 1 → 2 → 3 → 4 → 4
```

This is the final answer.

---

## 4. Time Complexity

**Time Complexity: O(n + m)**

Where:

* `n` is the number of nodes in `list1`.
* `m` is the number of nodes in `list2`.

The algorithm moves through the nodes of both lists. Every node is processed at most once.

Therefore, in the worst case, we process:

```text
n + m
```

nodes.

So the time complexity is:

```text
O(n + m)
```

### Space Complexity

**Space Complexity: O(1)**

I only use a few pointers:

```text
dummy
current
list1
list2
```

I do not create new nodes for every element. The existing nodes are reused and connected together.

Therefore, the additional memory is constant:

```text
O(1)
```

---

## 5. Reflection / Improvement

The solution already has an efficient time complexity of `O(n + m)` because every node needs to be examined at least once.

There is not really a way to improve the asymptotic time complexity below `O(n + m)` for this problem because we need to process the nodes from both lists.

The solution also uses only `O(1)` additional memory, so there is no important space optimization needed.

One possible alternative is a recursive solution. It can look shorter, but recursion uses call-stack memory, so the iterative solution is better in terms of additional space.

Overall, I think the iterative two-pointer approach is a good solution because it is simple, efficient, and easy to trace.
