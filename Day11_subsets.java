// Problem:

// Given a set of distinct integers, nums, return all possible subsets (the power set).
// Note: The solution set must not contain duplicate subsets.
// Example:

// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

//Solution:

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {    
        permute(0,new ArrayList<>(),nums);
        return ans;
    }
    
   private void permute(int n,List<Integer>res,int[]nums){
       ans.add(new ArrayList<>(res));
       for(int i = n ;i < nums.length ; i++){
           res.add(nums[i]);
           permute(i+1,res,nums);
           res.remove(res.size()-1);
       }
    }
}