
# 257. Binary Tree Paths

## 1. Problem

The task is to return all paths from the root of a binary tree to its leaves. Each path must be represented as a string, with node values separated by `->`.

## 2. Approach

I used recursive Depth-First Search (DFS).

The algorithm works as follows:
1. If the current node is null, stop.
2. Add the current node's value to the current path.
3. If the node is a leaf, add the completed path to the result list.
4. Otherwise, recursively explore the left and right subtrees using the updated path.

Each recursive call receives its own string value for the current path, so one branch does not overwrite another branch's path.

### Step-by-Step Trace

For the tree `[1, 2, 3, null, 5]`:

```text
    1
   / \
  2   3
   \
    5
```

1. Start at node `1`. Current path: `"1"`.
2. Move left to node `2`. Current path: `"1->2"`.
3. Move right to node `5`. Current path: `"1->2->5"`.
4. Node `5` is a leaf, so add `"1->2->5"` to the result.
5. Return to node `1` and move right to node `3`. Current path: `"1->3"`.
6. Node `3` is a leaf, so add `"1->3"` to the result.

Output: `["1->2->5", "1->3"]`

### Challenges and Testing

One challenge was ensuring that each path contains only the nodes belonging to its own branch. Another was recognizing that a path should be added to the result only when a leaf is reached.

I tested the solution with:
- A single node: `[1]` → `["1"]`
- A root with two leaf children: `[1, 2, 3]` → `["1->2", "1->3"]`
- A tree with a longer path: `[1, 2, 3, null, 5]` → `["1->2->5", "1->3"]`

The problem guarantees at least one node, but the implementation also safely handles a null root by returning an empty list.

## 3. Time Complexity

**Time Complexity: O(n + L)**

Here, `n` is the number of nodes and `L` is the total number of characters in all returned path strings.

Every node is visited once. Building and storing the path strings also requires time proportional to their total length. Therefore, `O(n + L)` is a more precise bound for this implementation.

## 4. Space Complexity

**Auxiliary Space Complexity: O(h)** for the recursive call stack, excluding the output.

The result list stores all paths, and the path strings can require additional memory proportional to their total length `L`. Therefore, total memory usage, including the output, is `O(h + L)`.

## 5. Reflection / Improvement

The current solution creates updated strings as it moves down the tree. A mutable `StringBuilder` with backtracking could reduce repeated string creation.

The traversal would still take time proportional to the nodes visited and the output produced. The improvement would mainly reduce intermediate string allocations rather than change the overall output-size requirement.
