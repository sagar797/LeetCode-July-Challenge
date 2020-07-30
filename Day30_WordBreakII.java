//Problem:

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]



//Solution:

class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        List<String>[] str = DP(s, wordDict, dp);
        if(!dp[n]) return Collections.emptyList();

        List<String> result = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        backtracking(result, builder, 0, str);
        return result;
    }

    private void backtracking(List<String> result, StringBuilder builder, int index, List<String>[] str) {

        if(index == str.length - 1) {
            result.add(builder.deleteCharAt(builder.length() - 1).toString());
            return;
        }
        List<String> list = str[index];
        for(String next : list) {
            int size = builder.length();
            builder.append(next);
            builder.append(" ");
            backtracking(result, builder, index + next.length(), str);
            builder.delete(size, builder.length());
        }

    }

    private List<String>[] DP(String s, List<String> wordDict, boolean[] dp) {

        List<String>[] str = new List[dp.length];
        for(int i = 0; i < dp.length - 1; i++) {
            if(dp[i]) {
                List<String> list = new LinkedList<>();
                for (String word: wordDict) {
                    if(s.indexOf(word, i) == i) {
                        dp[i + word.length()] = true;
                        list.add(word);
                    }
                }
                str[i] = list;
            }
        }
        return str;
    }
}