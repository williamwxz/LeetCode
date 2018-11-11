#940. Distinct Subsequences II

Difficulty: 4.5<br/>
<br/>
Non-typical DP problem, refer to discussion<br/>

Idea:<br/>
Create state as recording endwith<br/>
For example<br/>
"aba"<br/>

end with "a"
a: {"a"}

end with "b"
a: {"a"}
b: {"ab", "b"}

end with "a"
a: {"a", "aa", "aba", "ba"}
b: {"ab", "b"}

as we can see, everytime when try to iterate to next char, it use all previous string, add its current char, "a" -> "a", "aa", "aba", "ba",
and don't forget to add 1, for self

endwith{char} = sum(endwith)+1