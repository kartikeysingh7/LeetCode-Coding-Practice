import java.util.*;

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0, emptyCells = 1; 

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    emptyCells++;
                }
            }
        }

        return helper(grid, startX, startY, emptyCells);
    }

    private int helper(int[][] grid, int i, int j, int emptyCells) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1) {
            return 0;
        }

        if (grid[i][j] == 2) {
            return emptyCells == 0 ? 1 : 0;
        }

        grid[i][j] = -1;
        emptyCells--;


        int paths = helper(grid, i + 1, j, emptyCells)
                  + helper(grid, i - 1, j, emptyCells)
                  + helper(grid, i, j + 1, emptyCells)
                  + helper(grid, i, j - 1, emptyCells);


        grid[i][j] = 0;
        emptyCells++;

        return paths;
    }
}