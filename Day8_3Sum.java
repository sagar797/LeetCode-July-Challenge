//Probelm:

// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
// Note:
// The solution set must not contain duplicate triplets.

// Example:
// Given array nums = [-1, 0, 1, 2, -1, -4],
// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

// Hints:
// 1. So, we essentially need to find three numbers x, y, and z such that they add up to the given value. If we fix one of the numbers say x, we are left with the two-sum problem at hand!
// 2. For the two-sum problem,if we fix one of the numbers say x,we have to scan the entire array to find the next number y which is value - x where value is the input parameter. Can we change our array somehow so that this search becomes faster?
// 3. The second train of thought for two-sum is, without changing the array, can we use additional space somehow? Like maybe a hash map to speed up the search?

// solution:

Arrays.sort(nums);
    
for(int i=0;i<nums.length-2;i++)
 {  
   if(i>0 && nums[i]==nums[i-1]) continue; // skip duplicate elements  
    TwoSum(nums,i);   
 }    
 return ans;   
}
List<List> ans=new ArrayList<>();

public void TwoSum(int []nums,int k)
{
  int no=-(nums[k]);
  int i=k+1,j=nums.length-1;
 
  while(i<j)
   { 
      if(nums[i]+nums[j]>no)
         j--;
      
      else if(nums[i]+nums[j]<no)
          i++;
      
      else{
       ans.add(Arrays.asList(nums[k],nums[i],nums[j]));
      
       while(i<j && nums[i]==nums[i+1]) i++;
       while(i<j && nums[j]==nums[j-1]) j--;   
          i++; j--;
          }  
    }
 } 
}

//Another solution:

Video Explanation https://www.youtube.com/watch?v=nZyzf4ZxHWA
Idea The idea is similar to 2Sum. This kind of problem can be solved by using a similar approach, i.e., two pointers from both left and right, with the help HashSet to remove duplicate triplet if any we found.

Steps:

Sort the array.
Loop first loop with index i.
Initialize two index j = i + 1 & k from the end k = n - 1
loop until j < k
calculate sum = nums[i] + nums[j] + nums[k]
check sum and update pointer j & k
a. sum = 0 => we found triplet add into set and j++, k--
b. sum > 0 => k--
c. sum < 0 => j++
Example Dry Run

nums - [-1,0,1,2,-1,-4]
sorted - [-4,-1,-1,0,1,2]
n = 6

Loop for: i = 0
j = 1, k = 5
sum = -4  + -1 + 2 = -3 < 0 => j++

j = 2, k = 5
sum = -4  + -1 + 2 = -3 < 0 => j++

 j = 3, k = 5
sum = -4  + 0 + 2 = -2 < 0 => j++

 j = 4, k = 5
sum = -4  + 1 + 2 = -1 < 0 => j++

Loop for: i = 1
j = 2, k = 5
sum = -1  + -1 + 2 = 0 = 0 => j++, k--, {[-1, -1, 2]} 

j = 3, k = 4
sum = -1 + 0 + 1 = 0 = 0=> j++, k--, {[-1, -1, 2], [-1, 0, 1]} 

and so on.

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>(); // if nums less than 3 element
        Arrays.sort(nums); // sort array
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else if (sum < 0) j++;
            }

        }

        return new ArrayList<>(set);
    }
}
TC - O(n^2)

Recursive

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>(); // if nums less than 3 element
        Arrays.sort(nums); // sort array
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            helper(nums, i, i + 1, nums.length - 1, set);
        }

        return new ArrayList<>(set);
    }

    private void helper(int[] nums, int i, int j, int k, Set<List<Integer>> set) {
        if (j >= k) return;
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
            set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
            helper(nums, i, j, k, set);
        } else if (sum > 0) helper(nums, i, j, k - 1, set);
        else helper(nums, i, j + 1, k, set);
    }
}
If not already solved then try out:
2Sum https://leetcode.com/problems/two-sum/
4Sum https://leetcode.com/problems/4sum/

