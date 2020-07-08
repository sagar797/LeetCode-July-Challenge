//Problem:

// Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
// You may assume the integer does not contain any leading zero, except the number 0 itself.

// Example 1:

// Input: [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Example 2:

// Input: [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.

//Solution:

class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i]<9){
                //first non-9 will be incremented by 1 and then the result is returned
                digits[i] = digits[i] + 1;
                return digits;
            }
            //if it is 9, make it zero. we're incrementing first non-9 above.
            digits[i] = 0;
        }
            
        //if we reached here that means we have a case where array consists of all nines.  
        //In that case, the array is all zeroes. we just need to make 0th position 1. 
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}