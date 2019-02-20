# 502. IPO

Difficulty: 4.0

Greedy approach:
We always want the largest profit with lowest cost, but the current capital keep changing, how to pick the right profit with lowest cost?
1. Sorted the project by its cost
2. Push the project into a heap (max heap), for all project less than current capital
3. Pop the largest profit, add to current capital
4. Return current capital