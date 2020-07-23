//Problem:

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:
Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:

//Solution:

// Since the problem statement states that there is only one island in the matrix, we don't need to count the islands and neighbors as some other solutions in the thread describe.
// At every cell, check how many borders it has, and increase the count by that number.
// The complexity can be further optimized by finding the first cell and going through the island and performing a dfs to count the borders, which could save much time for a sparse island matrix.

class Solution {
    public int islandPerimeter(int[][] grid) {
    int res = 0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 1) {
                // i border top
                if (i == 0 || grid[i - 1][j] == 0) res++;
                // i border bottom
                if (i == grid.length - 1 || grid[i + 1][j] == 0) res++;
                // j border top
                if (j == 0 || grid[i][j - 1] == 0) res++;
                // j border bottom
                if (j == grid[0].length - 1 || grid[i][j + 1] == 0) res++;
            }
        }
    }
    return res;
}
}

//Other Solns:
class Solution {
    public int islandPerimeter(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count+=4;
                    if(i-1>-1 && grid[i-1][j]==1)
                        count--;
                    if(j+1<grid[0].length && grid[i][j+1]==1)
                        count--;
                    if(i+1<grid.length && grid[i+1][j]==1)
                        count--;
                    if(j-1>-1 && grid[i][j-1]==1)
                        count--;
                }
            }
        }
        return count;
    }
}