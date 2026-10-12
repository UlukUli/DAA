# Remove Duplicates from Sorted List

## 1. Problem

The task is to remove duplicate values from a sorted linked list so that every value appears only once.

For example:

```text
1 → 1 → 2
```

should become:

```text
1 → 2
```

Another example:

```text
1 → 1 → 2 → 3 → 3
```

should become:

```text
1 → 2 → 3
```

The list is already sorted, which makes it easier to find duplicates because equal values are next to each other.

---

## 2. Approach

I use one pointer called `current`.

I compare the current node with the next node.

If:

```text
current.val == current.next.val
```

then the next node is a duplicate.

I remove it by changing the pointer:

```text
current.next = current.next.next;
```

This skips the duplicate node.

If the values are different, I move `current` to the next node.

An important detail is that when I remove a duplicate, I do **not** move `current` immediately.

For example:

```text
1 → 1 → 1 → 2
↑
current
```

After removing the first duplicate:

```text
1 → 1 → 2
↑
current
```

There can still be another duplicate after the current node, so I need to check it again.

---

## 3. Tracing the Algorithm

Consider:

```text
head = 1 → 1 → 2 → 3 → 3
```

Initially:

```text
current
   ↓
1 → 1 → 2 → 3 → 3
```

### Iteration 1

Compare:

```text
current.val = 1
current.next.val = 1
```

They are equal.

So we remove the second `1`.

Before:

```text
1 → 1 → 2 → 3 → 3
```

After:

```text
1 → 2 → 3 → 3
```

`current` stays on the first `1`.

---

### Iteration 2

Now compare:

```text
1 and 2
```

They are different.

So we move `current`:

```text
1 → 2 → 3 → 3
    ↑
  current
```

---

### Iteration 3

Compare:

```text
2 and 3
```

They are different.

Move forward:

```text
1 → 2 → 3 → 3
         ↑
       current
```

---

### Iteration 4

Compare:

```text
3 and 3
```

They are equal.

Remove the second `3`:

```text
1 → 2 → 3
```

Now:

```text
current.next == null
```

The loop stops.

The final result is:

```text
1 → 2 → 3
```

---

## 4. Time Complexity

**Time Complexity: O(n)**

Where `n` is the number of nodes in the linked list.

The algorithm moves through the list from beginning to end.

Every node is examined at most a constant number of times.

Even when a node is removed, the pointer operation takes constant time.

Therefore, the total time complexity is:

```text
O(n)
```

---

## Space Complexity

**Space Complexity: O(1)**

The algorithm only uses one pointer:

```text
current
```

It does not create an additional array, set, or another linked list.

The existing nodes are reused and the links are changed directly.

Therefore, the additional space complexity is:

```text
O(1)
```

---

## 5. Reflection / Improvement

The solution is already efficient in both time and space.

Because the list is sorted, duplicates are next to each other. Therefore, we only need to make one pass through the list.

The time complexity is:

```text
O(n)
```

and the additional space is:

```text
O(1)
```

There is no meaningful asymptotic improvement needed.

A less efficient approach would be to store all values in a `HashSet` and use it to detect duplicates. That would also take `O(n)` time, but it would require `O(n)` additional memory.

The sorted property of the linked list allows us to avoid that extra memory.
