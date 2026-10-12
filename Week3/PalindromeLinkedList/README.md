# Palindrome Linked List

## 1. Problem

The task is to determine whether the values in a singly linked list form a palindrome.

A palindrome reads the same from left to right and from right to left.

For example:

```text
1 → 2 → 2 → 1
```

is a palindrome, so the answer is:

```text
true
```

But:

```text
1 → 2
```

is not a palindrome, so the answer is:

```text
false
```

---

## 2. Approach

A singly linked list only allows us to move forward.

Because of this, it is not convenient to compare the first and last nodes directly.

My approach is to first copy all node values into an `ArrayList`.

For example:

```text
Linked List:

1 → 2 → 2 → 1

ArrayList:

[1, 2, 2, 1]
```

Then I use two indexes:

* `left` starts from the first element.
* `right` starts from the last element.

I compare:

```text
values[left]
```

with:

```text
values[right]
```

If they are different, the list is not a palindrome.

If they are equal, I move both indexes toward the center.

The process continues until `left >= right`.

If all pairs are equal, the list is a palindrome.

---

## 3. Tracing the Algorithm

Consider:

```text
head = 1 → 2 → 2 → 1
```

### Step 1: Copy values

We traverse the linked list.

First:

```text
current = 1
```

ArrayList:

```text
[1]
```

Next:

```text
current = 2
```

ArrayList:

```text
[1, 2]
```

Next:

```text
current = 2
```

ArrayList:

```text
[1, 2, 2]
```

Next:

```text
current = 1
```

ArrayList:

```text
[1, 2, 2, 1]
```

Now the linked list has been converted into an array-like structure.

---

### Step 2: Compare from both sides

Initially:

```text
left = 0
right = 3
```

Compare:

```text
values[0] = 1
values[3] = 1
```

They are equal.

Move the pointers:

```text
left = 1
right = 2
```

---

### Step 3

Compare:

```text
values[1] = 2
values[2] = 2
```

They are equal.

Move again:

```text
left = 2
right = 1
```

Now:

```text
left >= right
```

The loop stops.

No different pair was found, so we return:

```text
true
```

---

### Example of a non-palindrome

Consider:

```text
1 → 2 → 3
```

ArrayList:

```text
[1, 2, 3]
```

Compare:

```text
left = 0
right = 2

1 != 3
```

The values are different, so we immediately return:

```text
false
```

---

## 4. Time Complexity

**Time Complexity: O(n)**

The algorithm has two main parts.

First, I traverse the entire linked list to store its values:

```text
O(n)
```

Then I compare the values from both ends.

At most, I compare approximately half of the elements:

```text
O(n)
```

Together:

```text
O(n) + O(n) = O(n)
```

Therefore, the final time complexity is:

```text
O(n)
```

---

## Space Complexity

**Space Complexity: O(n)**

I store all `n` values in an `ArrayList`.

Therefore, if the linked list contains `n` nodes, the ArrayList can also contain `n` values.

So the additional space is:

```text
O(n)
```

---

## 5. Reflection / Improvement

Yes, this solution can be improved in terms of space complexity.

The problem specifically asks whether we can solve it using `O(1)` extra space.

A better approach is:

1. Find the middle of the linked list using slow and fast pointers.
2. Reverse the second half of the linked list.
3. Compare the first half with the reversed second half.
4. Optionally restore the second half to keep the original list structure.

This approach still takes:

```text
Time Complexity: O(n)
```

but reduces the additional memory to:

```text
Space Complexity: O(1)
```

The main disadvantage is that the improved algorithm is more complicated because it requires reversing part of the linked list.

My `ArrayList` solution is easier to understand and is a good first solution before moving to the constant-space version.
