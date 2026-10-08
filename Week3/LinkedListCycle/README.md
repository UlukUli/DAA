# Linked List Cycle

## 1. Problem

The task is to determine whether a linked list contains a cycle.

Normally, we can start at the head and follow the `next` pointer until we reach `null`.

For example:

```text
1 → 2 → 3 → null
```

does not contain a cycle.

But a list can also look like this:

```text
1 → 2 → 3
    ↑     ↓
    ← ← ←
```

In this case, following the `next` pointers will eventually bring us back to a node that we have already visited.

The goal is to return:

```text
true
```

if a cycle exists, and:

```text
false
```

otherwise.

---

## 2. Approach

For my solution, I use a `HashSet` called `visited`.

The idea is simple: while moving through the linked list, I store every node that I have already visited.

For every current node:

1. Check whether the node is already in `visited`.
2. If it is already there, a cycle exists, so return `true`.
3. If it is not there, add it to the set.
4. Move to the next node.

If I eventually reach `null`, it means that the list ends normally and there is no cycle.

An important detail is that I store the actual `ListNode` objects, not just their values.

For example:

```text
5 → 7 → 5
```

The value `5` alone is not enough to detect a cycle because two different nodes can have the same value.

We need to know whether we have reached the exact same node again.

---

## 3. Tracing the Algorithm

Consider:

```text
head = 3 → 2 → 0 → -4
          ↑         |
          |_________|
```

The last node points back to the node containing `2`.

### Step 1

Current node:

```text
3
```

`3` is not in `visited`.

Add it:

```text
visited = {3}
```

Move to the next node.

---

### Step 2

Current node:

```text
2
```

`2` is not in `visited`.

Add it:

```text
visited = {3, 2}
```

Move to the next node.

---

### Step 3

Current node:

```text
0
```

`0` is not in `visited`.

Add it:

```text
visited = {3, 2, 0}
```

Move to the next node.

---

### Step 4

Current node:

```text
-4
```

`-4` is not in `visited`.

Add it:

```text
visited = {3, 2, 0, -4}
```

Move to the next node.

The next node is the node containing `2`.

---

### Step 5

Current node:

```text
2
```

Now `2` is already inside `visited`.

Therefore, we know that we have reached the same node again.

So we return:

```text
true
```

This means the linked list contains a cycle.

---

### Example without a cycle

Consider:

```text
1 → 2 → 3 → null
```

We visit:

```text
1
2
3
```

Then:

```text
current == null
```

No node was visited twice, so the method returns:

```text
false
```

---

## 4. Time Complexity

**Time Complexity: O(n)**

Where `n` is the number of nodes that we visit.

In the worst case, we visit every node once before either finding a repeated node or reaching `null`.

The `HashSet` allows us to check whether a node has already been visited in approximately constant time on average.

Therefore, the overall time complexity is:

```text
O(n)
```

### Space Complexity

**Space Complexity: O(n)**

In the worst case, the linked list does not contain a cycle.

Then we have to store every node in the `HashSet`:

```text
visited = {node1, node2, node3, ..., noden}
```

Therefore, the amount of additional memory can grow with the number of nodes.

So the space complexity is:

```text
O(n)
```

---

## 5. Reflection / Improvement

Yes, this solution can be improved in terms of space complexity.

The main disadvantage is that the `HashSet` stores every visited node.

A more efficient approach is Floyd's Cycle Detection Algorithm, also called the "slow and fast pointer" method.

It uses two pointers:

* `slow` moves one node at a time.
* `fast` moves two nodes at a time.

If there is no cycle, `fast` eventually reaches `null`.

If there is a cycle, the fast pointer will eventually catch up with the slow pointer.

The improved complexity would be:

```text
Time Complexity: O(n)
Space Complexity: O(1)
```

The time complexity does not improve because we still need to potentially visit the nodes.

The important improvement is the memory usage:

```text
HashSet approach:       O(n) space
Slow/Fast approach:     O(1) space
```

I chose the `HashSet` solution for my initial implementation because the idea is straightforward: remember the nodes that have already been visited. After understanding this solution, the slow/fast pointer method is a natural improvement because it removes the need to store all visited nodes.

