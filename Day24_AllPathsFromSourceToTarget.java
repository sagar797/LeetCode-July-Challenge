//Problem: 

Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.


//Solution:

Algorithm
Run dfs from source vertex (0) and check every time if it reach to the destination which means we found a path add into the result set.
Call dfs for all child nodes of current vertex and spawn that many paths.

In below graph source vertex 0, destination vertex 3 - as we can see two path green and blue.

image

DFS

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList();
        dfs(graph, 0, graph.length - 1, new ArrayList(), result);
        return result;
    }
    
    private void dfs(int[][] graph, int source, int destination, List<Integer> list, List<List<Integer>> result) {
        if(source == destination) result.add(list); // if soruce reached destination add that path in result
        list.add(source); // add current vertex
        for(Integer vertex : graph[source]) {
            List<Integer> copyList = new ArrayList<>(list); // clone the path
            dfs(graph, vertex, destination, copyList, result);
        }
    }
}
BFS

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList();
        Queue<List<Integer>> queue = new LinkedList();
        queue.add(new ArrayList<>(Arrays.asList(0)));
        
        int destinationVertex = graph.length - 1;
        
        while(!queue.isEmpty()) {
            List<Integer> pathSoFar = queue.poll();
            int currentVertex = pathSoFar.get(pathSoFar.size() - 1);
            // check if currentVertex is destinationVertex add pathSoFar in result
            if(currentVertex == destinationVertex) result.add(new ArrayList(pathSoFar));
            for(int v : graph[currentVertex]) {
                List<Integer> newPath = new ArrayList(pathSoFar);
                newPath.add(v);
                queue.add(newPath);
            }
        }
        
        return result;
    }
}