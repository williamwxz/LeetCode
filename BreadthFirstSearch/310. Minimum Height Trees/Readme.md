#310. Minimum Height Trees

Difficult: 4

(1) A tree is an undirected graph in which any two vertices are
connected by exactly one path.

(2) Any connected graph who has n nodes with n-1 edges is a tree.

(3) The degree of a vertex of a graph is the number of
edges incident to the vertex.

(4) A leaf is a vertex of degree 1. An internal vertex is a vertex of
degree at least 2.

(5) A path graph is a tree with two or more vertices that is not
branched at all.

(6) A tree is called a rooted tree if one vertex has been designated
the root.

(7) The height of a rooted tree is the number of edges on the longest
downward path between root and a leaf.

**Note**
1. If there are less than or equal to **TWO** node, then they are must be MHT

Thought process:
Must construct graph with map, or list

Idea 1:
Using bfs on each node, get their height, and use the minimum one
It will TLE, but this approach is almost correct

Idea 2:
Using topological sort concept, start from the leaf node (indegree 1), when only two nodes left, return

Improve from Idea 2:
Instead of using map to construct graph, use list of list, and avoid removal operation, by using indegrees variable