//Problem:

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:
1 <= n <= 45

Hint: 
To reach nth step, what could have been your previous steps? (Think about the step sizes)


//Solution:

class Solution {
    public int climbStairs(int n) {
        return climbStairsHelper(n);
    }
    
    public static int climbStairsHelper(int n){
        int[] dp =new int[n+1];
        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            int val=0;
            if(i-1>=0){
                val+=dp[i-1];
            }
            if(i-2>=0){
                val+=dp[i-2];
            }
            dp[i]=val;
        }
        return dp[dp.length-1];
    }
    
}