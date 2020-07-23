//Problem:
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

//Solution:
O(n^2) complexity :(
    
class Solution {
    public int[] singleNumber(int[] nums) {
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            int freq=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]==val){
                    freq++;
                }
            }
            if(freq==1){
                al.add(val);
            }
        }
        
        int res[]=new int[al.size()];
        for(int i=0;i<res.length;i++){
            res[i]=al.get(i);
        }
        return res;
    }
}

