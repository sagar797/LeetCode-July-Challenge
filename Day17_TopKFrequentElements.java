//Problem:

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.


Solution:

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        for (int num: nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>
            ((a, b) -> (cntMap.get(b) - cntMap.get(a)));
        
        for (int num: cntMap.keySet()) {
            pq.offer(num);
        }
        
        for (int index = 0; index < k; index++) {
            res[index] = pq.poll();
        }
        return res;
    }
}

//Another Solution:

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap < Integer, Integer > map = new HashMap < Integer, Integer > ();
        int[] res = new int[k];
        for (int i: nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        List < Integer > keyList = new ArrayList(map.keySet());
        Collections.sort(keyList, (a, b) -> map.get(b).compareTo(map.get(a)));
        for (int i = 0; i < k; i++)
            res[i] = keyList.get(i);
        return res;
    }
}
