# 843. Guess the Word

Difficulty: 4.0

Never seen such problem before, the simple approach would be
1. Starting from random guess a word, get the number of matched 
2. Reconstruct the list with the words that matched the number
3. loop until all letter matched

Advanced approach
1. Similiar above, but not random guess the word
2. Build a counter of matched words
3. Use the minimum counter word to guess word