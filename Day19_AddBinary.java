//problem:

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.


//Solution:

class Solution {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int sum = 0;
        int carry = 0;
        while(i>=0||j>=0){
            int a1=0;
            int b1=0;
            if (i>=0) a1 = a.charAt(i--) -'0';
            if (j>=0) b1 = b.charAt(j--) -'0';
            sum = a1 + b1 + carry;
            int sum2 = sum % 2;
            carry = sum / 2; 
            sb.append(sum2);
           
        }if(carry!=0) sb.append(carry);
         return sb.reverse().toString();
        
    }
    }