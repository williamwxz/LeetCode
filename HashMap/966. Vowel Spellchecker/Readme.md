# 966. Vowel Spellchecker

Difficulty: 3.5

A little bit tricky solution, there is a great approach, using one set, and two map
map1(lower case word: original word)
map2(lower case word with vowel replacement: original word)
1. Convert all word into lower case, put into map
2. Convert all word with replacement all vowels, put into map

Then the rest become very easy.