//Problem:

// Write a program to find the n-th ugly number.
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

// Example:

// Input: n = 10
// Output: 12
// Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
// Note:  

// 1 is typically treated as an ugly number.
// n does not exceed 1690.

//Hints:
//1.The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
//2.An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
//3.The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
//4.Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).

//Solution:

class Solution {
    public int nthUglyNumber(int n) {
        if(n<=0) return 0;
		int a=0,b=0,c=0;
		List<Integer> al = new ArrayList<Integer>();
		al.add(1);
		while(al.size()<n)
		{
			int next_val = Math.min(al.get(a)*2,Math.min(al.get(b)*3,al.get(c)*5));
			al.add(next_val);
			if(al.get(a)*2==next_val) a++;
			if(al.get(b)*3==next_val) b++;
			if(al.get(c)*5==next_val) c++;
		}
		return al.get(al.size()-1);
    }
}