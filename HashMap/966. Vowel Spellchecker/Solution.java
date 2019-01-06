class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n=queries.length;
        Set<String> words=new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> cap=new HashMap<>();
        Map<String, String> vowel=new HashMap<>();
        for (String word:wordlist){
            words.add(word);
            String lower=word.toLowerCase();
            String lowerVowel=lower.replaceAll("[aeiou]","#");
            cap.putIfAbsent(lower, word);
            vowel.putIfAbsent(lowerVowel, word);
        }
        for (int i=0; i<n; i++){
            if (!words.contains(queries[i])){
                String lower=queries[i].toLowerCase();
                String lowerVowel=lower.replaceAll("[aeiou]","#");
                if (cap.containsKey(lower))
                    queries[i]=cap.get(lower);
                else if (vowel.containsKey(lowerVowel))
                    queries[i]=vowel.get(lowerVowel);
                else
                    queries[i]="";
            }
        }
        return queries;
    }
}