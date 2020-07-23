//Problem:

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.
Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.

//Solution:

class Solution {
    public int hammingDistance(int x, int y) {
        int res =0;
        while(x>0 || y>0){
            res = res + ((x%2 == y%2)?0:1);
            x=x/2;
            y=y/2;
        }
        return res;
    }
}

//More Solutions:

class Solution {
    public int hammingDistance1(int x, int y) {
        // Algorithm:
        // XOR has a value of 1 only when 2 bits are different:
        // XOR
        // a  b    a ^ b
        // -------------
        // 0  0      0
        // 0  1      1
        // 1  0      1
        // 1  1      0
        // 1. Use XOR as x ^ y.
        // 2. The number of bits set as 1 in x ^ y is our solution
        return Integer.bitCount(x^y);
    }
    public int hammingDistance2(int x, int y) {
        int lastBit = 1;
        int hammingDistance = 0;
        while(x!=0 || y !=0){
            
            // we check if the last bit of both the numbers are different or not
            // if we find different last bits for the numbers, we just increase 
            // the hamming distance by 1
            
            // Example: 
			// ---------
			// If  x=8 and y=5 i.e. x:1000 and y:0101 respectively
            // we do AND operation with 1 i.e. 0001 with the above two numbers
            // so after AND operation, 1000 & 0001 = 0000 and 0101 & 0001 = 0001
            // we get 0 and 1 respectively, which is not equal, so we increase hammingDistance
            if((x&lastBit) != (y&lastBit))
                hammingDistance++;
            
            // now we right shift the numbers
            // if numbers are x : 8 and y : 5 i.e. 1000 and 0101 respectively
            x = x >> 1;
            y = y >> 1;
            // after right shift 1 position they become
            // 0100 && 0010
        }// now we repeat the above process until x or y is zero
        
        return hammingDistance;    
    }
}
