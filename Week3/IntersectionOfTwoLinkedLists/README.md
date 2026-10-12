# Intersection of Two Linked Lists

## 1. Problem

The task is to find the node where two singly linked lists start sharing the same nodes.

For example:

```text
List A:

4 → 1 → 8 → 4 → 5
          ↑
          |
List B:   5 → 6 → 1
```

The two lists intersect at the node containing `8`.

The important point is that an intersection means the lists contain the **same node object**, not simply nodes with equal values.

For example, two different nodes can both contain the value `1`. That does not mean that the lists intersect.

If there is no common node, the method should return `null`.

---

## 2. Approach

I use a `HashSet` to store all nodes from the first linked list.

First, I traverse `listA` and put every node into the set.

Then I traverse `listB`.

For every node in `listB`, I check whether this exact node is already inside the set.

* If it is in the set, this is the first common node, so I return it.
* If it is not in the set, I continue to the next node.
* If I reach `null`, the two lists do not intersect.

I compare the actual `ListNode` objects instead of their values.

This is important because:

```text
List A: 1 → 8
             \
List B: 3 → 1 → 8
```

The value `1` can appear in both lists but can represent different nodes.

---

## 3. Tracing the Algorithm

Consider:

```text
List A:

4 → 1 → 8 → 4 → 5

List B:

5 → 6 → 1 → 8 → 4 → 5
```

The lists share the nodes starting from `8`.

### Step 1: Store nodes from List A

We start with:

```text
current = 4
```

Add it:

```text
Set = {4}
```

Move to `1`:

```text
Set = {4, 1}
```

Move to `8`:

```text
Set = {4, 1, 8}
```

Move to the next `4`:

```text
Set = {4, 1, 8, 4}
```

Then:

```text
Set = {all nodes from List A}
```

The important thing is that the set contains node references, not just values.

---

### Step 2: Traverse List B

Start:

```text
5
```

Is this exact node in the set?

```text
No
```

Move to:

```text
6
```

Again:

```text
No
```

Move to:

```text
1
```

This particular `1` is a different node from the `1` in List A:

```text
No
```

Move to:

```text
8
```

Now this is the same node that appears in List A.

Therefore:

```text
8 ∈ Set
```

So we return this node.

The answer is:

```text
8
```

---

## 4. Time Complexity

**Time Complexity: O(m + n)**

Where:

* `m` is the number of nodes in `listA`.
* `n` is the number of nodes in `listB`.

First, we visit all `m` nodes in list A.

Then, in the worst case, we visit all `n` nodes in list B.

Therefore:

```text
O(m + n)
```

---

## Space Complexity

**Space Complexity: O(m)**

I store every node from the first list in a `HashSet`.

If list A contains `m` nodes, the set can contain `m` nodes.

Therefore:

```text
O(m)
```

additional memory is required.

---

## 5. Reflection / Improvement

The solution is already optimal in terms of time complexity because we need to examine the nodes of both lists.

However, the space complexity can be improved.

A better solution uses two pointers. One pointer starts at the beginning of list A and the other starts at the beginning of list B.

When a pointer reaches the end of its list, it starts again from the head of the other list.

This makes both pointers travel the same total distance.

The improved solution can achieve:

```text
Time Complexity: O(m + n)
Space Complexity: O(1)
```

The main thing that would need to change is removing the `HashSet` and using the two-pointer technique.

I used the `HashSet` solution first because it is easier to understand: remember all nodes from one list and check whether the second list contains one of them.
