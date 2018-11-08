Difficulty: 3.5
**934. Shortest Bridge**
Every graph question for asking shorest path/step, think about using bfs first<br />
In this case, there are two islands, first algorithm comes in mind is union find

1. use union find to get cluster<br />
2. use bfs to get shortest path<br />

There are other solutions:<br />
Since there are always **TWO** islands<br />
1. use dfs to modify one of cluster, from "1" to "2"
2. use bfs to get shorest path, start from the second island

