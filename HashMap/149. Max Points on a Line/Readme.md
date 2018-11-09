#149. Max Points on a Line
Difficulty: 4.5<br/>

The most difficult parts are:<br/>
1. **NEVER NEVER NEVER** use Double as the key, because of precision issue<br/>
2. Use greatest common divisor, to make sure all keys are unique<br/>

Time: O(n^2)
Space: O(n)

