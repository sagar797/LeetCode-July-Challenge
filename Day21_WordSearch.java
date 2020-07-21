//Problem:

// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example:

// board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]

// Given word = "ABCCED", return true.
// Given word = "SEE", return true.
// Given word = "ABCB", return false.
 

// Constraints:

// board and word consists only of lowercase and uppercase English letters.
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3



//Solution:

class Solution {
    public boolean exist(char[][] board, String word) {
    
     boolean arr[][]=new boolean[board.length][board[0].length];   
     
     for(int i=0;i<board.length;i++)
      for(int j=0;j<board[i].length;j++)
          if(word.charAt(0)==board[i][j])  
             {   arr[i][j]=true; 
                 if(search(board,word.substring(1),i,j,arr))
                     return true;
                 else
                 arr[i][j]=false;
             }
        return false;
    }
    
        public boolean search(char [][]board,String word,int i,int j,boolean [][]arr)    
         {
            if(word.length()==0)
                 return true;
      
            if(i>=board.length || j>=board[0].length)
                 return false;
             
           // check downward if same and also not visiting  
           if( i<board.length-1 && board[i+1][j]==word.charAt(0) && !arr[i+1][j])
            {   arr[i+1][j]=true;
               if(search(board,word.substring(1),i+1,j,arr))
                   return true;
               else
                 arr[i+1][j]=false;  
            }
        
               // check right if same and also not visiting 
           if( j<board[0].length-1 && board[i][j+1]==word.charAt(0) && !arr[i][j+1])
            {   arr[i][j+1]=true;
               if(search(board,word.substring(1),i,j+1,arr))
                   return true;
               else
                 arr[i][j+1]=false;  
            } 
             
            // check left if same and also not visiting 
           if( j>0 && board[i][j-1]==word.charAt(0) && !arr[i][j-1])
            {    arr[i][j-1]=true;
                if(search(board,word.substring(1),i,j-1,arr))
                   return true;
                  else
                 arr[i][j-1]=false;  
            }
      
           // check upward if same and also not visiting   
           if( i>0 && board[i-1][j]==word.charAt(0) && !arr[i-1][j])
            {   arr[i-1][j]=true;
               if(search(board,word.substring(1),i-1,j,arr))
                   return true;
                 else
                 arr[i-1][j]=false;  
            }
            
          
      return false;
    }
    }