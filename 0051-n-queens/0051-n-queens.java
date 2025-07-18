class Solution {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result= new ArrayList<>();
         boolean board[][] = new boolean[n][n];
        queens(board, 0,result);
        return result;
    }
static void queens(boolean [][]board, int row, List<List<String>> result){
    if(row==board.length){
       result.add(display(board));
        return ;
    }
    int count = 0;
    //placing the queen and checking every row and colomn 
    for(int col=0; col<board.length;col++){
        //place the queeen if its place 
        if(isSafe(board,row,col)){
            board[row][col]=true;
            queens(board, row+1,result);
         board[row][col]=false;

        }
    }
  
}
private static boolean isSafe(boolean[][]board,int row, int col){
    for(int i=0; i<row; i++){
        if(board[i][col]){
            return false;
        }
    }
     //dioganal left 
    for(int i=row-1,j=col-1; i>=0&& j>=0;i--,j--){
        if(board[i][j]){
            return false;
        }
    }

    // dioganl right
    for(int i= row-1, j=col+1; i>=0 && j<board.length;i--,j++){
        if(board[i][j]){
            return false;
        }
    }
    return true;
}

private static List<String> display(boolean [][]board){
    List<String> res = new ArrayList<>();
    for(boolean []row : board){
         StringBuilder sb = new StringBuilder();
        for(boolean element : row){
            if(element){
                sb.append('Q');
            }else{
                sb.append('.');
            }
        }  
        res.add(sb.toString());
    }
    return res;
}


}