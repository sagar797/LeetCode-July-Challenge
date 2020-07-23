//Problem:

Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.

Hints:
1.The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
2.An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
3.The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
4.Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).

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


//Ohter Solutions:

class Solution {
    public int nthUglyNumber(int n) {//1
        int[] ugly = new int[n];
        int i2=0, i3=0, i5=0;
        ugly[0] = 1;
        int min = 0;
        for(int i=1; i<n; i++){
            min = Math.min(2*ugly[i2], Math.min(3*ugly[i3], 5*ugly[i5]));
            ugly[i] = min;
            if(min==2*ugly[i2]){
                i2++;
            }
            if(min==3*ugly[i3]){    //not else-if since we can have duplicates
                i3++;
            }
            if(min==5*ugly[i5]){     //not else-if since we can have duplicates
                i5++;
            }
        }
        return ugly[n-1];
    }

    public int nthUglyNumber2(int n) {//2      
        TreeSet<Long> treeset = new TreeSet();
        treeset.add(1L);
        int c = 1;
        while(c<n){
            long x = treeset.pollFirst();
            c++;
            treeset.add(x*2);
            treeset.add(x*3);
            treeset.add(x*5);
        }
        return (int)((long)treeset.pollFirst());
    }
    public int nthUglyNumber3(int n) {//3
        if(n==1) return 1;
        PriorityQueue<Long> q = new PriorityQueue();
        q.add(1l);

        for(long i=1; i<n; i++) {
            long tmp = q.poll();
            while(!q.isEmpty() && q.peek()==tmp) tmp = q.poll();

            q.add(tmp*2);
            q.add(tmp*3);
            q.add(tmp*5);
        }
        return q.poll().intValue();
    }
}