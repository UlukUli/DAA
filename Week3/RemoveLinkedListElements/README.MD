# Remove Linked List Elements

## 1. Problem

The task is to remove every node from a linked list whose value is equal to the given `val`.

For example:

```text
Input:

1 → 2 → 6 → 3 → 4 → 5 → 6

val = 6
```

The result should be:

```text
1 → 2 → 3 → 4 → 5
```

All nodes with value `6` have to be removed.

The method should return the new head of the linked list.

---

## 2. Approach

I use a temporary `dummy` node before the original head.

The structure initially looks like:

```text
dummy → head → ...
```

I use a pointer called `current`.

Instead of checking `current` itself, I check `current.next`.

If:

```text
current.next.val == val
```

then I remove that node by changing the pointer:

```text
current.next = current.next.next;
```

This skips the unwanted node.

If the next node does not contain the target value, I simply move `current` forward.

The dummy node is useful when the first node itself needs to be removed. Without a dummy node, I would need separate logic for changing the head.

---

## 3. Tracing the Algorithm

Consider:

```text
head = 1 → 2 → 6 → 3 → 4 → 5 → 6

val = 6
```

Initially:

```text
dummy → 1 → 2 → 6 → 3 → 4 → 5 → 6
        ↑
      current
```

### Iteration 1

Check:

```text
current.next = 1
```

Since:

```text
1 != 6
```

move `current` forward.

```text
dummy → 1 → 2 → 6 → 3 → 4 → 5 → 6
             ↑
           current
```

---

### Iteration 2

Check the next value:

```text
2
```

Since:

```text
2 != 6
```

move forward.

---

### Iteration 3

The next node contains:

```text
6
```

This node must be removed.

Before:

```text
2 → 6 → 3
```

We change the pointer to:

```text
2 → 3
```

The list becomes:

```text
1 → 2 → 3 → 4 → 5 → 6
```

Notice that `current` does not move after deleting a node.

This is important because there could be another unwanted node immediately after it.

---

### Continue

The last node also contains `6`.

We remove it:

```text
1 → 2 → 3 → 4 → 5
```

Now the next node after `current` is `null`, so the loop stops.

The result is:

```text
1 → 2 → 3 → 4 → 5
```

---

## 4. Time Complexity

**Time Complexity: O(n)**

Where `n` is the number of nodes in the linked list.

We move through the linked list from beginning to end.

Every node is checked at most once.

Therefore, the algorithm takes:

```text
O(n)
```

time.

---

## Space Complexity

**Space Complexity: O(1)**

I only use:

```text
dummy
current
```

No additional data structure grows with the size of the linked list.

Therefore:

```text
O(1)
```

additional space is used.

---

## 5. Reflection / Improvement

The solution is already efficient.

We need to inspect every node because any node could contain the value that needs to be removed.

Therefore, it is not possible to improve the general time complexity below:

```text
O(n)
```

The solution also uses constant additional memory:

```text
O(1)
```

So there is no significant asymptotic improvement necessary.

An alternative solution could handle the head separately without using a dummy node, but I think the dummy node makes the algorithm simpler and reduces special cases.
